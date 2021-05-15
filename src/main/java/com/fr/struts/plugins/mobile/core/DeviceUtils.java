package com.fr.struts.plugins.mobile.core;

import com.fr.struts.plugins.mobile.core.bean.Device;
import com.fr.struts.plugins.mobile.core.context.DeviceContextHolder;

public final class DeviceUtils {

	private DeviceUtils() {

	}

	public static Device getCurrent() {
		return DeviceContextHolder.getContext().getDevice();
	}

}
