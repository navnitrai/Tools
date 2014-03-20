package in.gov.uidai.srdh.portal.service.impl;

import in.gov.uidai.srdh.portal.common.util.AuthPojoUtil;
import in.gov.uidai.srdh.portal.common.util.SearchServiceConstants;
import in.gov.uidai.srdh.portal.common.util.StackTraceUtil;
import in.gov.uidai.srdh.portal.common.util.Validate;
import in.gov.uidai.srdh.portal.dao.SearchDao;
import in.gov.uidai.srdh.portal.vo.AuditSearch;
import in.gov.uidai.srdh.portal.vo.Enrollment;
import in.gov.uidai.srdh.portal.vo.Error;
import in.gov.uidai.srdh.portal.vo.AdvanceSearchParameters;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author DK92361 This is service class for search operation SearchAction class
 *         uses this service class to search the record from database. This
 *         class calls the DAO layer object to obtain the search results. It
 *         passes the search results from DAO layer back to the action class
 */

public class SearchServiceImpl {

	private SearchDao searchDAO;

	private static final Logger LOG = Logger
			.getLogger(in.gov.uidai.srdh.portal.service.impl.SearchServiceImpl.class);



	public SearchDao getSearchDAO() {
		return searchDAO;
	}



	public void setSearchDAO(SearchDao searchDAO) {
		this.searchDAO = searchDAO;
	}



	/**
	 * 
	 * @param searchParameters
	 * @return List object containing search results.
	 * 
	 *         Step 1 : It calls the DAO layer method to get the search results
	 *         by passing the AdvanceSearchParameters VO Step 2 : It calls the
	 *         private addressNormalization method by passing the list of search
	 *         results. Step 3 : It returns the List object containing searched
	 *         results.
	 * @throws Exception
	 * 
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getSearchResultsService(AdvanceSearchParameters searchParameter,
			AuditSearch auditSearch){
		List<Enrollment> searchResultList = new ArrayList<Enrollment>();
		Map resultMap = new HashMap();
		try {
			auditSearch.setRequestXml(AuthPojoUtil.pojoToXmlString(searchParameter));
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			auditSearch.setResponseDate(sqlDate);
			searchDAO.auditSearchParameters(auditSearch);
			searchParameter = Validate.validateRequestData(searchParameter);
			if(searchParameter.isValid()){
				
					int tempMaxResultSize = SearchServiceConstants.BUNDLE.SEARCH_RESULT_SIZE;
					String loopCountString = null;
					for (int i = 1; i <= SearchServiceConstants.BUNDLE.DATASOURCE_COUNT; i++) {
						loopCountString = String.valueOf(i);
						searchResultList.addAll(searchDAO
								.getSearchResultsDao(searchParameter,
										loopCountString, tempMaxResultSize,
										auditSearch));
						int searchResultSize = searchResultList.size();
						if (searchResultSize < SearchServiceConstants.BUNDLE.SEARCH_RESULT_SIZE) {
							tempMaxResultSize = SearchServiceConstants.BUNDLE.SEARCH_RESULT_SIZE
									- searchResultSize;
						} else if (searchResultSize >= SearchServiceConstants.BUNDLE.SEARCH_RESULT_SIZE) {
							break;
						}
					}
				
				resultMap.put(SearchServiceConstants.RESULT, searchResultList);
			}else{
				Error invalidRequest = new Error();
				invalidRequest.setErrorDetails(searchParameter.getErrorDetails());
				resultMap.put(SearchServiceConstants.ERROR, invalidRequest);
			}
			
		} catch (Exception searchException) {
			LOG.error(StackTraceUtil.getStackTrace(searchException));
		}
		return resultMap;
	}
}