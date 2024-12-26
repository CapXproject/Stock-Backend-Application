package com.stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.stock.Payload.ApiResponse;
import com.stock.Payload.PortfolioDto;
import com.stock.Services.PortfolioService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PortfolioController {

	@Autowired
	private PortfolioService  portfolioService;
	
	@PostMapping("/user/{userId}/portfolio/create")
	ResponseEntity<PortfolioDto> createPortfolio(@RequestBody  PortfolioDto portfolioDto,@PathVariable Long userId)
	{
		PortfolioDto savedp = this.portfolioService.createPortfolio(portfolioDto,userId);
		return new ResponseEntity<PortfolioDto>(savedp,HttpStatus.CREATED);
	}
	
	@PutMapping("/portfolio/update/{portfolioId}")
	ResponseEntity<PortfolioDto> updatePortfolio(@RequestBody  PortfolioDto portfolioDto,@PathVariable Long portfolioId)
	{
		PortfolioDto savedp = this.portfolioService.updatePortfolio(portfolioDto, portfolioId);
		return new ResponseEntity<PortfolioDto>(savedp,HttpStatus.OK);
	}
	
	@DeleteMapping("/portfolio/delete/{PortfolioId}")
	ResponseEntity<ApiResponse> deletePortfolio(@RequestBody @PathVariable Long portfolioId)
	{
		this.portfolioService.deletePortfolio(portfolioId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Portfolio Deleted Successfully..",true),HttpStatus.OK);
	}
	
	@GetMapping("/portfolio/{portfolioId}")
	ResponseEntity<PortfolioDto> getById (@RequestBody @PathVariable Long portfolioId)
	{
		PortfolioDto  p = this.portfolioService.getById(portfolioId);
		return new ResponseEntity<PortfolioDto>(p,HttpStatus.OK);
	}
	
	@GetMapping("/portfolio/all")
	ResponseEntity<List<PortfolioDto>>getAll()
	{
		List<PortfolioDto> allp = this.portfolioService.getAll();
		return new ResponseEntity<List<PortfolioDto>>(allp,HttpStatus.OK);
	}
	
	
	@GetMapping("user/{userId}/portfolio")
	ResponseEntity<List<PortfolioDto>>getPortfolioByuserId(@RequestBody @PathVariable  Long userId)
	{
		List<PortfolioDto>  allp = this.portfolioService.getPortfolioByUserId(userId);
		return new ResponseEntity<List<PortfolioDto>>(allp,HttpStatus.OK);
	}
	
}
