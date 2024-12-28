package com.stock.ServiceImpl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stock.Entities.User;
import com.stock.Payload.UserDto;
import com.stock.Repositories.UserRepo;
import com.stock.Services.HashCodePassword;
import com.stock.Services.UserService;

@Service
public class UserServiceImpl  implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper  modelMapper;
	
	@Autowired
	private HashCodePassword passwordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setTimeStamp(new Date());
		try {
				userDto.setPassword(passwordEncoder.sha256Hash(userDto.getPassword().toUpperCase()));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		User  user = this.modelMapper.map(userDto,User.class);
		User  savedUser = this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User  user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		user.setUserName(userDto.getUserName());
		user.setAddress(user.getAddress());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setTimeStamp(userDto.getTimeStamp());
		return this.modelMapper.map(user,UserDto.class);
	}

	@Override
	public UserDto getUserById(Long userId) {
		User  user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		return this.modelMapper.map(user,UserDto.class);
	}

	@Override
	public List<UserDto> getAllUSer() {
		List<User> allUser = this.userRepo.findAll();
		List<UserDto>  convertedUser = allUser.stream().map((user)-> this.modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
		return convertedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		User  user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		this.userRepo.delete(user);
		
	}

	@Override
	public String loginUser(String email, String password) {
		User user = this.userRepo.findByEmail(email);
		String userpassword = user.getPassword();
		String haspassword="";
		try {
			haspassword = passwordEncoder.sha256Hash(password.toUpperCase());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userpassword.equals(haspassword))
		{
			return "Authentication Successfully Done...";
		}
		else {
			return "email Or password Invalid";
		}
	}

	
}
