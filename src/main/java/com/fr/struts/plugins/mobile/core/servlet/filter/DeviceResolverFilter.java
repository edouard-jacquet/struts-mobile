package com.fr.struts.plugins.mobile.core.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fr.struts.plugins.mobile.core.bean.Device;
import com.fr.struts.plugins.mobile.core.context.DeviceContextHolder;
import com.fr.struts.plugins.mobile.core.resolver.DeviceResolver;
import com.fr.struts.plugins.mobile.core.resolver.LiteDeviceResolver;

public class DeviceResolverFilter implements Filter {

	private Logger logger = LogManager.getLogger(DeviceResolverFilter.class);
	private DeviceResolver resolver;

	public DeviceResolverFilter() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			if (filterConfig.getInitParameter("resolver") == null) {
				this.resolver = new LiteDeviceResolver();
			} else {
				Class<?> clazz = Class.forName(filterConfig.getInitParameter("resolver"));
				this.resolver = (DeviceResolver) clazz.newInstance();
			}

			this.logger.info("Success to initialize Struts Mobile");
		} catch (Exception exception) {
			this.logger.error("Unable to initialize Struts Mobile", exception);
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		try {
			Device device = this.resolver.resolve(request);
			DeviceContextHolder.setDevice(device);

			chain.doFilter(request, response);
		} finally {
			DeviceContextHolder.clearContext();
		}
	}

	@Override
	public void destroy() {
		this.logger.info("Success to destroy Struts Mobile");
	}

}
