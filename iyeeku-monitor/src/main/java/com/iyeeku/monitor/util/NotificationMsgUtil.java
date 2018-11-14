package com.iyeeku.monitor.util;

import com.iyeeku.core.util.JsonUtil;
import com.iyeeku.monitor.remote.service.INotificationMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationMsgUtil {

    private static Logger logger = LoggerFactory.getLogger(NotificationMsgUtil.class);
    private static INotificationMsgService iNotificationMsgService;

    /**
     * spring 静态属性注入 ， 注意 setter 方法上的 static 不能加
     * @param iNotificationMsgService
     */
    @Autowired
    public void setiNotificationMsgService(INotificationMsgService iNotificationMsgService) {
        NotificationMsgUtil.iNotificationMsgService = iNotificationMsgService;
    }

    public static String getNotiMsgToRemoteClient(String zj){

        Map<String,String> notiMsgMap = iNotificationMsgService.getNotificationMsgResultMapByZJ(zj);

        MessageVO msgVO = new MessageVO(MessageCodeConstant.CODE_002);

        msgVO.setMsgText(notiMsgMap);

        return JsonUtil.bean2Json(msgVO);

    }

}
