package com.project.api.entities.dtos;

public class ConfigurationDto {
	private Long id;
	private String corsAllowedOrigins;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorsAllowedOrigins() {
		return corsAllowedOrigins;
	}
	public void setCorsAllowedOrigins(String corsAllowedOrigins) {
		this.corsAllowedOrigins = corsAllowedOrigins;
	}
	
	
}
