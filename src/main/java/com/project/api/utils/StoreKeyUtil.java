package com.project.api.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class StoreKeyUtil {
	
	public String generateStoreKey() {
		SecureRandom secureRandom = new SecureRandom();

		byte[] bytes = new byte[32];
		secureRandom.nextBytes(bytes);

		String publicKey = Base64.getUrlEncoder()
		        .withoutPadding()
		        .encodeToString(bytes);
		
		return publicKey;
	}
	
}
