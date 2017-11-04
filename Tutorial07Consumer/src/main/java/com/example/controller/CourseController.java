package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.model.CourseModel;
import com.example.service.CourseService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
public class CourseController {
	
	@Autowired
	CourseService courseDAO;
	
	@RequestMapping("/course/view/{id}")
	public String view(Model model, 
			@PathVariable(value = "id") String id) {
		
		CourseModel course = courseDAO.selectCourse(id);
		
		if (course != null) {
            model.addAttribute ("course", course);
            model.addAttribute("title", "Lihat Course");
            return "view-course";
        } else {
            model.addAttribute ("id", id);
            return "not-found-course";
        }
	}
	
	@RequestMapping("/course/viewall")
	public String viewall(Model model) {
		List<CourseModel> courses = courseDAO.selectAllCourse();
		model.addAttribute("courses", courses);
		
		return "view-all-courses";
	}
	
}
