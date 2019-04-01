package com.enterprise.controller.manage;

import com.enterprise.cache.FrontCache;
import com.enterprise.service.ClassicService;
import com.enterprise.service.Services;
import com.enterprise.entity.Classic;
import com.enterprise.controller.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 典型案例管理
 * Created by Cesiumai on 2016/7/26.
 */
@Controller
@RequestMapping("/manage/classic/")
public class ClassicAction extends BaseController<Classic>{
    private static final String page_toList = "/manage/classic/classicList";
    private static final String page_toEdit = "/manage/classic/classicEdit";
    private static final String page_toAdd = "/manage/classic/classicEdit";
    @Autowired
    private ClassicService classicService;
    @Autowired
    private FrontCache frontCache;
    @Override
    public Services<Classic> getService() {
        return classicService;
    }

    private ClassicAction() {
        super.page_toList=page_toList;
        super.page_toEdit=page_toEdit;
        super.page_toAdd=page_toAdd;
    }

    @Override
    public String insert(HttpServletRequest request, @ModelAttribute("e") Classic classic, RedirectAttributes flushAttrs) throws Exception {
        getService().insert(classic);
        insertAfter(classic);
        frontCache.loadClassic();
        addMessage(flushAttrs,"操作成功！");
        return "redirect:selectList";
    }

    @Override
    public String update(HttpServletRequest request, @ModelAttribute("e") Classic classic, RedirectAttributes flushAttrs) throws Exception {
        getService().update(classic);
        insertAfter(classic);
        frontCache.loadClassic();
        addMessage(flushAttrs, "操作成功！");
        return "redirect:selectList";
    }

    @Override
    @RequestMapping("deletes")
    public String deletes(HttpServletRequest request, String[] ids, @ModelAttribute("e") Classic classic, RedirectAttributes flushAttrs) throws Exception {
        getService().deletes(ids);
        frontCache.loadClassic();
        addMessage(flushAttrs,"操作成功！");
        return "redirect:selectList";
    }
}
