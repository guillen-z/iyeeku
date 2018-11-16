package com.iyeeku.ext.commonPermission.service.impl;

import com.iyeeku.core.context.ContextUtil;
import com.iyeeku.core.security.IyeekuUserInfo;
import com.iyeeku.core.util.StringUtil;
import com.iyeeku.core.util.UUIDGenerator;
import com.iyeeku.ext.commonPermission.dao.CommonPermissionDao;
import com.iyeeku.ext.commonPermission.service.CommonPermissionService;
import com.iyeeku.ext.function.dao.PFResMenuDao;
import com.iyeeku.ext.function.vo.PFResMenuVO;
import com.iyeeku.ext.grant.dao.PFArcGrantDao;
import com.iyeeku.ext.grant.vo.PFArcGrantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class CommonPermissionServiceImpl implements CommonPermissionService {

    @Autowired
    private CommonPermissionDao commonPermissionDao;
    @Autowired
    private PFResMenuDao pfResMenuDao;
    @Autowired
    private PFArcGrantDao pfArcGrantDao;

    @Override
    public List<PFResMenuVO> findRoleMenu(String sqdxbh) {
        PFArcGrantVO arcGrantVO = new PFArcGrantVO();
        if (StringUtils.isEmpty(sqdxbh)){
            arcGrantVO.setSqdxbh("R99999998");
        }else{
            arcGrantVO.setSqdxbh(sqdxbh);
        }

        arcGrantVO.setSqzylx("CD");
        arcGrantVO.setJlzt("1");
        return this.commonPermissionDao.findRoleMenu(arcGrantVO);
    }

    @Override
    public List<PFResMenuVO> findPerParentMenu(String sqdxbh) {
        PFArcGrantVO arcGrantVO = new PFArcGrantVO();
        if (StringUtils.isEmpty(sqdxbh)){
            arcGrantVO.setSqdxbh("R99999998");
        }else{
            arcGrantVO.setSqdxbh(sqdxbh);
        }
        arcGrantVO.setSqzylx("CD");
        arcGrantVO.setJlzt("1");
        return this.commonPermissionDao.findPerParentMenu(arcGrantVO);
    }

    @Override
    public List<PFResMenuVO> findPerLeafMenu(String sqdxbh) {
        PFArcGrantVO arcGrantVO = new PFArcGrantVO();
        if (StringUtils.isEmpty(sqdxbh)){
            arcGrantVO.setSqdxbh("R99999998");
        }else{
            arcGrantVO.setSqdxbh(sqdxbh);
        }
        arcGrantVO.setSqzylx("CD");
        arcGrantVO.setJlzt("1");
        return this.commonPermissionDao.findPerLeafMenu(arcGrantVO);
    }

    @Override
    public Map<String, Object> findChooseAllMenu(String jsbh) {
        Map<String,Object> menuMap = new HashMap<>();
        PFResMenuVO menuVO = null;

        List<PFResMenuVO> allList = this.pfResMenuDao.findAllMenu();
        List<Map<String,String>> rtnList = new ArrayList<>();

        for (PFResMenuVO vo : allList){
            Map<String,String> rtnMap = new HashMap<>();
            rtnMap.put("id" , vo.getCdbh());
            rtnMap.put("text" , vo.getCdmc());
            rtnMap.put("pid" , vo.getSjcdbh());
            rtnMap.put("cdurl" , vo.getCdurl());
            rtnMap.put("cdlx" , vo.getCdlx());
            rtnMap.put("cdurlbh" , vo.getCdurl());
            rtnList.add(rtnMap);
        }
        menuMap.put("treeNodes" , rtnList);
        return menuMap;
    }

    @Override
    public List<PFArcGrantVO> findSSmkGrantInfo(Map<String, String> map) {
        return this.commonPermissionDao.findSSmkGrantInfo(map);
    }

    @Override
    public Boolean isExist(PFArcGrantVO arcGrantVO) {
        List<PFArcGrantVO> list = this.pfArcGrantDao.findGrantBySqdxbh(arcGrantVO);
        if (list != null && list.size() > 0){
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    @Override
    public void updateMenuOrUrlRolePer(PFArcGrantVO arcGrantVO) {
        arcGrantVO.setZhxgr(ContextUtil.getLoginUser().getUserId());
        arcGrantVO.setZhxgsj(new Date());
        this.commonPermissionDao.updateMenuOrUrlRolePer(arcGrantVO);
    }

    @Override
    public void addCommonPer(PFArcGrantVO arcGrantVO) {
        arcGrantVO.setCjr(ContextUtil.getLoginUser().getUserId());
        arcGrantVO.setCjsj(new Date());
        this.commonPermissionDao.addCommonPer(arcGrantVO);
    }

    @Override
    public void delMenuPer(PFArcGrantVO arcGrantVO) {
        arcGrantVO.setZhxgr(ContextUtil.getLoginUser().getUserId());
        arcGrantVO.setZhxgsj(new Date());
        this.commonPermissionDao.delMenuPer(arcGrantVO);
    }

    @Override
    public void delCommonPer(PFArcGrantVO arcGrantVO) {
        arcGrantVO.setZhxgr(ContextUtil.getLoginUser().getUserId());
        arcGrantVO.setZhxgsj(new Date());
        this.commonPermissionDao.delCommonPer(arcGrantVO);
    }

    @Override
    public void addUrlGrant(String sqdxbh, String[] sqzybms, String sqzylx, String cdurl, String cdbh) {
        PFArcGrantVO arcGrantVO = new PFArcGrantVO();
        Map<String,String> param = new HashMap<>();
        int size;

        if ("other".equals(cdurl)){

        }else {

            String gnssmk = StringUtil.getSSMK(cdurl);
            param.put("sqdxbh" , sqdxbh); //角色编号
            param.put("cdbh" , cdbh);
            param.put("gnssmk" , StringUtil.formatDbNoEscapeLeftLikeValue(gnssmk));
            this.commonPermissionDao.updateUrlGrantBySqdxbh(param);

        }

        arcGrantVO.setSqdxbh(sqdxbh);
        arcGrantVO.setSqzylx(sqzylx);
        arcGrantVO.setJlzt("1");

        IyeekuUserInfo userInfo = ContextUtil.getLoginUser();
        String opuser = userInfo.getUserCode();
        Date nowData = new Date();

        for (String sqzybm : sqzybms){

            arcGrantVO.setSqzybm(sqzybm);

            Boolean isE = isExist(arcGrantVO);
            if (isE.booleanValue()){

                arcGrantVO.setZhxgr(opuser);
                arcGrantVO.setZhxgsj(nowData);
                this.commonPermissionDao.updateMenuOrUrlRolePer(arcGrantVO);

            }else {
                String uuid = UUIDGenerator.generate("");
                arcGrantVO.setSqbzj(uuid);
                arcGrantVO.setCjr(opuser);
                arcGrantVO.setCjsj(nowData);

                this.commonPermissionDao.addCommonPer(arcGrantVO);
            }

        }

    }


}
