package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Topic;
import com.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	@GetMapping("topics")
	public List<Topic> getAllTopic()
	{
		return topicService.getAllTopic();
	}
	
	@PostMapping("topics")
	public String addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
		return "Topic Added";
	}
	
	@DeleteMapping("topics/{id}")
	public String deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id);
		return "Topic removed";
	}
	
}
