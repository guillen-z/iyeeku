package com.iyeeku.watch.mapper;

import com.iyeeku.watch.vo.PfCodeinfo;

import java.util.List;

public interface PfCodeinfoMapper {

    public static final String BEANID = "pfCodeinfoMapper";

    List<PfCodeinfo> findAllCodeinfos();

}