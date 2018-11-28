package com.iyeeku.watch.service.impl;

import com.iyeeku.watch.mapper.MachineInfoMapper;
import com.iyeeku.watch.service.MachineInfoService;
import com.iyeeku.watch.vo.MachineInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "machineInfoService")
public class MachineInfoServiceImpl implements MachineInfoService {

    private static Logger logger = LoggerFactory.getLogger(MachineInfoServiceImpl.class);

    @Autowired
    private MachineInfoMapper machineInfoMapper;

    @Override
    public List<Map> findMachineInfos(MachineInfoVO vo, int offSet, int pageSize) {
        return this.machineInfoMapper.findMachineInfos(vo,offSet,pageSize);
    }

    @Override
    public int findMachineInfosCount(MachineInfoVO vo) {
        return this.machineInfoMapper.findMachineInfosCount(vo);
    }
}
