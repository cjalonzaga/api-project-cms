package com.project.api.utils;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

public class HtmlSanitizerUtil {
	private static final PolicyFactory POLICY = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
	
	public static String sanitize(String html) {
		return POLICY.sanitize(html);
	}
}
