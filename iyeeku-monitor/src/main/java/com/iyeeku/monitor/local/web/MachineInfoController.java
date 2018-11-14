package com.iyeeku.monitor.local.web;

import com.iyeeku.core.vo.Pagination;
import com.iyeeku.monitor.local.service.IMachineInfoService;
import com.iyeeku.monitor.local.vo.MachineInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = "machine")
public class MachineInfoController {

    private Logger logger = LoggerFactory.getLogger(MachineInfoController.class);

    @Autowired
    private IMachineInfoService iMachineInfoService;

    @RequestMapping(value = "list" , method = RequestMethod.GET , name = "监控电脑展示页面")
    public ModelAndView machineInfoList(){
        return new ModelAndView("monitor/machineInfoList");
    }

    @RequestMapping(value = "query" , method = RequestMethod.POST , name = "监控电脑列表查询")
    @ResponseBody
    public Map<String,Object> query(MachineInfoVO vo,Pagination pagination) {
        return null;
    }




}
