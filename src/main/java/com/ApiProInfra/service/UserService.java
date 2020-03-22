//package com.ApiProInfra.service;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import com.ApiProInfra.Security.UserSS;
//
//public class UserService {
//	
//	public static UserSS authenticated() {
//		try {
//			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		}
//		catch (Exception e) {
//			return null;
//		}
//	}
//}
