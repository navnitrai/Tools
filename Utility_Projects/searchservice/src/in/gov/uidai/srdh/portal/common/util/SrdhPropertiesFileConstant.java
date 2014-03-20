/**
 * 
 */
package in.gov.uidai.srdh.portal.common.util;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;


/**
 * @author VS92381
 *
 */
public class SrdhPropertiesFileConstant {
	
	private final ResourceBundle databaseBundle;
	public final int DATASOURCE_COUNT;
	public final int SEARCH_RESULT_SIZE;
	public final int UIDONE ;
	public final int UIDTWO ;
	public final int UIDTHREE ;
	public final int UIDFOUR ;
	public final int UIDFIVE ;
	public final int UIDSIX ;
	public final int UIDSEVEN ;
	public final int UIDEIGHT ;
	public final int UIDNINE ;
	
	public static final Logger LOG = Logger.getLogger(in.gov.uidai.srdh.portal.common.util.SrdhPropertiesFileConstant.class);
	
	private static SrdhPropertiesFileConstant theObject;
	
	public static SrdhPropertiesFileConstant createObject(){
		if(theObject==null){
			theObject = new SrdhPropertiesFileConstant();
			LOG.debug("SrdhPropertiesFileConstant singleton class created");
		}
			return theObject;
		}
	
	private SrdhPropertiesFileConstant(){
		databaseBundle = ResourceBundle.getBundle("databaseResources");
		SEARCH_RESULT_SIZE = Integer.parseInt(databaseBundle.getString("search.maxresults").trim());
		DATASOURCE_COUNT =  Integer.parseInt(databaseBundle.getString("srdh.numberOfEnrollmentDataSource").trim());
		UIDONE = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.1").trim());
		UIDTWO = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.2").trim());
		UIDTHREE = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.3").trim());
		UIDFOUR = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.4").trim());
		UIDFIVE = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.5").trim());
		UIDSIX = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.6").trim());
		UIDSEVEN = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.7").trim());
		UIDEIGHT = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.8").trim());
		UIDNINE = Integer.parseInt(databaseBundle.getString("srdh.enrollmentUid.9").trim());
	}
	
}
