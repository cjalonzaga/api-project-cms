package com.project.api.entities;

import com.project.api.listeners.AuditEntityListener;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = Configuration.table_name)
@EntityListeners(AuditEntityListener.class)
public class Configuration extends BaseEntity {
	private final static String table_name = "configurations";
	
	@Basic
    @Column(name = "cors_allowed_origins")
	private String corsAllowedOrigins;

	public String getCorsAllowedOrigins() {
		return corsAllowedOrigins;
	}

	public void setCorsAllowedOrigins(String corsAllowedOrigins) {
		this.corsAllowedOrigins = corsAllowedOrigins;
	}
}
