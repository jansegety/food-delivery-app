package com.fdel.controller.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.fdel.entity.User;
import com.fdel.entity.User.Role;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 어플리케이션 가입시 
 * 회원가입 form 정보를 받아오는 
 * DTO 클래스입니다.
 */
@Data
@ToString
@NoArgsConstructor
public class JoinDto {
	
	String username;
	String password;
	String email;
	
	/**
	 * 인코더를 입력받아서 가진 정보(username, password, email)만으로 
	 * User 객체를 생성해줍니다. User의 권한은 default로 주문자
	 * {@code Role.ORDERER}로 설정됩니다.
	 * 
	 * @param passwordEncoder
	 * @return JoinDto가 가지고 있던 정보로 만들어진 User 객체가 반환됩니다.
	 */
	public User toUser(PasswordEncoder passwordEncoder) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(passwordEncoder.encode(password));
		newUser.setEmail(email);
		newUser.setRoles(new ArrayList<Role>(Arrays.asList(Role.ORDERER))); //default
		return newUser;
	}
	
}

