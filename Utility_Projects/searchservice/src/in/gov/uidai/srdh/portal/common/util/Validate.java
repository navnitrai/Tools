package in.gov.uidai.srdh.portal.common.util;
import in.gov.uidai.srdh.portal.vo.AdvanceSearchParameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	private static Pattern pattern;
	private static Matcher matcher;

	public static boolean validateUid(String uid) {
		  pattern = Pattern.compile("\\d{3,12}");
		  matcher = pattern.matcher(uid);
		return matcher.matches();
	}
	public static boolean validateStartWithZero(String uid) {
		 
		return uid.startsWith("0");		
	}
	
	public static boolean validateAge(String age) {
		  pattern = Pattern.compile("\\d{1,3}");
		  matcher = pattern.matcher(age);
		return matcher.matches();
	}
	
	public static boolean validateOtp(String otp) {
		  pattern = Pattern.compile("\\d{6}");
		  matcher = pattern.matcher(otp);
		return matcher.matches();
	}

	public static boolean validateEid(String eid) {
		return eid.matches("\\d{3,28}");
	}

	public static boolean validateName(String name) {

		return name.matches("([a-zA-Z.'\\s]){3,60}");
	}

	public static boolean validateEmail(String email) {

		return email
				.matches("^([0-9a-zA-Z]+[-._+&amp;])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
	}

	public static boolean validateStreet(String street) {

		return street.matches("([a-zA-Z0-9(:)#-;,.\\s\\/]){3,60}");
	}

	public static boolean validateBuilding(String building) {

		return building.matches("([a-zA-Z0-9(:)#-;,.\\s\\/]){3,60}");
	}

	public static boolean validateLocality(String locality) {

		return locality.matches("([a-zA-Z0-9(:)#-;,.\\s\\/]){3,60}");
	}

	public static boolean validateVtc(String vtc) {

		return vtc.matches("([a-zA-Z\\s]){3,60}");
	}

	public static boolean validateDistrict(String district) {

		return district.matches("([a-zA-Z\\s]){3,60}");
	}

	public static boolean validateState(String State) {

		return State.matches("([a-zA-Z\\s]){3,60}");
	}

	public static boolean validatePincode(String pincode) {

		return pincode.matches("\\d{3,6}");
	}

	public static boolean validateMobile(String mobile) {

		return mobile.matches("\\d{10,11}");
	}
	

	public static boolean validateBlankSpacesInString(String name) {
		int count = 0;
		if (name.length() != 0) {
			for (int i = 0; i < name.length(); i++) {
				if (name.charAt(i) == ' ') {
					count++;
				}
			}
		}
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validateConsecutiveBlankSpacesInString(String name) {
		int count = 0;
		
		if (name.length() != 0) {
			
			for (int i = 0; i < name.length() && i+1<name.length(); i++) {
				
					if ((name.charAt(i) == ' ') && (name.charAt(i+1) == ' ')) {
						
						count++;
					}
				
			}
		}
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean validateFirstBlankSpace(String blankSpace) {
		if (blankSpace.charAt(0) == ' ') {
			return false;
		}
		return true;
	}
	public static boolean validateLastBlankSpace(String blankSpace) {
		int len=blankSpace.length();
		
		if (blankSpace.charAt(len-1) == ' ') {
			return false;
		}
		return true;
	}
	
	
	/***********************************Role Validations****************************/
	
	//Role Validations
		public static boolean validateRoleName(String rolename) {

			return rolename.matches("([a-zA-Z\\s]){1,60}");
		}
		
	/*******************************************************************************/

	/********************** User Validations ***************************************/
	
	// USER Validations

	public static boolean validateFirstName(String firstname) {

		return firstname.matches("([a-zA-Z\\s]){1,50}");
	}

	public static boolean validateLastName(String lastname) {

		return lastname.matches("([a-zA-Z\\s]){1,50}");
	}

	public static boolean validateUserAddress(String address) {

		//return address.matches("([a-zA-Z_#-\\s]){6,200}");
		return address
				.matches("^([a-zA-Z0-9(:)#-;,.\\s\\/]){0,200}$");
	}

	public static boolean validateUserDepartment(String department) {

		return department.matches("([a-zA-Z\\s]){0,50}");
	}

	public static boolean validateUserDesignation(String designation) {

		return designation.matches("([a-zA-Z\\s]){0,50}");
	}

	public static boolean validateUserMobile(String mobile) {

		return mobile.matches("\\d{10,11}");
		
	}

	public static boolean validateUserPhone(String mobile) {

		return mobile.matches("\\d{10,11}");
	}

	public static boolean validateUserEmail(String userEmail) {

		return userEmail
				.matches("^([0-9a-zA-Z]+[-._+&amp;])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
	}
	public static boolean validateUserName(String userName) {
	
		return userName
				.matches("^[a-zA-Z0-9_.-]{2,50}$");
		
	}
	public static boolean validateUserNameStartingWithDigit(String userName) {
		
		return userName.startsWith("^([0-9]$");
		
	}

	
	public static boolean validatePassword(String password) {
		  pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		  matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/*******************************************************************************/
	
	
	/************************* Manual Seeding Validations **************************/
	
	
	//manual seeding page
	public static boolean validateSeedingUid(String uid) {
		  pattern = Pattern.compile("\\d{12,12}");
		  matcher = pattern.matcher(uid);
		return matcher.matches();
	}
	public static boolean validateSeedingLabelValue(String labelValue) {
		
		return labelValue
				.matches("^[a-zA-Z0-9]{0,20}$");
		
	}
	public static boolean validateSeedingDepartment(String department) {

		return department.matches("([a-zA-Z\\s]){0,50}");
	}
	public static boolean validateSeedingResidentLabel(String label) {
		return label.matches("([a-zA-Z\\s]){0,50}");
	}
	/*******************************************************************************/
	
/**********************ExternalDb Validations ***************************************/
	
	// ExternalDb Validations

	public static boolean validateExternalDbName(String extdbname) 
	{
		return extdbname.matches("([-a-zA-Z0-9' ']){1,50}");
	}
	
	public static boolean validateIpAdrress(String ipaddress) 
	{
		return ipaddress.matches("\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)"+ "{3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
	}

	public static boolean validateSchema(String schema) 
	{
		return schema.matches("([a-zA-Z\\s]){1,50}");
	}

	public static boolean validateUrl(String url) 
	{
		return url.matches("^http[s]?://[-a-zA-Z0-9_.:]+[-a-zA-Z0-9_:@&?=+,.!/~*'%$]*$");
	}
	
	public static boolean validatePort(String port) 
	{
		return port.matches("(6553[0-5]|655[0-2]\\d|65[0-4]\\d{2}|6[0-4]\\d{3}|[1-5]\\d{4}|[1-9]\\d{0,3})" );
	}
	
	public synchronized static AdvanceSearchParameters validateRequestData(AdvanceSearchParameters advanceSearchParameters){
		/**
		 *  Check for at least one search criteria
		 */
		boolean isBlankSpace;
		boolean isValidateTrue;
		if (advanceSearchParameters.getStartDate()==null
				&& advanceSearchParameters.getEndDate()==null
				&& advanceSearchParameters.getUid()==null
				&& advanceSearchParameters.getEid()==null
				&& advanceSearchParameters.getName()==null
				&& advanceSearchParameters.getGender()==null
				&& advanceSearchParameters.getEmail()==null
				&& advanceSearchParameters.getStreet()==null
				&& advanceSearchParameters.getVtc()==null
				&& advanceSearchParameters.getBuilding()==null
				&& advanceSearchParameters.getLocality()==null
				&& advanceSearchParameters.getDistrict()==null
				&& advanceSearchParameters.getState()==null
				&& advanceSearchParameters.getPincode()==null
				&& advanceSearchParameters.getMobile()==null
				&& advanceSearchParameters.getDeactivatedList()==null
				&& advanceSearchParameters.getDateSearchType()==null) {
			advanceSearchParameters.setValid(false);
			advanceSearchParameters.setErrorDetails(ReasonDetails.NO_SEARCH_CRITERIA);
			return advanceSearchParameters;
		}
			/**
			 *  Validate Data
			 */
		if (!(advanceSearchParameters.getStartDate()==null
				&& advanceSearchParameters.getEndDate()==null
				&& advanceSearchParameters.getDateSearchType()==null)) {
			
			if (advanceSearchParameters.getStartDate()!=null
					&& advanceSearchParameters.getEndDate()!=null
					&& advanceSearchParameters.getDateSearchType()==null) {
				advanceSearchParameters.setValid(false);
				advanceSearchParameters.setErrorDetails(ReasonDetails.NO_DATETYPE);
				return advanceSearchParameters;
			}
			if (advanceSearchParameters.getStartDate()!=null
					&& advanceSearchParameters.getEndDate()==null
					&& advanceSearchParameters.getDateSearchType()==null) {
				advanceSearchParameters.setValid(false);
				advanceSearchParameters.setErrorDetails(ReasonDetails.NO_DATETYPE_AND_ENDDATE);
				return advanceSearchParameters;
			}
			if (advanceSearchParameters.getStartDate()==null
					&& advanceSearchParameters.getEndDate()!=null
					&& advanceSearchParameters.getDateSearchType()==null) {
				advanceSearchParameters.setValid(false);
				advanceSearchParameters.setErrorDetails(ReasonDetails.NO_DATETYPE_AND_STARTDATE);
				return advanceSearchParameters;
			}
			if (advanceSearchParameters.getDateSearchType()!=null && (advanceSearchParameters.getDateSearchType().equalsIgnoreCase(SearchServiceConstants.SEARCH_DATETYPECREATED)
					|| advanceSearchParameters.getDateSearchType().equalsIgnoreCase(SearchServiceConstants.SEARCH_DATETYPEMODIFIED_UPDATED) 
					|| advanceSearchParameters.getDateSearchType().equalsIgnoreCase(
							SearchServiceConstants.SEARCH_DATETYPEDOB))){
				
				if (advanceSearchParameters.getStartDate()==null
						&& advanceSearchParameters.getEndDate()==null) {
					advanceSearchParameters.setValid(false);
					advanceSearchParameters.setErrorDetails(ReasonDetails.NO_STARTDATE_ENDDATE);
					return advanceSearchParameters;
				}
				if (advanceSearchParameters.getStartDate()==null
						&& advanceSearchParameters.getEndDate()!= null) {
					advanceSearchParameters.setValid(false);
					advanceSearchParameters.setErrorDetails(ReasonDetails.NO_STARTDATE);
					return advanceSearchParameters;
				}
				if (advanceSearchParameters.getStartDate()!= null
						&& advanceSearchParameters.getEndDate()== null) {
					advanceSearchParameters.setValid(false);
					advanceSearchParameters.setErrorDetails(ReasonDetails.NO_ENDDATE);
					return advanceSearchParameters;
					}
				} else{
					advanceSearchParameters.setValid(false);
					advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_DATETYPE);
					return advanceSearchParameters;
				}
			
			if (advanceSearchParameters.getStartDate() != null
					&& advanceSearchParameters.getEndDate()!= null) {
				try{
				advanceSearchParameters.setStartDateInDate(DateUtil.StringToSqlDate(advanceSearchParameters.getStartDate()));
				advanceSearchParameters.setEndDateInDate(DateUtil.StringToSqlDate(advanceSearchParameters.getEndDate()));
				java.util.Date currentDate = new java.util.Date();
				int dateCompareResult = advanceSearchParameters.getStartDateInDate().compareTo(currentDate);
				if (dateCompareResult > 0) {
					advanceSearchParameters.setValid(false);
					advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_STARTDATE);
					return advanceSearchParameters;
				}
				dateCompareResult = advanceSearchParameters.getEndDateInDate().compareTo(currentDate);
				if (dateCompareResult > 0) {
					advanceSearchParameters.setValid(false);
					advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_ENDDATE);
					return advanceSearchParameters;
				}
				}catch (Exception e) {
					advanceSearchParameters.setValid(false);
					advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_DATEFORMAT);
					return advanceSearchParameters;
				}
			}
		}
		
		/**
		 * 	UID validation
		 */
					if (advanceSearchParameters.getUid()!= null) {
						isBlankSpace = validateBlankSpacesInString(advanceSearchParameters.getUid());
						if (!isBlankSpace) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_SPACEUID);
							return advanceSearchParameters;
						}
						if (!Validate.validateUid(advanceSearchParameters.getUid())) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_UID);
							return advanceSearchParameters;
						}
					}
		/**
		 * 	EID Validation
		 */
					if (advanceSearchParameters.getEid()!= null) {
						isBlankSpace = validateBlankSpacesInString(advanceSearchParameters.getEid());
						if (!isBlankSpace) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_SPACEEID);
							return advanceSearchParameters;
						}
						if (!Validate.validateEid(advanceSearchParameters.getEid())) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_EID);
							return advanceSearchParameters;
						}
					}
			/**
			 * 	Name Validation
			 */
					// Name validations begin
					if (advanceSearchParameters.getName()!=null) {
						isValidateTrue = Validate.validateName(advanceSearchParameters.getName());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_NAME);
							return advanceSearchParameters;
						}
					}
					// Name validations ends

					// Street validations begins
					if (advanceSearchParameters.getStreet()!=null) {
						isValidateTrue = Validate.validateStreet(advanceSearchParameters
								.getStreet());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_STREET);
							return advanceSearchParameters;
						}
					}
					// Street validations ends

					// Locality validations begins
					if (advanceSearchParameters.getLocality()!=null) {
						isValidateTrue = Validate.validateLocality(advanceSearchParameters
								.getLocality());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_LOCALITY);
							return advanceSearchParameters;
						}
					}
					// Locality validations ends

					// Building validations begins
					if (advanceSearchParameters.getBuilding()!=null) {
						isValidateTrue = Validate.validateBuilding(advanceSearchParameters
								.getBuilding());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_BUILDING);
							return advanceSearchParameters;
						}
					}
					// Building validations ends

					// VTC validations Begin
					if (advanceSearchParameters.getVtc()!=null) {
						isValidateTrue = Validate
								.validateVtc(advanceSearchParameters.getVtc());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_VTC);
							return advanceSearchParameters;
						}
					}
					// VTC validations ends

					// District validations begins
					if (advanceSearchParameters.getDistrict()!=null) {
						isValidateTrue = Validate.validateDistrict(advanceSearchParameters
								.getDistrict());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_DISTRICT);
							return advanceSearchParameters;
						}
					}
					// District validations ends

					// State validations begins
					if (advanceSearchParameters.getState()!=null) {
						isValidateTrue = Validate.validateState(advanceSearchParameters
								.getState());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_STATE);
							return advanceSearchParameters;
						}
					}
					// State validations ends

					// Pin code validations begins
					if (advanceSearchParameters.getPincode()!=null) {
						isBlankSpace = Validate
								.validateBlankSpacesInString(advanceSearchParameters.getPincode());
						if (!isBlankSpace) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_SPACEPIN);
							return advanceSearchParameters;
						}
						isValidateTrue = Validate.validatePincode(advanceSearchParameters
								.getPincode());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_PIN);
							return advanceSearchParameters;
						}
					}
					// Pin code validations ends

					// Mobile validations begins
					if (advanceSearchParameters.getMobile()!=null) {
						isBlankSpace = Validate
								.validateBlankSpacesInString(advanceSearchParameters.getMobile());
						if (!isBlankSpace) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_SPACEMOBILE);
							return advanceSearchParameters;
						}
						isValidateTrue = Validate.validateMobile(advanceSearchParameters
								.getMobile());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_MOBILE);
							return advanceSearchParameters;
						}
					}
					// Mobile validations ends

					// Email validations begins
					if (advanceSearchParameters.getEmail()!=null) {
						isBlankSpace = Validate
								.validateBlankSpacesInString(advanceSearchParameters.getEmail());
						if (!isBlankSpace) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_SPACEEMAIL);
							return advanceSearchParameters;
						}
						isValidateTrue = Validate.validateEmail(advanceSearchParameters
								.getEmail());
						if (!isValidateTrue) {
							advanceSearchParameters.setValid(false);
							advanceSearchParameters.setErrorDetails(ReasonDetails.INVALID_EMAIL);
							return advanceSearchParameters;
						}
					}
					//Email validations ends
					advanceSearchParameters.setValid(true);		
		return advanceSearchParameters;
	}

}
