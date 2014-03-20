package in.gov.uidai.srdh.portal.dao.impl;

import in.gov.uidai.srdh.portal.common.util.DBController;
import in.gov.uidai.srdh.portal.common.util.SearchException;
import in.gov.uidai.srdh.portal.common.util.SearchServiceConstants;
import in.gov.uidai.srdh.portal.common.util.StackTraceUtil;
import in.gov.uidai.srdh.portal.dao.SearchDao;
import in.gov.uidai.srdh.portal.vo.AdvanceSearchParameters;
import in.gov.uidai.srdh.portal.vo.AuditSearch;
import in.gov.uidai.srdh.portal.vo.Enrollment;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *This class Interacts with database to get the data from the
 *         database
 * 
 */
public class SearchDAOImpl implements SearchDao {

	private SessionFactory enrollmentSessionFactory;
	private SessionFactory commonSessionFactory;
	private DBController dbController;
	private static final Logger LOG = Logger
			.getLogger(in.gov.uidai.srdh.portal.dao.impl.SearchDAOImpl.class);

	public SessionFactory getEnrollmentSessionFactory() {
		return enrollmentSessionFactory;
	}

	public void setEnrollmentSessionFactory(
			SessionFactory enrollmentSessionFactory) {
		this.enrollmentSessionFactory = enrollmentSessionFactory;
	}

	public SessionFactory getCommonSessionFactory() {
		return commonSessionFactory;
	}

	public void setCommonSessionFactory(SessionFactory commonSessionFactory) {
		this.commonSessionFactory = commonSessionFactory;
	}

	public DBController getDbController() {
		return dbController;
	}

	public void setDbController(DBController dbController) {
		this.dbController = dbController;
	}

	/**
	 * This method is used to search the data in database using spring ORM and
	 * hibernate.
	 * 
	 * @param searchParameters
	 * @return List object containing search results
	 * 
	 *         Step 1 : It creates Spring session by calling openSession method
	 *         of enrollmentSessionFactory. Step 2 : It creates an criteria
	 *         object in the session for Enrollment Vo. Step 3 : It calls the
	 *         private method createDynamicQuery by passing criteria and
	 *         AdvanceSearchParameters objects. Step 4 : It performs database
	 *         transaction and gets the list of search results. Step 5 : It
	 *         returns the List object containing search results.
	 */
	@Override
	public synchronized void auditSearchParameters(AuditSearch auditSearch){
		Session commonSession = null;
		Transaction tx;
		try{
			commonSession = commonSessionFactory.openSession();
			tx = commonSession.beginTransaction();
			commonSession.save(auditSearch);
			tx.commit();
		}catch (Exception e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
		}finally{
			commonSession.close();
		}
	}
	@Override
	@SuppressWarnings({"unchecked" })
	public List<Enrollment> getSearchResultsDao(
			AdvanceSearchParameters advanceSearchParameters, String shard,
			int maxResult, AuditSearch auditSearch){
		Session session = null;
		Criteria criteria = null;
		List<Enrollment> searchResultList = new ArrayList<Enrollment>();
		try {
			session = dbController.getEnrollmentSessionFactory(shard)
					.openSession();
			criteria = session.createCriteria(Enrollment.class);
			criteria.createAlias("enrolmentdetails", "output",
					Criteria.LEFT_JOIN);
			criteria = createDynamicQuery(criteria, advanceSearchParameters, maxResult);
			searchResultList = criteria.list();
		} catch (Exception e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
		} finally {
			session.close();
		}
		return searchResultList;
	}

