package kr.co.tjoeun.member.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.client.AbstractClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.co.tjoeun.member.service.AlereayUserException;

@ControllerAdvice
public class CommonAdvice {

	
	@ExceptionHandler(AlereayUserException.class)
	public void sendRedirectLogin(HttpServletResponse response, AlereayUserException alereayUserException) throws IOException {
		response.sendRedirect("/login?error=true&exceptionMessage="+ URLEncoder.encode(alereayUserException.getMessage(),"UTF-8"));
	}
	
}
