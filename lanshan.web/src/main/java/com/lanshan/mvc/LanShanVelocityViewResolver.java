package com.lanshan.mvc;

import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

public class LanShanVelocityViewResolver extends VelocityViewResolver {
	/**
	 * Requires {@link UfuVelocityView}.
	 */
	@Override
	protected Class<VelocityView> requiredViewClass() {
		return VelocityView.class;
	}
	
}

