package com.stringcodeltd.studentapp;

import com.stringcodeltd.studentapp.service.InAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class StudentappApplication {

//	@Autowired
//	private InAppService senderService;
	public static void main(String[] args) {
		SpringApplication.run(StudentappApplication.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail(){
//		senderService.sendEmail("ryderflynn06@gmail.com", "subject of the mail sent", "this is the body of the email");
//	}

}
