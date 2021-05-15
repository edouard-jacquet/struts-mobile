package com.fr.struts.plugins.mobile.core.resolver;

import javax.servlet.http.HttpServletRequest;

import com.fr.struts.plugins.mobile.core.bean.Device;

public interface DeviceResolver {

	/**
	 * Détermine quel Device est utilisé.
	 *
	 * @param request La requête HTTP.
	 * @return le device correspondant.
	 */
	Device resolve(HttpServletRequest request);

}
