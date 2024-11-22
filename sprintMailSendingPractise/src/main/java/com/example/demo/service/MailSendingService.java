package com.example.demo.service;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailSendingService {

	Logger logger = LoggerFactory.getLogger(MailSendingService.class);
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	String from;

	@Value("${to.email}")
	String to;

	public String sendMail(User user) {
		logger.info("<=========== cursor enter in to service method inside for sending mail ========>");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setSubject("This is from Ismail");
		message.setText("Hi Shaik Ismail How Are You If You Practise Well Then No One will Touch You...!!");
		message.setTo(to);
		javaMailSender.send(message);

		return "successfully send the mail";
	}

	// This method will send the html file to the client

	public String sendHtmlFileToClient(String file) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
			// getting html file content
			String loadHtmlTemplate = loadHtmlTemplate(file);

			messageHelper.setTo(to);
			messageHelper.setSubject("From IsmailAssociation");
			messageHelper.setFrom(from);
			messageHelper.setText(loadHtmlTemplate, true);

			javaMailSender.send(mimeMessage);
			return "successfully send the mail";
		} catch (Exception exception) {

		}
		return null;
	}

	public String loadHtmlTemplate(String fileName) throws Exception {
		ClassPathResource resource = new ClassPathResource("templates/" + fileName);
		return new String(Files.readAllBytes(Paths.get(resource.getURI())));
	}

}
