package com.fr.struts.plugins.mobile.core.context.strategy;

import com.fr.struts.plugins.mobile.core.context.DeviceContext;

public interface DeviceContextHolderStrategy {

	/**
	 * Récupère le contexte mobile.
	 *
	 * @return le contexte.
	 */
	public DeviceContext getContext();

	/**
	 * Défini le contexte mobile.
	 *
	 * @param localeContext le contexte.
	 */
	public void setContext(DeviceContext deviceContext);

	/**
	 * Nettoie le contexte mobile.
	 */
	public void clearContext();

	/**
	 * Créer un nouveau contexte mobile.
	 *
	 * @return le nouveau contexte.
	 */
	public DeviceContext createEmptyContext();

}
