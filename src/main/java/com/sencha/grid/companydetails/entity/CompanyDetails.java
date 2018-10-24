package com.sencha.grid.companydetails.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock", catalog="test")
public class CompanyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "company")
	private String companyName;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "change_value")
	private Integer changeValue;
	
	@Column(name = "percent_change")
	private Integer percentageChange;
	
	@Column(name = "last_updated")
	private Date lastUpdated;
	
	@Column(name = "flag")
	private boolean isActive;
	
	public CompanyDetails(Integer id, String companyName, Integer price, Integer change, Integer percentageChange,
			Date lastUpdated, boolean isActive) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.price = price;
		this.changeValue = change;
		this.percentageChange = percentageChange;
		this.lastUpdated = lastUpdated;
		this.isActive = isActive;
	}

	public CompanyDetails() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getChangeValue() {
		return changeValue;
	}

	public void setChangeValue(Integer change) {
		this.changeValue = change;
	}

	public Integer getPercentageChange() {
		return percentageChange;
	}

	public void setPercentageChange(Integer percentageChange) {
		this.percentageChange = percentageChange;
	}
	
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
