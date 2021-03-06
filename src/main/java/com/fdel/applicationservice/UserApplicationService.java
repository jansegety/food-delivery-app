package com.fdel.applicationservice;

import org.springframework.stereotype.Service;

import com.fdel.entity.User;

/**
 * 유저와 관련된 어플리케이션 서비스 인터페이스다.
 */
@Service
public interface UserApplicationService {
	void regist(User user);
	User findByUserName(String userName);
}
