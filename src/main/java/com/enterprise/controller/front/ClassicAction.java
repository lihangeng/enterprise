package com.enterprise.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.entity.Service;

@Controller("classicActionController")
public class ClassicAction {
	
	  /**
     * 跳转到“经典案例”
     * @return
     * @throws Exception
     */
    @RequestMapping("classic")
    public String service() throws Exception {
        return "/front/classic/classicList";
    }
    @RequestMapping("classic/{id}")
    public String selectOne(HttpServletRequest request, @ModelAttribute("id")@PathVariable("id") String id, @ModelAttribute("e") Service service) throws Exception {
        request.setAttribute("id", id);
        return "/front/classic/classicList";
    }

}
