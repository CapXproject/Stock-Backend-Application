package com.stock.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.Entities.Stocks;
import com.stock.Entities.User;

import java.util.List;
public interface StocksRepo extends JpaRepository<Stocks,Long> {

	// Custom method 
	List<Stocks> findByUser(User user);
}
