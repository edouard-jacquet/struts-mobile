package com.fr.struts.plugins.mobile.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class UserAgent {

	public static final String SILK = "silk";
	public static final String MOBILE = "mobile";
	public static final String IPHONE = "iphone";
	public static final String IPOD = "ipod";
	public static final String IPAD = "ipad";
	public static final String ANDROID = "android";
	public static final String OPERAMINI = "OperaMini";

	public static final List<String> MOBILE_PREFIXES = Collections.unmodifiableList(Arrays.asList("w3c ", "w3c-",
			"acs-", "alav", "alca", "amoi", "avan", "benq", "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-",
			"dang", "doco", "eric", "hipt", "htc_", "inno", "ipaq", UserAgent.IPOD, "jigs", "kddi", "keji", "leno",
			"lg-c", "lg-d", "lg-g", "lge-", "lg/u", "maui", "maxo", "midp", "mits", "mmef", "mobi", "mot-", "moto",
			"mwbp", "nec-", "newt", "noki", "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap", "sage",
			"sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar", "sony",
			"sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-", "wapa",
			"wapi", "wapp", "wapr", "webc", "winw", "winw", "xda ", "xda-"));

	public static final List<String> MOBILE_KEYWORDS = Collections.unmodifiableList(
			Arrays.asList("blackberry", "webos", UserAgent.IPOD, "lge vx", "midp", "maemo", "mmp", UserAgent.MOBILE,
					"netfront", "hiptop", "nintendo DS", "novarra", "openweb", "opera mobi", "opera mini", "palm",
					"psp", "phone", "smartphone", "symbian", "up.browser", "up.link", "wap", "windows ce"));

	public static final List<String> TABLET_KEYWORDS = Collections
			.unmodifiableList(Arrays.asList(UserAgent.IPAD, "playbook", "hp-tablet", "kindle"));

	private UserAgent() {

	}
}
