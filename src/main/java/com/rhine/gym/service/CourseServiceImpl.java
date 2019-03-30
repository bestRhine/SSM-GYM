package com.rhine.gym.service;

import org.springframework.stereotype.Service;

import com.rhine.gym.dao.CourseDao;
import com.rhine.gym.entity.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service

public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao CourseDao;

	//@Override
	public List<Course> listCourseByName(String cname){
		return CourseDao.listCourseByName(cname);
	}

	 public void addCourse(Course cs) {
	        CourseDao.addCourse(cs);
	    }
	 
	    public void deleteCourse(int cid) {
	        CourseDao.deleteCourse(cid);
	    }
	 
	    public void updateCourse(Course cs) {
	        CourseDao.updateCourse(cs);
	    }
	    
	    public Course getCourse(int cid) {
	    	return CourseDao.getCourse(cid);
	    }
	    
	    public List<Course> list(int start, int count) {
	        return CourseDao.list(start, count);
	    }
	    
	    public int getTotal() {
	        return CourseDao.getTotal();
	    }
}