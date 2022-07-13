package com.luv2code.springdemo;
import org.springframework.stereotype.Component;

@Component
public class DBFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is the day! - DBFortuneService";
	}

}
