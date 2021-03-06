package com.fdel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdel.applicationservice.ApplicationLoginService;
import com.fdel.controller.dto.JoinDto;

import lombok.RequiredArgsConstructor;

/**
 * 유저의 로그인 및 회원가입 요청을 처리하는 컨트롤러입니다.
 */
@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final ApplicationLoginService applicationLoginService;
	
	@GetMapping({"","/"})
	public String index() {
		return "/index";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@PostMapping("/join")
	public String join(JoinDto joinDto) {
		applicationLoginService.registByJoinDto(joinDto);
		return "redirect:/loginForm";
	}
}