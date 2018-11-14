package com.iyeeku.monitor.remote.api;

import com.iyeeku.core.mq.sender.SendMessage;
import com.iyeeku.core.util.JsonUtil;
import com.iyeeku.monitor.remote.service.IMobileRemoteService;
import com.iyeeku.monitor.remote.vo.ResponseMsg;
import com.iyeeku.monitor.util.MachineStatusQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/remoctr/")
public class MobileRemoteController {

    private Logger logger = LoggerFactory.getLogger(MobileRemoteController.class);
    private static final int PAGESIZE = 10;

    @Autowired
    private IMobileRemoteService iMobileRemoteService;
    @Autowired
    private SendMessage sendMessage;

    @RequestMapping(value = "getMonitoredMachineList" , method = RequestMethod.POST , name = "获取被监控机器列表信息")
    @ResponseBody
    public ResponseMsg getMonitoredMachineList(@RequestBody(required = false) Map<String , Object> param){

        this.logger.info("接口getMonitoredMachineList接收参数:{}" , JsonUtil.bean2Json(param));

        ResponseMsg respMsg = generateRespMsgAndCheckReqParam(param);
        if ( !"1".equals(respMsg.getCode()) ){ //参数合法
            String deviceId = String.valueOf(param.get("deviceId"));
            int pageIndex = Integer.valueOf(String.valueOf(param.get("qqys") == null ? "0" : param.get("qqys")));
            List<Map<String,Object>> list = this.iMobileRemoteService.findMonitoredMachineListByDeviceId(deviceId , pageIndex , PAGESIZE);
            respMsg.formatSuccMsg();
            Map<String,Object> rtnMap = new HashMap<>();
            rtnMap.put("list" , list);
            respMsg.setData(rtnMap);
        }

        this.logger.info("接口getMonitoredMachineList响应结果:{}" , JsonUtil.bean2Json(respMsg));
        return respMsg;
    }

    @RequestMapping(value = "getMonitoredMachineInfo" , method = RequestMethod.POST , name = "获取被监控的机器信息")
    @ResponseBody
    public ResponseMsg getMonitoredMachineInfo(@RequestBody(required = false) Map<String , Object> param){

        this.logger.info("接口getMonitoredMachineInfo接收参数:{}" , JsonUtil.bean2Json(param));

        ResponseMsg respMsg = generateRespMsgAndCheckReqParam(param);
        if ( !"1".equals(respMsg.getCode()) ){ //参数合法
            String deviceId = String.valueOf(param.get("deviceId"));
            String zj = String.valueOf(param.get("zj"));

            Map<String,Object> dataMap = this.iMobileRemoteService.findMonitoredMachineInfoByZj(zj,deviceId);
            respMsg.formatSuccMsg();
            respMsg.setData(dataMap);
        }

        this.logger.info("接口getMonitoredMachineInfo响应结果:{}" , JsonUtil.bean2Json(respMsg));
        return respMsg;

    }

    @RequestMapping(value = "sendTaskToMachine" , method = RequestMethod.POST , name = "发送命令给机器")
    @ResponseBody
    public ResponseMsg sendTaskToMachine(@RequestBody(required = false) Map<String , Object> param){

        this.logger.info("接口sendTaskToMachine接收参数:{}" , JsonUtil.bean2Json(param));

        ResponseMsg respMsg = generateRespMsgAndCheckReqParam(param);
        if ( !"1".equals(respMsg.getCode()) ){ //参数合法

        }

        this.logger.info("接口sendTaskToMachine响应结果:{}" , JsonUtil.bean2Json(respMsg));
        return respMsg;
    }

    @RequestMapping(value = "sendStatusToMachine" , method = RequestMethod.POST , name = "修改电脑状态，用于调试")
    @ResponseBody
    public ResponseMsg sendStatusToMachine(@RequestBody(required = false) Map<String , Object> param){
        ResponseMsg respMsg = generateRespMsgAndCheckReqParam(param);
        if ("1".equals(respMsg.getCode())){ //参数不合法
            return respMsg;
        }else{
            String deviceId = String.valueOf(param.get("deviceId"));
            String zj = String.valueOf(param.get("zj"));
            String zt = String.valueOf(param.get("zt"));
            Map<String,Object> dataMap = this.iMobileRemoteService.findMonitoredMachineInfoByZj(zj,deviceId);
            if (dataMap == null || dataMap.size() == 0){
                respMsg.setCode("1");
                respMsg.setMsg("您没有权限修改!");
                return respMsg;
            }else{
                this.iMobileRemoteService.updateMachineStatus(zj,zt);
                //String text = JsonUtil.bean2Json(dataMap);
                this.sendMessage.sendTextMessage(zj);
                respMsg.formatSuccMsg();
                return respMsg;
            }
        }
    }



    @RequestMapping(value = "debugTakeMsgFromQueue",method = {RequestMethod.POST , RequestMethod.GET} , name = "修改电脑状态，用于调试")
    @ResponseBody
    public void debugTakeMsgFromQueue(@RequestParam int count){
        try {
            String info = "";
            for (int i = 0 ; i < count ; i++) {
                String value = MachineStatusQueue.queue.take();
                info += value + " , ";
            }
            System.out.println(info);
        }catch (InterruptedException ex){

        }
    }

    private ResponseMsg generateRespMsgAndCheckReqParam(Map<String,Object> param){
        ResponseMsg respMsg = new ResponseMsg();
        if (param == null || param.size() == 0){
            respMsg.setCode("1");
            respMsg.setMsg("参数错误，请求参数不能为空！");
        }else{
            if (param.get("deviceId") == null){
                respMsg.setCode("1");
                respMsg.setMsg("参数错误，设备ID不能为空！");
            }
        }
        return respMsg;
    }

}
