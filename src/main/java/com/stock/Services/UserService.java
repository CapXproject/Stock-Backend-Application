package com.stock.Services;

import com.stock.Payload.UserDto;
import java.util.List;
public interface UserService {

	UserDto createUser(UserDto  userDto  );
	UserDto updateUser (UserDto userDto, Long userId);
	UserDto getUserById (Long userId);
	void deleteUser(Long userId);
	List<UserDto>  getAllUSer();
	
	// Login Method 
	String loginUser(String email,String password);

	
}
