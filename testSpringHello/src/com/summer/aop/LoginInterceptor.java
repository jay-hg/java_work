package com.summer.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginInterceptor {
	@Before("execution (public void com.summer.DAO.DAO.add(com.summer.model.User))")
	public void beforeMethod() {
		System.out.println("method start!");
	}
}
