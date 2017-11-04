package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

import java.util.List;

import org.apache.ibatis.annotations.Many;

@Mapper
public interface CourseMapper {
	
	@Select("select id_course, name, credits from course where id_course = #{idCourse}")
	@Results(value = {
		@Result(property="idCourse", column="id_course", javaType=String.class),
		@Result(property="name", column="name", javaType=String.class),
		@Result(property="credits", column="credits", javaType=Integer.class),
		@Result(property="students", column="id_course", javaType=List.class, many=@Many(select="selectStudents"))
	})
	CourseModel selectCourse(@Param("idCourse") String idCourse);
	
	@Select("select student.npm, name, gpa "
			+ "from studentcourse join student "
			+ "on studentcourse.npm = student.npm "
			+ "where studentcourse.id_course = #{idCourse}")
	List<StudentModel> selectStudents(@Param("idCourse") String idCourse);
}
