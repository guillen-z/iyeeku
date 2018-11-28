package com.iyeeku.watch.service;

import com.iyeeku.watch.vo.MachineInfoVO;

import java.util.List;
import java.util.Map;

public interface MachineInfoService {

    public static final String BEANID = "machineInfoService";

    public abstract List<Map> findMachineInfos(MachineInfoVO vo , int offSet , int pageSize);

    public abstract int findMachineInfosCount(MachineInfoVO vo);

}
