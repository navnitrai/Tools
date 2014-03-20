package in.gov.uidai.srdh.portal.common.util;

import in.gov.uidai.srdh.portal.vo.AdvanceSearchParameters;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class AuthPojoUtil {

	public static AdvanceSearchParameters convertXmlStringToPojo(String xmlStr){
		AdvanceSearchParameters advanceSearchParameters=null;
		if(xmlStr !=null){
			try {
				advanceSearchParameters = (AdvanceSearchParameters) JAXBContext.newInstance(AdvanceSearchParameters.class).createUnmarshaller().unmarshal(new StringReader(xmlStr));
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return advanceSearchParameters;
	}
	
	public static String pojoToXmlString(AdvanceSearchParameters source) {
        String result;
        StringWriter sw;
        Marshaller carMarshaller;
        try {
        	sw = new StringWriter();
        	carMarshaller = JAXBContext.newInstance(AdvanceSearchParameters.class).createMarshaller();
            carMarshaller.marshal(source, sw);
            result = sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
