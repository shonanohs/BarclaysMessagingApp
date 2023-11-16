package com.barclays;

import com.barclays.util.MessagePopulator;
import com.barclays.util.PersonPopulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BarclaysMessagingAppApplication {

	public static void main(String[] args) {

//		ApplicationContext context =
		SpringApplication.run(BarclaysMessagingAppApplication.class, args);
//		MessagePopulator messagePopulator = context.getBean(MessagePopulator.class);
//		messagePopulator.populate();
//
//		PersonPopulator personPopulator = context.getBean(PersonPopulator.class);
//		personPopulator.populate();

	}

}
