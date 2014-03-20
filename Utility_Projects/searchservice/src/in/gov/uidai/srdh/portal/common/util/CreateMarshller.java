package in.gov.uidai.srdh.portal.common.util;

import in.gov.uidai.srdh.portal.vo.SrdhSearchResults;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class CreateMarshller {

private static CreateMarshller theObject;
private static Marshaller marshaller;

public Marshaller getMarshaller() {
	return marshaller;
}

public void setMarshaller(Marshaller marshaller) {
	CreateMarshller.marshaller = marshaller;
}

	public static CreateMarshller createObject(){
		if(theObject==null){
			theObject = new CreateMarshller();
		}
			return theObject;
		}
	
	private CreateMarshller(){
		try {
			this.setMarshaller(JAXBContext.newInstance(SrdhSearchResults.class).createMarshaller());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
