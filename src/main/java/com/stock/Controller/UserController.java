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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.stock.Payload.ApiResponse;
import com.stock.Payload.LoginRequest;
import com.stock.Payload.UserDto;
import com.stock.Services.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {
    
	@Autowired
	private UserService  userService;
	
	@PostMapping("/user/create")
	ResponseEntity<UserDto> createUser(@RequestBody UserDto  userDto)
	{
	UserDto savedUser = this.userService.createUser(userDto);	
		return new ResponseEntity<UserDto>(savedUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/user/update/{userId}")
	ResponseEntity<UserDto> updateUser(@RequestBody  UserDto userDto,@PathVariable Long userId)
	{
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	ResponseEntity<UserDto>  getUserById(@RequestBody @PathVariable Long userId)
	{
		UserDto getUser = this.userService.getUserById(userId);
		return new ResponseEntity<UserDto>(getUser,HttpStatus.OK);
	}
	
	@GetMapping("/user/all")
    ResponseEntity<List<UserDto>> getAllUser()
	{
		 List<UserDto>  users = this.userService.getAllUSer();
		 return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
	}
	
	@DeleteMapping("/user/delete/{userId}")
	ResponseEntity<ApiResponse>  deleteUser(@RequestBody  @PathVariable Long  userId)
	{
	   this.userService.deleteUser(userId);
	   return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully..",true),HttpStatus.OK);
	}
	
	@PostMapping("/user/login")
	ResponseEntity<ApiResponse>  loginUser(@RequestBody LoginRequest  loginRequest)
	{
	   String response = this.userService.loginUser(loginRequest.getEmail(),loginRequest.getPassword());
	   return new ResponseEntity<ApiResponse>(new ApiResponse(response , true),HttpStatus.OK);
	}
	
}
