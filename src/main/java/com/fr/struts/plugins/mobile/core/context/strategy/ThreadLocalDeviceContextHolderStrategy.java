package com.fr.struts.plugins.mobile.core.context.strategy;

import com.fr.struts.plugins.mobile.core.context.BasicDeviceContext;
import com.fr.struts.plugins.mobile.core.context.DeviceContext;

public final class ThreadLocalDeviceContextHolderStrategy implements DeviceContextHolderStrategy {

	private static final ThreadLocal<DeviceContext> contextHolder = new ThreadLocal<DeviceContext>();

	@Override
	public DeviceContext getContext() {
		DeviceContext deviceContext = ThreadLocalDeviceContextHolderStrategy.contextHolder.get();

		if (deviceContext == null) {
			deviceContext = this.createEmptyContext();
			ThreadLocalDeviceContextHolderStrategy.contextHolder.set(deviceContext);
		}

		return deviceContext;
	}

	@Override
	public void setContext(DeviceContext deviceContext) {
		ThreadLocalDeviceContextHolderStrategy.contextHolder.set(deviceContext);
	}

	@Override
	public void clearContext() {
		ThreadLocalDeviceContextHolderStrategy.contextHolder.remove();
	}

	@Override
	public DeviceContext createEmptyContext() {
		return new BasicDeviceContext();
	}

}
