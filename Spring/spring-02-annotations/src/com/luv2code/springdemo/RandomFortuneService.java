package com.luv2code.springdemo;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	@Value("${fortune1}")
	private String fortune1;
	@Value("${fortune2}")
	private String fortune2;
	@Value("${fortune3}")
	private String fortune3;
	@Value("${fortune4}")
	private String fortune4;
		
	@Override
	public String getFortune() {
		String fortune[] = {fortune1,fortune2,fortune3,fortune4};
		Random r = new Random();
		int randomIndex = r.nextInt(fortune.length);
		return fortune[randomIndex];
	}

}
