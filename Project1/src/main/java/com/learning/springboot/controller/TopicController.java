/**
 * 
 */
package com.learning.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.model.Topic;

/**
 * @author M1037484
 *
 */
@RestController
public class TopicController {

	@RequestMapping(value = "/Topics")
	public List<Topic> getTopics() {
		return Arrays.asList(new Topic("name1", "desc1"), new Topic("name2", "desc2"), new Topic("name1", "desc1"),
				new Topic("name2", "desc2"));
	}
}
