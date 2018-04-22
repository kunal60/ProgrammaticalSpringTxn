package com.neo.spring.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.neo.spring.dao.TicketBookingDao;

public class TicketBookingService {

	private TicketBookingDao dao;

	private PlatformTransactionManager manager;

	public void setDao(TicketBookingDao dao) {
		this.dao = dao;
	}

	public void setManager(PlatformTransactionManager manager) {
		this.manager = manager;
	}

	public void bookTicket(int userId, int ticketId, int totalNoTickets) {
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = manager.getTransaction(definition);

		try {
			int accountId = dao.getAccountId(userId);
			float price = dao.getPrice(ticketId);
			double totalAmount = price * totalNoTickets;
			dao.deductAmount(accountId, totalAmount);
			dao.reduceTicketCount(ticketId, totalNoTickets);
			manager.commit(status);
		} catch (Exception e) {

			manager.rollback(status);
			System.out.println("......" + e.getMessage());

		}
	}
}
