package in.gov.uidai.srdh.portal.dao;

import java.util.List;

import in.gov.uidai.srdh.portal.common.util.SearchException;
import in.gov.uidai.srdh.portal.vo.AuditSearch;
import in.gov.uidai.srdh.portal.vo.Enrollment;
import in.gov.uidai.srdh.portal.vo.AdvanceSearchParameters;

public interface SearchDao {
	public void auditSearchParameters(AuditSearch auditSearch)throws SearchException;
	public List<Enrollment> getSearchResultsDao(
			AdvanceSearchParameters advanceSearchParameters, String uid,
			int maxResult, AuditSearch auditSearch) throws SearchException ;
}
