package com.brunostaine.api.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brunostaine.api.dtos.EmailDto;
import com.brunostaine.api.models.EmailModel;
import com.brunostaine.api.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);
		 return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
	}
}