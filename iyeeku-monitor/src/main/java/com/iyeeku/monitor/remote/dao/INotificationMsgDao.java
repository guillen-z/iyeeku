package com.iyeeku.monitor.remote.dao;

import java.util.Map;

public interface INotificationMsgDao {

    public abstract Map<String, String> getNotificationMsgResultMapByZJ(String zj);

}
