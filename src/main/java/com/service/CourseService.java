package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Course;
import com.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAllCourse()
	{
		List<Course> courses = new ArrayList<>();
		repository.findAll().forEach(courses::add);
		return courses;
	}
	
	public List<Course> getCoursesForTopic(String topicId)
	{
		return repository.findByTopicId(topicId);
	}
	
	public Course getCourse(String id)
	{
		Optional<Course> result = repository.findById(id);
		if(result.isPresent())
		{
			return result.get();
		}
		return null;
	}
	
	
	public void saveCourse(Course course)
	{
		repository.save(course);
	}
	
	public void deleteCourse(String id)
	{
		repository.deleteById(id);
	}
	
}
