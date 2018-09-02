package com.iyeeku.ext.role.service.impl;

import com.iyeeku.ext.role.dao.IPFRoleDao;
import com.iyeeku.ext.role.service.IPFRoleService;
import com.iyeeku.ext.role.vo.PFRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("iPFRoleService")
public class PFRoleServiceImpl implements IPFRoleService {

    private final Logger logger = LoggerFactory.getLogger(PFRoleServiceImpl.class);

    @Resource(name="iPFRoleDao")
    private IPFRoleDao iPFRoleDao;

    @Override
    public List<PFRole> findAllRoles() {
        this.logger.info("PFRoleServiceImpl findAllRoles");
        return this.iPFRoleDao.findAllRoles();
    }
}