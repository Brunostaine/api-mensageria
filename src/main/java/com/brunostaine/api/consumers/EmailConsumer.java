package com.brunostaine.api.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.brunostaine.api.dtos.EmailDto;
import com.brunostaine.api.models.EmailModel;
import com.brunostaine.api.services.EmailService;

@Component
public class EmailConsumer {

	@Autowired
	EmailService emailService;

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void listen(@Payload EmailDto emailDto) {
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);
		System.out.println("Email status: " + emailModel.getStatusEmail().toString());
	}

}
