package com.iyeeku.monitor.local.dao.impl;

import com.iyeeku.core.orm.impl.BaseDaoImpl;
import com.iyeeku.monitor.local.dao.IMachineInfoDao;
import com.iyeeku.monitor.local.vo.MachineInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MachineInfoDaoImpl extends BaseDaoImpl implements IMachineInfoDao {

    private Logger logger = LoggerFactory.getLogger(MachineInfoDaoImpl.class);

    @Override
    public List<Map> findMachineInfos(MachineInfoVO vo, int offSet, int pageSize) {
        this.logger.info("iMachineInfoDao findMachineInfos");
        return this.queryAll_myBatis(
                "com.iyeeku.monitor.local.dao.IMachineInfoDao.findMachineInfos" , vo , offSet , pageSize);
    }

    @Override
    public int findMachineInfosCount(MachineInfoVO vo) {
        this.logger.info("iMachineInfoDao findMachineInfosCount");
        return this.queryOne_myBatis("com.iyeeku.monitor.local.dao.IMachineInfoDao.findMachineInfosCount" , vo);
    }
}
