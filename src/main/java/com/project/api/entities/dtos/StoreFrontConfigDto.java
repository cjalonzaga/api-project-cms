package com.project.api.entities.dtos;

public class StoreFrontConfigDto {
	private Long id;
	
	private String storeName;
	
	private String storeApiKey;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
