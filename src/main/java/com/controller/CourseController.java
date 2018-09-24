package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Course;
import com.model.Topic;
import com.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping("/courses/all")//This is not as per REST standard. This only for development purpose.
	public List<Course> getAllCourse()
	{
		return service.getAllCourse();
	}
	
	@GetMapping("topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String topicId, @PathVariable String id)
	{
		return service.getCourse(id);
	}
	
	@GetMapping("topics/{topicId}/courses")
	public List<Course> getCourseByTopic(@PathVariable String topicId)
	{
		return service.getCoursesForTopic(topicId);
	}
	
	@PostMapping("topics/{topicId}/courses")
	public String addCourse(@RequestBody Course course, @PathVariable String topicId) 
	{
		Topic topic = new Topic();
		topic.setId(topicId);
		course.setTopic(topic);
		service.saveCourse(course);
		return "Course Added";
	}
	
	@DeleteMapping("topics/{topicId}/courses/{id}")
	public String deleteCourse(@PathVariable String topicId, @PathVariable String id)
	{
		service.deleteCourse(id);
		return "Course deleted";
	}
	
}
