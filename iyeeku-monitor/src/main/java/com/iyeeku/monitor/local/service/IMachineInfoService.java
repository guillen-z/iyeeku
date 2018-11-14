package com.iyeeku.monitor.local.service;

import com.iyeeku.core.vo.Pagination;
import com.iyeeku.monitor.local.vo.MachineInfoVO;

import java.util.Map;

public interface IMachineInfoService {

    public Map<String,Object> findAllMachineInfos(MachineInfoVO vo , Pagination pagination);

}
