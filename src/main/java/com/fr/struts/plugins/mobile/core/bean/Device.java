package com.fr.struts.plugins.mobile.core.bean;

import java.io.Serializable;

public interface Device extends Serializable {

	/**
	 * Indique si le Device est un ordinateur.
	 *
	 * @return true si le device est un ordinateur.
	 */
	public boolean isDesktop();

	/**
	 * Indique si le Device est une tablette.
	 *
	 * @return true si le device est une tablette.
	 */
	public boolean isTablet();

	/**
	 * Indique si le Device est un mobile.
	 *
	 * @return true si le device est un mobile.
	 */
	public boolean isMobile();

}
