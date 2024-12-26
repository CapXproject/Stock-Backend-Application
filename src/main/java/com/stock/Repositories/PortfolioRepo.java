package com.stock.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stock.Entities.Portfolio;
import com.stock.Entities.User;
import java.util.List;

public interface PortfolioRepo  extends JpaRepository<Portfolio, Long> {

	
	// Custom Method 
	List<Portfolio> findByUser(User user);
}
