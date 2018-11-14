package com.iyeeku.monitor.local.dao;

import com.iyeeku.monitor.local.vo.MachineInfoVO;

import java.util.List;
import java.util.Map;

public interface IMachineInfoDao {

    public abstract List<Map> findMachineInfos(MachineInfoVO vo , int offSet , int pageSize);

    public abstract int findMachineInfosCount(MachineInfoVO vo);

}
