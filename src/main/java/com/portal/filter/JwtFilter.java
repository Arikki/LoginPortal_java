package com.portal.filter;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portal.service.UserService;
import com.portal.utility.JwtUtility;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtility jwtUtil;
	
	@Autowired
	private UserService userSvc;

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		filterChain.doFilter(request, response);
//	}
//Below was causing an issue like not sending the req to controller	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authorization = request.getHeader("Authorization");
		
		String token = null;
		String userName = null;
		
		if(null != authorization && authorization.startsWith("Bearer")) {
			
			token = authorization.substring(7);
			userName = jwtUtil.getUsernameFromToken(token);
					
		}
		
		if (null!=userName && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userSvc.loadUserByUsername(userName);
			
			if (jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken credAuthToken 
									= new UsernamePasswordAuthenticationToken (userDetails,
											null,userDetails.getAuthorities());
				credAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(credAuthToken);
									
			}
			
		}
		
		filterChain.doFilter(request, response);
	}

}
