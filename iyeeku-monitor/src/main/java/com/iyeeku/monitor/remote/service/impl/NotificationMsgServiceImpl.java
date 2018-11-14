package com.iyeeku.monitor.remote.service.impl;

import com.iyeeku.monitor.remote.dao.INotificationMsgDao;
import com.iyeeku.monitor.remote.service.INotificationMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationMsgServiceImpl implements INotificationMsgService {

    private static Logger logger = LoggerFactory.getLogger(NotificationMsgServiceImpl.class);
    @Autowired
    private INotificationMsgDao iNotificationMsgDao;

    @Override
    public Map<String, String> getNotificationMsgResultMapByZJ(String zj) {
        return this.iNotificationMsgDao.getNotificationMsgResultMapByZJ(zj);
    }

}
