package in.gov.uidai.srdh.portal.service.impl;

import in.gov.uidai.srdh.portal.common.util.CreateMarshller;
import in.gov.uidai.srdh.portal.common.util.SearchServiceConstants;
import in.gov.uidai.srdh.portal.common.util.StackTraceUtil;
import in.gov.uidai.srdh.portal.service.SearchWebService;
import in.gov.uidai.srdh.portal.vo.AuditSearch;
import in.gov.uidai.srdh.portal.vo.Enrollment;
import in.gov.uidai.srdh.portal.vo.Error;
import in.gov.uidai.srdh.portal.vo.AdvanceSearchParameters;
import in.gov.uidai.srdh.portal.vo.SrdhSearchResults;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SearchWebServiceImpl implements SearchWebService {

	private SearchServiceImpl searchServiceImpl;
	@SuppressWarnings("unused")
	private ApplicationContext appContext;
	private AuditSearch auditSearch;
	HttpServletRequest req;
	@Context
	private MessageContext context;
	private Marshaller marshaller;
	private static final Logger LOG = Logger
			.getLogger(in.gov.uidai.srdh.portal.service.impl.SearchWebServiceImpl.class);

	public SearchServiceImpl getSearchServiceImpl() {
		return searchServiceImpl;
	}

	public void setSearchServiceImpl(SearchServiceImpl searchServiceImpl) {
		this.searchServiceImpl = searchServiceImpl;
	}
	

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getSearchResults(String enrollmentSearchStr) {
		String searchResultStr = null;
		Map resultsMap = new HashMap();
		AdvanceSearchParameters advanceSearchParameters = convertXmlStringToPojo(enrollmentSearchStr);
		SrdhSearchResults resultReport = new SrdhSearchResults();
		try 
		{
			if (advanceSearchParameters != null) 
			{
				req = context.getHttpServletRequest();
				Date date = new Date();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				auditSearch = new AuditSearch();
				auditSearch.setIpAddress(req.getRemoteHost());
				auditSearch.setRequestDate(sqlDate);
				resultsMap = searchServiceImpl.getSearchResultsService(advanceSearchParameters, auditSearch);
			}
		} catch (Exception e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
		}
		if(resultsMap.containsKey(SearchServiceConstants.ERROR)){
			resultReport.setError((Error) resultsMap.get(SearchServiceConstants.ERROR));
		}
		if(resultsMap.containsKey(SearchServiceConstants.RESULT)){
			resultReport.setEnrollment((List<Enrollment>) resultsMap.get(SearchServiceConstants.RESULT));
		}
		System.out.println(resultReport);
		searchResultStr = pojoToXmlString(resultReport);
		return searchResultStr;
	}

	public synchronized String pojoToXmlString(SrdhSearchResults enrollmentReport) {
		StringWriter sw = null;
		String result = null;
		try {
			sw = new StringWriter();
			//marshaller = JAXBContext.newInstance(SrdhSearchResults.class).createMarshaller();
			marshaller = CreateMarshller.createObject().getMarshaller();
			marshaller.marshal(enrollmentReport, sw);
						
		} catch (Exception exception) {
			LOG.error(StackTraceUtil.getStackTrace(exception));
		}
		return sw.toString();
	}

	public AdvanceSearchParameters convertXmlStringToPojo(String xmlStr) {
		AdvanceSearchParameters advanceSearchParameters = null;
		if (xmlStr != null) {
			try {
				advanceSearchParameters = (AdvanceSearchParameters) JAXBContext
						.newInstance(AdvanceSearchParameters.class)
						.createUnmarshaller()
						.unmarshal(new StringReader(xmlStr));
			} catch (JAXBException e) {
				LOG.error(StackTraceUtil.getStackTrace(e));
			}
		}
		return advanceSearchParameters;
	}

	
	public static void main(String[] args) 
	{
		String data = "<advanceSearchParameters xmlns='http://uidai.gov.in/SRDH/SearchResults' xmlns:i='http://www.w3.org/2001/XMLSchema-instance'><uid>200003939471</uid></advanceSearchParameters>";
		String searchResults = new SearchWebServiceImpl().getSearchResults(data);
		System.out.println(searchResults);
	}
}
