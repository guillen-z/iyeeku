package com.iyeeku.watch.mapper;

import com.iyeeku.watch.vo.MachineInfoVO;

import java.util.List;
import java.util.Map;

public interface MachineInfoMapper {

    public static final String BEANID = "machineInfoMapper";

    public abstract List<Map> findMachineInfos(MachineInfoVO vo , int offSet , int pageSize);

    public abstract int findMachineInfosCount(MachineInfoVO vo);


}
