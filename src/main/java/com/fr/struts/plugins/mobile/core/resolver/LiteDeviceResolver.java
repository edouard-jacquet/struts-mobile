package com.fr.struts.plugins.mobile.core.resolver;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.fr.struts.plugins.mobile.core.Accept;
import com.fr.struts.plugins.mobile.core.DevicePlatform;
import com.fr.struts.plugins.mobile.core.DeviceType;
import com.fr.struts.plugins.mobile.core.HttpHeaders;
import com.fr.struts.plugins.mobile.core.UserAgent;
import com.fr.struts.plugins.mobile.core.bean.Device;
import com.fr.struts.plugins.mobile.core.bean.LiteDevice;

public class LiteDeviceResolver implements DeviceResolver {

	@Override
	public Device resolve(HttpServletRequest request) {
		String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

		if (userAgent != null) {
			userAgent = userAgent.toLowerCase();

			if (userAgent.contains(UserAgent.ANDROID) && !userAgent.contains(UserAgent.MOBILE)) {
				return new LiteDevice(DeviceType.TABLET, DevicePlatform.ANDROID);
			}

			if (userAgent.contains(UserAgent.IPAD)) {
				return new LiteDevice(DeviceType.TABLET, DevicePlatform.IOS);
			}

			if (userAgent.contains(UserAgent.SILK) && !userAgent.contains(UserAgent.MOBILE)) {
				return new LiteDevice(DeviceType.TABLET, DevicePlatform.UNKNOWN);
			}

			for (String keyword : UserAgent.TABLET_KEYWORDS) {
				if (userAgent.contains(keyword)) {
					return new LiteDevice(DeviceType.TABLET, DevicePlatform.UNKNOWN);
				}
			}
		}

		if (request.getHeader(HttpHeaders.X_WAP_PROFILE) != null || request.getHeader(HttpHeaders.PROFILE) != null) {
			if (userAgent != null) {
				if (userAgent.contains(UserAgent.ANDROID)) {
					return new LiteDevice(DeviceType.MOBILE, DevicePlatform.ANDROID);
				}

				if (userAgent.contains(UserAgent.IPHONE) || userAgent.contains(UserAgent.IPOD)
						|| userAgent.contains(UserAgent.IPAD)) {
					return new LiteDevice(DeviceType.MOBILE, DevicePlatform.IOS);
				}
			}

			return new LiteDevice(DeviceType.MOBILE, DevicePlatform.UNKNOWN);
		}

		if (userAgent != null && userAgent.length() >= 4) {
			String prefix = userAgent.substring(0, 4).toLowerCase();

			if (UserAgent.MOBILE_PREFIXES.contains(prefix)) {
				return new LiteDevice(DeviceType.MOBILE, DevicePlatform.UNKNOWN);
			}
		}

		String accept = request.getHeader(HttpHeaders.ACCEPT);

		if (accept != null && accept.contains(Accept.WAP)) {
			return new LiteDevice(DeviceType.MOBILE, DevicePlatform.UNKNOWN);
		}

		if (userAgent != null) {
			if (userAgent.contains(UserAgent.ANDROID)) {
				return new LiteDevice(DeviceType.MOBILE, DevicePlatform.ANDROID);
			}

			if (userAgent.contains(UserAgent.IPHONE) || userAgent.contains(UserAgent.IPOD)
					|| userAgent.contains(UserAgent.IPAD)) {
				return new LiteDevice(DeviceType.MOBILE, DevicePlatform.IOS);
			}

			for (String keyword : UserAgent.MOBILE_KEYWORDS) {
				if (userAgent.contains(keyword)) {
					return new LiteDevice(DeviceType.MOBILE, DevicePlatform.UNKNOWN);
				}
			}
		}

		Enumeration<String> headers = request.getHeaderNames();

		while (headers.hasMoreElements()) {
			String header = headers.nextElement();

			if (header.contains(UserAgent.OPERAMINI)) {
				return new LiteDevice(DeviceType.MOBILE, DevicePlatform.UNKNOWN);
			}
		}

		return new LiteDevice(DeviceType.DESKTOP, DevicePlatform.UNKNOWN);
	}

}
