package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableBinding(Source.class)
public class DemoGenerator {


	@Autowired
	Source source;

	@Scheduled(fixedRate = 1000)
	public void generateMessage(){

		this.source.output().send(MessageBuilder.withPayload("Test Message").build());

	}


}
