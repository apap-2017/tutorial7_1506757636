package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.CourseDAO;
import com.example.model.CourseModel;
import com.example.model.StudentModel;

@Service
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CourseModel selectCourse(String id) {
		CourseModel course = restTemplate.getForObject("http://localhost:8080/rest/course/view/" + id,
				CourseModel.class);
		return course;
	}

	@Override
	public List<CourseModel> selectAllCourse() {
		ResponseEntity<List<CourseModel>> response = restTemplate.exchange("http://localhost:8080/rest/course/viewall/", HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<CourseModel>>() {
        });
		List<CourseModel> courses = response.getBody();
		return courses;
	}

}
