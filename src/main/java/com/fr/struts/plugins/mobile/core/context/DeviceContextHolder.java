package com.fr.struts.plugins.mobile.core.context;

import com.fr.struts.plugins.mobile.core.bean.Device;
import com.fr.struts.plugins.mobile.core.context.strategy.DeviceContextHolderStrategy;
import com.fr.struts.plugins.mobile.core.context.strategy.ThreadLocalDeviceContextHolderStrategy;

public final class DeviceContextHolder {

	private static DeviceContextHolderStrategy strategy;

	private DeviceContextHolder() {

	}

	static {
		DeviceContextHolder.initialize();
	}

	/**
	 * Récupère le contexte mobile.
	 *
	 * @return le contexte.
	 */
	public static DeviceContext getContext() {
		return DeviceContextHolder.strategy.getContext();
	}

	/**
	 * Défini le contexte mobile.
	 *
	 * @param deviceContext le contexte.
	 */
	public static void setContext(DeviceContext deviceContext) {
		DeviceContextHolder.strategy.setContext(deviceContext);
	}

	/**
	 * Nettoie le contexte mobile.
	 */
	public static void clearContext() {
		DeviceContextHolder.strategy.clearContext();
	}

	/**
	 * Créer un nouveau contexte mobile.
	 *
	 * @return le nouveau contexte.
	 */
	public static DeviceContext createEmptyContext() {
		return DeviceContextHolder.strategy.createEmptyContext();
	}

	/**
	 * Défini le device détecté.
	 *
	 * @param locale Le device détecté.
	 */
	public static void setDevice(Device device) {
		DeviceContext context = DeviceContextHolder.getContext();

		context.setDevice(device);
	}

	private static void initialize() {
		DeviceContextHolder.strategy = new ThreadLocalDeviceContextHolderStrategy();
	}

}
