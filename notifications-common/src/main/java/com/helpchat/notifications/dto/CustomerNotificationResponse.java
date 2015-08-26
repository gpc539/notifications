package com.helpchat.notifications.dto;

import java.io.Serializable;
import java.util.List;

import com.helpchat.notifications.commons.CustomerNotificationSendStatus;

public class CustomerNotificationResponse implements Serializable {
	private static final long serialVersionUID = -5410654969567206026L;

	private CustomerNotificationSendStatus customerNotificationSendStatus;
	private List<String> customerNotificationReferences;
	private String responseDetails;

	public CustomerNotificationResponse() {
	}

	public CustomerNotificationResponse(CustomerNotificationSendStatus customerNotificationSendStatus,
			List<String> customerNotificationReferences) {
		this.customerNotificationSendStatus = customerNotificationSendStatus;
		this.customerNotificationReferences = customerNotificationReferences;
	}

	public CustomerNotificationResponse(CustomerNotificationSendStatus customerNotificationSendStatus,
			String responseDetails) {
		this.customerNotificationSendStatus = customerNotificationSendStatus;
		this.responseDetails = responseDetails;
	}

	public CustomerNotificationSendStatus getCustomerNotificationSendStatus() {
		return customerNotificationSendStatus;
	}

	public void setCustomerNotificationSendStatus(CustomerNotificationSendStatus customerNotificationSendStatus) {
		this.customerNotificationSendStatus = customerNotificationSendStatus;
	}

	public String getResponseDetails() {
		return responseDetails;
	}

	public void setResponseDetails(String responseDetails) {
		this.responseDetails = responseDetails;
	}

	public List<String> getCustomerNotificationReferences() {
		return customerNotificationReferences;
	}

	public void setCustomerNotificationReferences(List<String> customerNotificationReferences) {
		this.customerNotificationReferences = customerNotificationReferences;
	}

	@Override
	public String toString() {
		return "CustomerNotificationResponse ["
				+ (customerNotificationSendStatus != null ? "customerNotificationSendStatus="
						+ customerNotificationSendStatus + ", " : "")
				+ (customerNotificationReferences != null ? "customerNotificationReferences="
						+ customerNotificationReferences + ", " : "")
				+ (responseDetails != null ? "responseDetails=" + responseDetails : "") + "]";
	}

}
