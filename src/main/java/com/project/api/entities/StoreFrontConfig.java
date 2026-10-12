package com.project.api.entities;

import com.project.api.listeners.AuditEntityListener;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = StoreFrontConfig.table_name)
@EntityListeners(AuditEntityListener.class)
public class StoreFrontConfig extends BaseEntity {
	private final static String table_name = "store_front_config";
	
	@Basic
	@Column(name="store_name")
	private String storeName;
	
	@Basic
	@Column(name="store_api_key")
	private String storeApiKey;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreApiKey() {
		return storeApiKey;
	}

	public void setStoreApiKey(String storeApiKey) {
		this.storeApiKey = storeApiKey;
	}
}
