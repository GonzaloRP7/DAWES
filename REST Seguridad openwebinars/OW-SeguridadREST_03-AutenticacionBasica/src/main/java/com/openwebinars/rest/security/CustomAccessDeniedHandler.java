package com.openwebinars.rest.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openwebinars.rest.error.ApiError;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Autowired
	ObjectMapper mapper;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.setContentType("application/json");
		
		ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, accessDeniedException.getMessage());
		String strApiError = mapper.writeValueAsString(apiError);
		
		PrintWriter writer = response.getWriter();
		writer.println(strApiError);
	}

}





