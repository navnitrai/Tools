package in.gov.uidai.srdh.portal.common.util;


import org.hibernate.SessionFactory;

public class DBController {

	private SessionFactory enrollmentSessionFactory1;
	private SessionFactory enrollmentSessionFactory2;
	private SessionFactory enrollmentSessionFactory3;
	private SessionFactory enrollmentSessionFactory4;
	private SessionFactory enrollmentSessionFactory5;
	private SessionFactory enrollmentSessionFactory6;
	private SessionFactory enrollmentSessionFactory7;
	private SessionFactory enrollmentSessionFactory8;
	private SessionFactory enrollmentSessionFactory9;

	public SessionFactory getEnrollmentSessionFactory1() {
		return enrollmentSessionFactory1;
	}

	public void setEnrollmentSessionFactory1(
			SessionFactory enrollmentSessionFactory1) {
		this.enrollmentSessionFactory1 = enrollmentSessionFactory1;
	}

	public SessionFactory getEnrollmentSessionFactory2() {
		return enrollmentSessionFactory2;
	}

	public void setEnrollmentSessionFactory2(
			SessionFactory enrollmentSessionFactory2) {
		this.enrollmentSessionFactory2 = enrollmentSessionFactory2;
	}

	public SessionFactory getEnrollmentSessionFactory3() {
		return enrollmentSessionFactory3;
	}

	public void setEnrollmentSessionFactory3(
			SessionFactory enrollmentSessionFactory3) {
		this.enrollmentSessionFactory3 = enrollmentSessionFactory3;
	}

	public SessionFactory getEnrollmentSessionFactory4() {
		return enrollmentSessionFactory4;
	}

	public void setEnrollmentSessionFactory4(
			SessionFactory enrollmentSessionFactory4) {
		this.enrollmentSessionFactory4 = enrollmentSessionFactory4;
	}

	public SessionFactory getEnrollmentSessionFactory5() {
		return enrollmentSessionFactory5;
	}

	public void setEnrollmentSessionFactory5(
			SessionFactory enrollmentSessionFactory5) {
		this.enrollmentSessionFactory5 = enrollmentSessionFactory5;
	}

	public SessionFactory getEnrollmentSessionFactory6() {
		return enrollmentSessionFactory6;
	}

	public void setEnrollmentSessionFactory6(
			SessionFactory enrollmentSessionFactory6) {
		this.enrollmentSessionFactory6 = enrollmentSessionFactory6;
	}

	public SessionFactory getEnrollmentSessionFactory7() {
		return enrollmentSessionFactory7;
	}

	public void setEnrollmentSessionFactory7(
			SessionFactory enrollmentSessionFactory7) {
		this.enrollmentSessionFactory7 = enrollmentSessionFactory7;
	}

	public SessionFactory getEnrollmentSessionFactory8() {
		return enrollmentSessionFactory8;
	}

	public void setEnrollmentSessionFactory8(
			SessionFactory enrollmentSessionFactory8) {
		this.enrollmentSessionFactory8 = enrollmentSessionFactory8;
	}

	public SessionFactory getEnrollmentSessionFactory9() {
		return enrollmentSessionFactory9;
	}

	public void setEnrollmentSessionFactory9(
			SessionFactory enrollmentSessionFactory9) {
		this.enrollmentSessionFactory9 = enrollmentSessionFactory9;
	}

	public SessionFactory getEnrollmentSessionFactory(String strId) {
		SessionFactory sessionFactory = null;
		int key = 0;
		if (strId != null) {
			if (strId.length() == 1) {
				key = Integer.parseInt(strId);
			} else if (strId.length() > 1) {
				key = getKey(Integer.parseInt(getFactoryId(strId)));
			}
			switch (key) {
			case 1:
				sessionFactory = enrollmentSessionFactory1;
				break;
			case 2:
				sessionFactory = enrollmentSessionFactory2;
				break;
			case 3:
				sessionFactory = enrollmentSessionFactory3;
				break;
			case 4:
				sessionFactory = enrollmentSessionFactory4;
				break;
			case 5:
				sessionFactory = enrollmentSessionFactory5;
				break;
			case 6:
				sessionFactory = enrollmentSessionFactory6;
				break;
			case 7:
				sessionFactory = enrollmentSessionFactory7;
				break;
			case 8:
				sessionFactory = enrollmentSessionFactory8;
				break;
			case 9:
				sessionFactory = enrollmentSessionFactory9;
				break;
			}
		}
		return sessionFactory;
	}

	private static int getKey(int factoryId) {
		int id = 0;
		switch (factoryId) {
		case 1:
			id = SearchServiceConstants.BUNDLE.UIDONE;
			break;
		case 2:
			id = SearchServiceConstants.BUNDLE.UIDTWO;
			break;
		case 3:
			id = SearchServiceConstants.BUNDLE.UIDTHREE;
			break;
		case 4:
			id = SearchServiceConstants.BUNDLE.UIDFOUR;
			break;
		case 5:
			id = SearchServiceConstants.BUNDLE.UIDFIVE;
			break;
		case 6:
			id = SearchServiceConstants.BUNDLE.UIDSIX;
			break;
		case 7:
			id = SearchServiceConstants.BUNDLE.UIDSEVEN;
			break;
		case 8:
			id = SearchServiceConstants.BUNDLE.UIDEIGHT;
			break;
		case 9:
			id = SearchServiceConstants.BUNDLE.UIDNINE;
			break;
		}
		return id;
	}

	private static String getFactoryId(String id) {
		String factoryId = null;
		if (id != null && id.length() > 0) {
			factoryId = id.substring(0, 1);
		}
		return factoryId;
	}

}
