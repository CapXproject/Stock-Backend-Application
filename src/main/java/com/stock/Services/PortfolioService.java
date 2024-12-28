package com.stock.Services;

import com.stock.Payload.PortfolioDto;
import  java.util.List;
public interface PortfolioService {

	PortfolioDto   createPortfolio(  PortfolioDto  portfolioDto ,Long userId);
	PortfolioDto   updatePortfolio( PortfolioDto  portfolioDto,Long portfolioId);
	PortfolioDto   getById (Long portfolioId);
	void deletePortfolio(Long portfolioId);
	List<PortfolioDto>  getAll();
	
	List<PortfolioDto> getPortfolioByUserId (Long userId);
}
