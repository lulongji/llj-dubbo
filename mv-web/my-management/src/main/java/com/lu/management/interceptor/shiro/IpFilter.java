package com.lu.management.interceptor.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IpFilter extends AuthorizationFilter {
	protected static final String[] whiteList = new String[] { "127.0.0.1", "121.69.128.67", "121.69.128.68" };

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String clientIp = "";
			for (String ip : whiteList) {
				if (ip.equals(clientIp)) {
					return true;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
