package com.enterprise.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.enterprise.dao.BaseDao;
import com.enterprise.dao.ClassicDao;
import com.enterprise.entity.Classic;
import com.enterprise.entity.page.PageModel;

@Repository("classicDao")
public class ClassicDaoImpl implements ClassicDao{
	
	    @Resource
	    private BaseDao dao;

	    public void setDao(BaseDao dao) {
	        this.dao = dao;
	    }

	    @Override
	    public int insert(Classic classic) {
	        return dao.insert("classic.insert",classic);
	    }

	    @Override
	    public int delete(Classic classic) {
	        return dao.delete("classic.delete",classic);
	    }

	    @Override
	    public int update(Classic classic) {
	        return dao.update("classic.update",classic);
	    }

	    @Override
	    public Classic selectOne(Classic classic) {
	        return (Classic) dao.selectOne("classic.selectOne",classic);
	    }

	    @Override
	    public PageModel selectPageList(Classic classic) {
	        return dao.selectPageList("classic.selectPageList","classic.selectPageCount",classic);
	    }

	    @Override
	    public List<Classic> selectList(Classic classic) {
	        return dao.selectList("classic.selectList",classic);
	    }

	    @Override
	    public int deleteById(int id) {
	        return dao.delete("classic.deleteById",id);
	    }

	    @Override
	    public Classic selectById(int id) {
	        return (Classic) dao.selectOne("classic.selectById",id);
	    }
}
