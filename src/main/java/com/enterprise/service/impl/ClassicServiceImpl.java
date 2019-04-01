package com.enterprise.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.enterprise.dao.ClassicDao;
import com.enterprise.dao.ServersManage;
import com.enterprise.service.ClassicService;

@Service("classicService")
public class ClassicServiceImpl extends ServersManage<com.enterprise.entity.Classic,ClassicDao> implements ClassicService{

    @Override
    @Resource(name="classicDao")
    public void setDao(ClassicDao dao) {
        this.dao = dao;
    }
}
