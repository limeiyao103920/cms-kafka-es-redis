package com.lmy.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Document(indexName = "check",type = "check1")
public class CompanyAnnualCheck implements Serializable {

	@Id
	private int id;
	@Field(index = true,store = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",type=FieldType.text)
	private String keywords;
	private String description;
	@Field(index = true,store = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",type=FieldType.text)
	private String companyName;
	private String mainBusinessProducts;
	private String address;
	private String registeredCapital;
	private Date foundingTime;
	private Date annualCheckDate;
	private String annualCheckStatus;
	private String rmk;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getMainBusinessProducts() {
		return mainBusinessProducts;
	}
	public void setMainBusinessProducts(String mainBusinessProducts) {
		this.mainBusinessProducts = mainBusinessProducts;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegisteredCapital() {
		return registeredCapital;
	}
	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	public Date getFoundingTime() {
		return foundingTime;
	}
	public void setFoundingTime(Date foundingTime) {
		this.foundingTime = foundingTime;
	}
	public Date getAnnualCheckDate() {
		return annualCheckDate;
	}
	public void setAnnualCheckDate(Date annualCheckDate) {
		this.annualCheckDate = annualCheckDate;
	}
	public String getAnnualCheckStatus() {
		return annualCheckStatus;
	}
	public void setAnnualCheckStatus(String annualCheckStatus) {
		this.annualCheckStatus = annualCheckStatus;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public CompanyAnnualCheck(int id, String keywords, String description, String companyName,
			String mainBusinessProducts, String address, String registeredCapital, Date foundingTime,
			Date annualCheckDate, String annualCheckStatus, String rmk) {
		super();
		this.id = id;
		this.keywords = keywords;
		this.description = description;
		this.companyName = companyName;
		this.mainBusinessProducts = mainBusinessProducts;
		this.address = address;
		this.registeredCapital = registeredCapital;
		this.foundingTime = foundingTime;
		this.annualCheckDate = annualCheckDate;
		this.annualCheckStatus = annualCheckStatus;
		this.rmk = rmk;
	}
	
	public CompanyAnnualCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CompanyAnnualCheck [id=" + id + ", keywords=" + keywords + ", description=" + description
				+ ", companyName=" + companyName + ", mainBusinessProducts=" + mainBusinessProducts + ", address="
				+ address + ", registeredCapital=" + registeredCapital + ", foundingTime=" + foundingTime
				+ ", annualCheckDate=" + annualCheckDate + ", annualCheckStatus=" + annualCheckStatus + ", rmk=" + rmk
				+ "]";
	}
	
}
