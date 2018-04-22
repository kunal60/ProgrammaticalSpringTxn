package com.neo.spring.dao;

import java.sql.SQLException;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TicketBookingDao extends JdbcDaoSupport {

	public int getAccountId(int userId) throws SQLException {
		int accountId = 0;
		String query = "select Account_Id from User_Table where user_Id= " + userId;
		accountId = getJdbcTemplate().queryForInt(query);
		return accountId;
	}

	public float getPrice(int ticketId) throws SQLException {
		float price = 0;
		String query = "select Ticket_Price from Movie_Ticket where Ticket_Id= " + ticketId;
		price = (Float) getJdbcTemplate().queryForObject(query, Float.class);
		return price;
	}

	public void deductAmount(int accountId, double amount) throws SQLException {

		String query = "Update Account SET BAL= BAL-" + amount + "where AccNo=" + accountId;
		getJdbcTemplate().execute(query);
	}

	public void reduceTicketCount(int ticketId, int noOfTickets) throws SQLException {

		String query = "Update Movie_Ticket SET Ticket_Count= Ticket_Count-" + noOfTickets + "where Ticket_Id="
				+ ticketId;
		getJdbcTemplate().execute(query);
	}

}
