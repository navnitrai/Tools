package in.gov.uidai.srdh.portal.vo;

import java.io.Serializable;
import java.sql.Date;

public class AuditSearch implements Serializable {
	
	private static final long serialVersionUID = -701110886804715315L;
	private long transactionId;
	private String ipAddress;
	private String requestXml;
	private Character responseStatus;
	private String failureCode;
	private Date requestDate;
	private Date responseDate;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getRequestXml() {
		return requestXml;
	}

	public void setRequestXml(String requestXml) {
		this.requestXml = requestXml;
	}

	public Character getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Character responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
}
