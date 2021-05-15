package com.fr.struts.plugins.mobile.core.context;

import com.fr.struts.plugins.mobile.core.bean.Device;

public class BasicDeviceContext implements DeviceContext {

	private static final long serialVersionUID = 4386718687273495596L;

	private Device device;

	public BasicDeviceContext() {

	}

	@Override
	public Device getDevice() {
		return this.device;
	}

	@Override
	public void setDevice(Device device) {
		this.device = device;
	}

}
