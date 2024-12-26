package com.stock.Entities;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Stocks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;
	@Column(nullable = false,unique = true)
	private String stockName;
	@Column(nullable = false)
	private boolean ticker;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Long open;
	@Column(nullable = false)
	private Long close;
	@Column(nullable = false)
	private Long marketPrice;
	private Date timeStamp;
	
	@ManyToOne()
	private User user;
}
