package in.gov.uidai.srdh.portal.vo;

public class EnrollmentDetails  implements java.io.Serializable {

    
	private static final long serialVersionUID = 231645348652024525L;
	private String uid;
    private byte[] photo;    
  
	/**
	 * @return the uniqueid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uniqueid the uniqueid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	/**
	 * @return the source
	 */
}
