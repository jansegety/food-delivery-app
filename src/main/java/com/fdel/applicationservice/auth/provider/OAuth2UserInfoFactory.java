package com.fdel.applicationservice.auth.provider;

import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2UserInfoFactory {

	static public OAuth2UserInfo getOAuth2UserInfo(OAuth2UserRequest userRequest, OAuth2User oauth2User)
	{
		OAuth2UserInfo oAuth2UserInfo = null;
		
		if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			oAuth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
			oAuth2UserInfo = new FaceBookUserInfo(oauth2User.getAttributes());
		} else {
			throw new IllegalArgumentException("잘못된 OAuth2UserRequest 입니다.");
		}
		
		return oAuth2UserInfo;
	}
	
}