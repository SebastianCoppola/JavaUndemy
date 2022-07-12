package com.luv2code.springdemo;
import java.util.Random;

public class RandomFortuneServices implements FortuneService {
	
	public String fortune[] = {"Let's go!","Start now!","Your time is this!"};
	
	@Override
	public String getFortune() {
		Random r = new Random();
		int randomIndex = r.nextInt(this.fortune.length);
		return this.fortune[randomIndex];
	}
	
	

}
