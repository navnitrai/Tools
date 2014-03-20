package in.gov.uidai.srdh.portal.common.util;
/**
 * Signals that an exception has occurred in Search Module.
 * 
 */
public class SearchException extends Exception {

	
	private static final long serialVersionUID = -7662266629414520612L;
	private String errorCode;
	
	/**
	 * SearchException default constructor.
	 * 
	 */
	public SearchException(){
		super();
	}
	/**
	 * Constructs SearchException with the specified detail message.
	 * @param message - detail message.
	 */
	public SearchException(String message){
		super(message);
	}
	/**
	 * Constructs SearchException with the specified cause .	
	 * @param cause - the cause (which is saved for later retrieval by the Throwable.getCause() method).
	 * 				  A null value is permitted, and indicates that the cause is nonexistent or unknown.
	 */
	public SearchException(Throwable cause){
		super(cause);
	}
	/**
	 * Constructs SearchException with the specified detail message and cause .
	 * @param message - detail message.
	 * @param cause - the cause (which is saved for later retrieval by the Throwable.getCause() method).
	 * 				  A null value is permitted, and indicates that the cause is nonexistent or unknown.
	 */
	public SearchException(String message, Throwable cause) {
		super(message,cause);
	}
	/**
	 * Constructs SearchException with the specified detail message, cause and SQL State
	 * @param message - detail message.
	 * @param cause - the cause (which is saved for later retrieval by the Throwable.getCause() method).
	 * 				  A null value is permitted, and indicates that the cause is nonexistent or unknown.
	 * @param errorCode - 
	 */
	public SearchException(String message, Throwable cause, String errorCode){
		super(message,cause);
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
