package com.rhine.gym.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rhine.gym.entity.Course;
import com.rhine.gym.service.CourseService;
import com.rhine.gym.util.Page;

@Controller

public class CourseController{
	
	@Autowired
	private CourseService CourseService;
	
	@RequestMapping("/findCourse")
	/*  public String findCourse(HttpServletRequest request, HttpServletResponse response) {
		 
		String cname=request.getParameter("cname");
        // 获取分页参数
       /* int start = 0;
        int count = 5;
       
        try {
            start = Integer.parseInt(request.getParameter("page.start"));
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }  /
        

        Page page = new Page(0,3);
 		 
		
        List<course> course = courseService.listCourseByName(cname);
        int total = courseService.getTotal();
        page.setTotal(total);
 
        request.setAttribute("course", course);
        request.setAttribute("page", page);
 
        return "findCourse";  */

		public ModelAndView listCourseByName(ModelAndView mav,String cname) {
			List<Course> courseList= CourseService.listCourseByName(cname);

   

	        Page page = new Page(0,5);

	        int total = courseList.size(); //取list的size（）得到个数
	        page.setTotal(total);
	     
			mav.addObject("course",courseList);
			mav.addObject("page",page);
			mav.setViewName("listCourse");
			return mav;	
    }

	
	
	  @RequestMapping("/addCourse")
	public String addCourse(HttpServletRequest request, HttpServletResponse response) {
		 
        Course cs=new Course();

        String tid = request.getParameter("tid");
        String cname = request.getParameter("cname");
        String cinfo = request.getParameter("cinfo");
        String ctype = request.getParameter("ctype");
        
        cs.setTid(tid);       
        cs.setCname(cname);
        cs.setCinfo(cinfo);
        cs.setCtype(ctype);
 
        CourseService.addCourse(cs);
 
        return "redirect:listCourse";
    }
	  
	  @RequestMapping("/deleteCourse")
	    public String deleteCourse(int cid) {
	        CourseService.deleteCourse(cid);
	        return "redirect:listCourse";
	    }
	 
	    @RequestMapping("/editCourse")
	    public ModelAndView editCourse(int cid) {
	        ModelAndView mav = new ModelAndView("editCourse");
	        Course cs = CourseService.getCourse(cid);
	        mav.addObject("course", cs);
	        return mav;
	    }   
	 
	    @RequestMapping("/updateCourse")
	    public String updateCourse(HttpServletRequest request, HttpServletResponse response) {
	 
	        Course cs=new Course();
	        
	        int cid=Integer.parseInt(request.getParameter("cid"));
	        String tid = request.getParameter("tid");
	        String cname = request.getParameter("cname");
	        String cinfo = request.getParameter("cinfo");
	        String ctype = request.getParameter("ctype");
	        
	        cs.setCid(cid);
	        cs.setTid(tid);       
	        cs.setCname(cname);
	        cs.setCinfo(cinfo);
	        cs.setCtype(ctype);
	        
	        CourseService.updateCourse(cs);
	        
	        return "redirect:listCourse";
	    }
	    

	    @RequestMapping("/listCourse")
	    public String listCourse(HttpServletRequest request, HttpServletResponse response) {
	 
	        // 获取分页参数
	        int start = 0;
	        int count = 5;
	 
	        try {
	            start = Integer.parseInt(request.getParameter("page.start"));
	            count = Integer.parseInt(request.getParameter("page.count"));
	        } catch (Exception e) {
	        }
	 

	        Page page = new Page(start, count); 
	 
	        List<Course> course = CourseService.list(page.getStart(), page.getCount());
	        int total = CourseService.getTotal();
	        page.setTotal(total);
	 
	        request.setAttribute("course", course);
	        request.setAttribute("page", page);
	 
	        return "listCourse";
	    }

}