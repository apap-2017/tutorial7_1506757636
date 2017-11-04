package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CourseMapper;
import com.example.model.CourseModel;

@Service
public class CourseServiceDatabase implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public CourseModel selectCourse(String idCourse) {
		CourseModel courseModel = courseMapper.selectCourse(idCourse);
		return courseModel;
	}

	@Override
	public List<CourseModel> selectAllCourse() {
		// TODO Auto-generated method stub
		return null;
	}

}
