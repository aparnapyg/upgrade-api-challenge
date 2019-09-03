package com.test.api.object;

import java.util.HashMap;
import java.util.Map;

public class State {

	private Integer minAge;
	private Double minLoanAmount;
	private String label;
	private String abbreviation;
//	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Double getMinLoanAmount() {
		return minLoanAmount;
	}

	public void setMinLoanAmount(Double minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

//	public Map<String, Object> getAdditionalProperties() {
//		return this.additionalProperties;
//	}
//
//	public void setAdditionalProperty(String name, Object value) {
//		this.additionalProperties.put(name, value);
//	}

}