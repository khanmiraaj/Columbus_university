package com.cu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cu.helper.EmailUtils;

@SpringBootApplication
public class ColumbusUniversityApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(ColumbusUniversityApplication.class, args);
		
		
		
		/*
		 * EmailUtils emailUtils= applicationContext.getBean(EmailUtils.class);
		 * 
		 * String to="rohitha187gourabathuni@gmail.com"; String
		 * body="Hi Rohitha kaisi hai"; String subject="Testing";
		 * 
		 * boolean isSend= emailUtils.sendEmail(to, subject, body);
		 */
		 
		 
		
	}

}
