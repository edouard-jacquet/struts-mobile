package com.fr.struts.plugins.mobile.core.context;

import java.io.Serializable;

import com.fr.struts.plugins.mobile.core.bean.Device;

public interface DeviceContext extends Serializable {

	/**
	 * Retourne le device associé lié à l'utilisateur.
	 *
	 * @return le device lié.
	 */
	public Device getDevice();

	/**
	 * Défini le device lié à l'utilisateur.
	 *
	 * @param device le device à lier.
	 */
	public void setDevice(Device device);

}