	private Criteria createDynamicQuery(Criteria criteria,
			AdvanceSearchParameters advanceSearchParameters, int maxResults)
			throws SearchException {
		if (advanceSearchParameters.getDateSearchType() != null) {
				if (advanceSearchParameters.getDateSearchType().equalsIgnoreCase(
						SearchServiceConstants.SEARCH_DATETYPEDOB)) {
					criteria.add(Restrictions.between(
							SearchServiceConstants.SEARCH_DOB, advanceSearchParameters.getStartDateInDate(),
							advanceSearchParameters.getEndDateInDate()));

				} else if (advanceSearchParameters.getDateSearchType()
						.equalsIgnoreCase(
								SearchServiceConstants.SEARCH_DATETYPECREATED)) {
					criteria.add(Restrictions.between("createdDate", advanceSearchParameters.getStartDateInDate(),
							advanceSearchParameters.getEndDateInDate()));
				} else if (advanceSearchParameters.getDateSearchType()
						.equalsIgnoreCase(
								SearchServiceConstants.SEARCH_DATETYPEMODIFIED_UPDATED)) {
					criteria.add(Restrictions.between(
							SearchServiceConstants.SEARCH_UPDATED, advanceSearchParameters.getStartDateInDate(),
							advanceSearchParameters.getEndDateInDate()));
				}
		}

		if (advanceSearchParameters.getUid() != null
				&& advanceSearchParameters.getUid().length() != 0) {
			if (advanceSearchParameters.getUid().length() < 12) {
				criteria.add(Restrictions.like(
						SearchServiceConstants.SEARCH_UID,
						advanceSearchParameters.getUid(), MatchMode.START));
			} else if (advanceSearchParameters.getUid().length() == 12) {
				criteria.add(Restrictions.eq(SearchServiceConstants.SEARCH_UID,
						advanceSearchParameters.getUid()));
			}
		}
		if (advanceSearchParameters.getEid() != null
				&& advanceSearchParameters.getEid().length() != 0) {
			if (advanceSearchParameters.getEid().length() < 28) {
				criteria.add(Restrictions.like(
						SearchServiceConstants.SEARCH_LATEST_EID,
						advanceSearchParameters.getEid(), MatchMode.START));
			} else if (advanceSearchParameters.getEid().length() == 28) {
				criteria.add(Restrictions.eq(
						SearchServiceConstants.SEARCH_LATEST_EID,
						advanceSearchParameters.getEid()));
			}
		}
		if (advanceSearchParameters.getName() != null
				&& advanceSearchParameters.getName().length() != 0) {
			criteria.add(Restrictions.like(SearchServiceConstants.SEARCH_NAME,
					advanceSearchParameters.getName(), MatchMode.START));
		}

		if (advanceSearchParameters.getGender() != null) {
			criteria.add(Restrictions.eq(SearchServiceConstants.SEARCH_GENDER,
					advanceSearchParameters.getGender()));
		}

		if (advanceSearchParameters.getStreet() != null
				&& advanceSearchParameters.getStreet().length() != 0) {
			criteria.add(Restrictions.like(
					SearchServiceConstants.SEARCH_STREET,
					advanceSearchParameters.getStreet(), MatchMode.START));
		}
		if (advanceSearchParameters.getBuilding() != null
				&& advanceSearchParameters.getBuilding().length() != 0) {
			criteria.add(Restrictions.like(
					SearchServiceConstants.SEARCH_BUILDING,
					advanceSearchParameters.getBuilding(), MatchMode.START));
		}
		if (advanceSearchParameters.getState() != null
				&& advanceSearchParameters.getState().length() != 0) {
			criteria.add(Restrictions.like(SearchServiceConstants.SEARCH_STATE,
					advanceSearchParameters.getState(), MatchMode.START));
		}
		if (advanceSearchParameters.getLocality() != null
				&& advanceSearchParameters.getLocality().length() != 0) {
			criteria.add(Restrictions.like(
					SearchServiceConstants.SEARCH_LOCALITY,
					advanceSearchParameters.getLocality(), MatchMode.START));
		}
		if (advanceSearchParameters.getDistrict() != null
				&& advanceSearchParameters.getDistrict().length() != 0) {
			criteria.add(Restrictions.like(
					SearchServiceConstants.SEARCH_DISTRICT,
					advanceSearchParameters.getDistrict(), MatchMode.START));
		}
		if (advanceSearchParameters.getVtc() != null
				&& advanceSearchParameters.getVtc().length() != 0) {
			criteria.add(Restrictions.like(SearchServiceConstants.SEARCH_VTC,
					advanceSearchParameters.getVtc(), MatchMode.START));
		}
		if (advanceSearchParameters.getPincode() != null
				&& advanceSearchParameters.getPincode().length() != 0) {
			if (advanceSearchParameters.getPincode().length() < 6) {
				criteria.add(Restrictions.like(
						SearchServiceConstants.SEARCH_PINCODE,
						advanceSearchParameters.getPincode(), MatchMode.START));
			} else if (advanceSearchParameters.getPincode().length() == 6) {
				criteria.add(Restrictions.eq(
						SearchServiceConstants.SEARCH_PINCODE,
						advanceSearchParameters.getPincode()));
			}
		}
		if (advanceSearchParameters.getMobile() != null
				&& advanceSearchParameters.getMobile().length() != 0) {
			criteria.add(Restrictions.like(
					SearchServiceConstants.SEARCH_MOBILE,
					advanceSearchParameters.getMobile(), MatchMode.START));
		}
		if (advanceSearchParameters.getEmail() != null
				&& advanceSearchParameters.getEmail().length() != 0) {
			criteria.add(Restrictions.like(SearchServiceConstants.SEARCH_EMAIL,
					advanceSearchParameters.getEmail(), MatchMode.START));
		}
		if (advanceSearchParameters.getDeactivatedList() != null
				&& advanceSearchParameters.getDeactivatedList().equalsIgnoreCase(
						SearchServiceConstants.NO)) {

			criteria.add(Restrictions.eq(
					SearchServiceConstants.SEARCH_DEACTIVATEDFLAG,
					SearchServiceConstants.NO));
		}
		if (advanceSearchParameters.getDeactivatedList() != null
				&& advanceSearchParameters.getDeactivatedList().equalsIgnoreCase(
						SearchServiceConstants.YES)) {
			criteria.add(Restrictions.eq(
					SearchServiceConstants.SEARCH_DEACTIVATEDFLAG,
					SearchServiceConstants.YES));
		}
		criteria.setMaxResults(maxResults);
		return criteria;
	}

}