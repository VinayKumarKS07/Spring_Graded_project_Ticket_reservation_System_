package com.gl.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Ticket_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String ticketTitle;
	
	String ticketShortDescription;
	
	LocalDate date;
	
	
}
