package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Topic;
import com.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopic()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(t-> topics.add(t));
		return topics;
	}
	
	public void addTopic(Topic topic)
	{
		topicRepository.save(topic);
	}
	
	public Topic getTopic(String id)
	{
		Optional<Topic> result = topicRepository.findById(id);
		if(result.isPresent())
		{
			return result.get();
		}
		return null;
	}
	
	public void deleteTopic(String id)
	{
		topicRepository.deleteById(id);
	}
	
}
