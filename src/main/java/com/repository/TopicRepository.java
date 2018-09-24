package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
