package com.flightbooking.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightbooking.app.security.JWTService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtService;

	@Override
	public User saveUser(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User deleteUserById(Integer uid) {
		User existingUser = userRepo.findById(uid).orElse(null);
		if (existingUser != null) {
			userRepo.deleteById(uid);
		}
		return existingUser;
	}

	@Override
	public List<User> findAllUser() {
		return userRepo.findAll();

	}

	@Override
	public User findUserById(Integer uid) {
		User existingUser = userRepo.findById(uid).orElse(null);
		return existingUser;

	}

	@Override
	public User updateUser(User user, Integer uid) {
		User existingUser = userRepo.findById(uid).orElse(null);
		if (existingUser != null) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
			existingUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			existingUser.setUserId(user.getUserId());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setEmailId(user.getEmailId());
			existingUser.setPassportNumber(user.getPassportNumber());
			return userRepo.save(existingUser);

		}
		return existingUser;
	}

	@Override
	public User authenticateUser(String userName, String password) {
		User user = userRepo.findByUserName(userName);
		
		
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
//	String encryptedPasswordOfUser=	bCryptPasswordEncoder.encode(user.getPassword());
//		String encryptedPasswordFromReq=bCryptPasswordEncoder.encode(password);
		if (authentication.isAuthenticated()) {
			jwtService.generateToken( userName);
			return user;
		}
		return null;
	}

}