package com.fr.struts.plugins.mobile.core.bean;

import com.fr.struts.plugins.mobile.core.DevicePlatform;
import com.fr.struts.plugins.mobile.core.DeviceType;

public class LiteDevice implements Device {

	private static final long serialVersionUID = 506168634967286323L;

	private final DeviceType type;
	private final DevicePlatform platform;

	public LiteDevice(DeviceType type, DevicePlatform platform) {
		this.type = type;
		this.platform = platform;
	}

	@Override
	public boolean isDesktop() {
		return DeviceType.DESKTOP == this.type;
	}

	@Override
	public boolean isTablet() {
		return DeviceType.TABLET == this.type;
	}

	@Override
	public boolean isMobile() {
		return DeviceType.MOBILE == this.type;
	}

	public DeviceType getType() {
		return this.type;
	}

	public DevicePlatform getPlatform() {
		return this.platform;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Device: [");
		builder.append("type=").append(this.type).append(", ");
		builder.append("platform=").append(this.platform);
		builder.append("]");

		return builder.toString();
	}

}
