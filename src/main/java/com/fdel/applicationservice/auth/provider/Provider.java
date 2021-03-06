package com.fdel.applicationservice.auth.provider;

import java.util.Arrays;

import lombok.Getter;

/**
 * Provider을 구분하기 위한 enum
 */
@Getter
public enum Provider{
	
	NONE("NONE"),
	GOOGLE("GOOGLE"),
	FACEBOOK("FACEBOOK"),
	NAVER("NAVER");
	
	private String provider;
	
	Provider(String provider){
		this.provider = provider;
	}
	
	/**
	 * String 타입의 provider 정보를 받아 Provider 타입으로 바꿔준다.
	 * 
	 * @param provider string타입의 provider 정보 ex) NONE, GOOGLE, FACEBOOK, NAVER
	 * @return string 타입의 provider 정보와 대응하는 Provider 타입의 provider 정보 반환
	 * @throws IllegalArgumentException 일치하는 Provider 타입이 없는 경우 던져진다.
	 */
	public static Provider ofString(String provider) {
		return Arrays.stream(Provider.values())
			.filter(e -> e.getProvider().equals(provider))
			.findAny()
			.orElseThrow(()-> new IllegalArgumentException("일치하는 OAuth 타입이 존재하지 않습니다."));
	}
}