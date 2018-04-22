package com.neo.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neo.spring.service.TicketBookingService;

public class Client {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static void main(String[] args) {
		TicketBookingService service = (TicketBookingService) context.getBean("bokingServiceRef");
		service.bookTicket(9002, 5002, 10);
		System.out.println("Successfully tickets are booked");
	}

}
