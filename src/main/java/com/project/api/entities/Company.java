package com.project.api.entities;

import com.project.api.listeners.AuditEntityListener;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

@Entity
@Table(name = Company.table_name)
@EntityListeners(AuditEntityListener.class)
public class Company extends BaseEntity{
	
	private final static String table_name = "companies";
	
	@Basic
    @Column(name = "company_name")
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
