package com.abhi.microservice.imageService.ImageService;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.OncePerRequestFilter;

public class FiltersConfiguration {

	@Value("${javaMelodyPort:${server.port}}")
	private Integer javaMelodyPort;

	@Value("${javaMelodyPortOnly:true}")
	private Boolean javaMelodyPortOnly;

	@Bean(name = "javaMelodyRestrictingFilter")
	public FilterRegistrationBean javaMelodyRestrictingFilter(FilterRegistrationBean javaMelodyFilter) {
		Filter filter = new OncePerRequestFilter() {

			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
					FilterChain filterChain) throws ServletException, IOException {

				if (!javaMelodyPortOnly || request.getLocalPort() == javaMelodyPort) {
					filterChain.doFilter(request, response);
				} else {
					response.sendError(404);
				}
			}
		};
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(filter);
		filterRegistrationBean.setOrder(-100);
		filterRegistrationBean.setName("javaMelodyPortRestriction");
		String[] str = new String[1];
		str[0]=(String) javaMelodyFilter.getInitParameters().get("monitoring-path");
		filterRegistrationBean.addUrlPatterns(str);
		return filterRegistrationBean;
	}
}
