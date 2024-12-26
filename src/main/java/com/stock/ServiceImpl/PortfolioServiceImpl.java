package com.stock.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.Entities.Portfolio;
import com.stock.Entities.User;
import com.stock.Payload.PortfolioDto;
import com.stock.Repositories.PortfolioRepo;
import com.stock.Repositories.UserRepo;
import com.stock.Services.PortfolioService;

@Service
public class PortfolioServiceImpl  implements   PortfolioService {

	@Autowired
	private PortfolioRepo  portfolioRepo;
	
	@Autowired 
	private UserRepo  userRepo;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	@Override
	public PortfolioDto createPortfolio(PortfolioDto portfolioDto,Long userId) {
		 User  user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User  Not Found"));
		 portfolioDto.setTimeStamp(new Date());
		 Portfolio  p =  this.modelMapper.map(portfolioDto, Portfolio.class);
		 p.setUser(user);
		 Portfolio  saved  = this.portfolioRepo.save(p);
		 return this.modelMapper.map(saved, PortfolioDto.class);
	}

	@Override
	public PortfolioDto updatePortfolio(PortfolioDto portfolioDto, Long portfolioId) {
		Portfolio  p = this.portfolioRepo.findById(portfolioId).orElseThrow(()-> new RuntimeException("PortfolioNotFound"));
		p.setValue(portfolioDto.getValue());
		Portfolio updated =   this.portfolioRepo.save(p);
		return this.modelMapper.map(updated,PortfolioDto.class);
	}

	@Override
	public PortfolioDto getById(Long portfolioId) {
		Portfolio  p = this.portfolioRepo.findById(portfolioId).orElseThrow(()-> new RuntimeException("PortfolioNotFound"));
		
		return this.modelMapper.map(p,PortfolioDto.class);
	}

	@Override
	public void deletePortfolio(Long portfolioId) {
		Portfolio  p = this.portfolioRepo.findById(portfolioId).orElseThrow(()-> new RuntimeException("PortfolioNotFound"));
		this.portfolioRepo.delete(p);	
		
	}

	@Override
	public List<PortfolioDto> getAll() {
		List<Portfolio>  allPortfolio = this.portfolioRepo.findAll();
		List<PortfolioDto>  converted = allPortfolio.stream().map((p)->this.modelMapper.map(p, PortfolioDto.class)).collect(Collectors.toList());
		return converted;
	}

	@Override
	public List<PortfolioDto> getPortfolioByUserId(Long userId) {
		 User  user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User  Not Found"));
		List<Portfolio>  allPortfolio = this.portfolioRepo.findByUser(user);
		List<PortfolioDto>  converted = allPortfolio.stream().map((p)->this.modelMapper.map(p, PortfolioDto.class)).collect(Collectors.toList());
		return converted;
	}
	

}
