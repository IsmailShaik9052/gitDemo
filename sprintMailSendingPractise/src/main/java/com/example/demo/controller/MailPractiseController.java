package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.MailSendingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MailPractiseController {

	MailSendingService mailSendingService;

	@Autowired
	public MailPractiseController(MailSendingService mailSendingService) {
		this.mailSendingService = mailSendingService;

	}

	Logger logger = LoggerFactory.getLogger(MailSendingService.class);
	ObjectMapper mapper = new ObjectMapper();

	@PostMapping("/sending/mail")
	public String sendingMailToUser(@RequestBody User user) throws JsonProcessingException {
		logger.info("Front end params are ====> " + mapper.writeValueAsString(user));
		return mailSendingService.sendMail(user);

	}
	
	
	
	@PostMapping("/sending/htmlFile/email")
	public String sendHtmlFileToClient(@RequestParam String file) throws JsonProcessingException {
		logger.info("Front end params are ====> " + mapper.writeValueAsString(file));
		return mailSendingService.sendHtmlFileToClient(file);

	}
	
	
	
	

}
