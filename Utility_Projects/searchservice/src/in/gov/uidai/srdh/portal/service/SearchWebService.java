package in.gov.uidai.srdh.portal.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/searchService")
public interface SearchWebService {
	@POST
    //@Consumes("application/xml")
    @Produces("application/xml")
	public String getSearchResults(String enrollmentSearchStr);
	
}

