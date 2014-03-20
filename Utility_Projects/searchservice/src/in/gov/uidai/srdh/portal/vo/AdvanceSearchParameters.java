package in.gov.uidai.srdh.portal.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AdvanceSearchParameters implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3104059462925664893L;
	@XmlElement
	private String dateSearchType;
	@XmlElement
	private String startDate;
	@XmlElement
	private String endDate;
	@XmlElement
	private String uid;
	@XmlElement
	private String eid;
	@XmlElement
	private String name;
	@XmlElement
	private String gender;
	@XmlElement
	private String street;
	@XmlElement
	private String building;
	@XmlElement
	private String state;
	@XmlElement
	private String locality;
	@XmlElement
	private String district;
	@XmlElement
	private String vtc;
	@XmlElement
	private String mobile;
	@XmlElement
	private String email;
	@XmlElement
	private String pincode;
	@XmlElement
	private String deactivatedList;
	
	private Date startDateInDate;
	
	private Date endDateInDate;

	private boolean valid;
	
	private String errorDetails;

	public void setDateSearchType(String dateSearchTypeTemp) {
		if(dateSearchTypeTemp!=null && dateSearchTypeTemp.trim().length()>0){
			this.dateSearchType = dateSearchTypeTemp.trim();
		}	
	}
	
	public String getDateSearchType() {
		return dateSearchType;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uidTemp) {
		if(uidTemp!=null && uidTemp.trim().length()>0){
			this.uid = uidTemp.trim();
		}
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eidTemp) {
		if(eidTemp!=null && eidTemp.trim().length()>0){
			this.eid = eidTemp.trim();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String nameTemp) {
		if(nameTemp!=null && nameTemp.trim().length()>0){
			this.name = nameTemp.trim();	
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String genderTemp) {
		if(genderTemp!=null && genderTemp.trim().length()>0){
			this.gender = genderTemp.trim();
		}
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String streetTemp) {
		if(streetTemp!=null && streetTemp.trim().length()>0){
			this.street = streetTemp.trim();	
		}
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String buildingTemp) {
		if(buildingTemp!=null && buildingTemp.trim().length()>0){
			this.building = buildingTemp.trim();	
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String stateTemp) {
		if(stateTemp!=null && stateTemp.trim().length()>0){
			this.state = stateTemp.trim();
		}
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String localityTemp) {
		if(localityTemp!=null && localityTemp.trim().length()>0){
			this.locality = localityTemp.trim();	
		}
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String districtTemp) {
		if(districtTemp!=null && districtTemp.trim().length()>0){
			this.district = districtTemp.trim();
		}
	}

	public String getVtc() {
		return vtc;
	}

	public void setVtc(String vtcTemp) {
		if(vtcTemp!=null && vtcTemp.trim().length()>0){
			this.vtc = vtcTemp.trim();	
		}
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobileTemp) {
		if(mobileTemp!=null && mobileTemp.trim().length()>0){
			this.mobile = mobileTemp.trim();	
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailTemp) {
		if(emailTemp!=null && emailTemp.trim().length()>0){
			this.email = emailTemp.trim();	
		}
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincodeTemp) {
		if(pincodeTemp!=null && pincodeTemp.trim().length()>0){
			this.pincode = pincodeTemp.trim();
		}
	}

	public String getDeactivatedList() {
		return deactivatedList;
	}

	public void setDeactivatedList(String deactivatedListTemp) {
		if(deactivatedListTemp!=null && deactivatedListTemp.trim().length()>0){
			this.deactivatedList = deactivatedListTemp.trim();
		}	
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDateTemp) {
		if(startDateTemp != null && startDateTemp.trim().length()>0){
			this.startDate = startDateTemp.trim();
		} 
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDateTemp) {
		if(endDateTemp != null && endDateTemp.trim().length()>0){
			this.endDate = endDateTemp.trim();
		}
	}
	
	public Date getStartDateInDate() {
		return startDateInDate;
	}

	public void setStartDateInDate(Date startDateInDate) {
		this.startDateInDate = startDateInDate;
	}

	public Date getEndDateInDate() {
		return endDateInDate;
	}

	public void setEndDateInDate(Date endDateInDate) {
		this.endDateInDate = endDateInDate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	@Override
	public String toString() {
		return "SearchParameters [dateSearchType=" + dateSearchType
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", uid=" + uid + ", eid=" + eid + ", name=" + name
				+ ", gender=" + gender + ", street=" + street + ", building="
				+ building + ", state=" + state + ", locality=" + locality
				+ ", district=" + district + ", vtc=" + vtc + ", mobile="
				+ mobile + ", email=" + email + ", pincode=" + pincode
				+ ", deactivatedList=" + deactivatedList + ", startDateInDate="
				+ startDateInDate + ", endDateInDate=" + endDateInDate + "]";
	}

	
}
