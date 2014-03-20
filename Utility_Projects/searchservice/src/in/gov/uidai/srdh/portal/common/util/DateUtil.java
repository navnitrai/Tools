package in.gov.uidai.srdh.portal.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {

	public static java.sql.Date StringToSqlDate(String strDate) throws Exception {
		Date date = null;
		java.sql.Date sqlDate = null;
			if(strDate!=null){
			SimpleDateFormat formatter = new SimpleDateFormat(
					SearchServiceConstants.DATE_FORMAT_DDMMYYYY);
			date = (Date) formatter.parse(strDate);
			sqlDate = new java.sql.Date(date.getTime());
			}
		return sqlDate;
	}
}
