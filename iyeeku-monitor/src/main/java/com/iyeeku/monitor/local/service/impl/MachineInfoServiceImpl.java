package com.iyeeku.monitor.local.service.impl;

import com.iyeeku.core.vo.Pagination;
import com.iyeeku.monitor.local.dao.IMachineInfoDao;
import com.iyeeku.monitor.local.service.IMachineInfoService;
import com.iyeeku.monitor.local.vo.MachineInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MachineInfoServiceImpl implements IMachineInfoService {

    private Logger logger = LoggerFactory.getLogger(MachineInfoServiceImpl.class);

    @Autowired
    private IMachineInfoDao iMachineInfoDao;

    @Override
    public Map<String, Object> findAllMachineInfos(MachineInfoVO vo, Pagination pagination) {

        List<Map> list = this.iMachineInfoDao.findMachineInfos(vo,
                pagination.getPageIndex()*pagination.getPageSize(),pagination.getPageSize());

        int total = this.iMachineInfoDao.findMachineInfosCount(vo);

        Map<String,Object> rtnMap = new HashMap<>();
        rtnMap.put("data",list);
        rtnMap.put("total",total);
        return rtnMap;
    }


}
