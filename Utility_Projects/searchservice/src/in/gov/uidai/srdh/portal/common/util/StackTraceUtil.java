package in.gov.uidai.srdh.portal.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTraceUtil {
	public static String getStackTrace(Exception exception){
		StringWriter stringWriter = new StringWriter();     
		PrintWriter printWriter = new PrintWriter(stringWriter);     
		exception.printStackTrace(printWriter);     
		return stringWriter.toString(); 
	}
	public static String getStackTrace(Error error){
		StringWriter stringWriter = new StringWriter();     
		PrintWriter printWriter = new PrintWriter(stringWriter);     
		error.printStackTrace(printWriter);     
		return stringWriter.toString(); 
	}
}
