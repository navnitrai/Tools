package in.gov.uidai.srdh.portal.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for enrollmentReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enrollmentReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enrollment" type="{http://www.uidai.gov.in/registar/report/1.0}enrollment" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="registarId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reportDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "srdhSearchResults", propOrder = {
    "enrollment","error"
})
public class SrdhSearchResults {

	@XmlElement
    protected List<Enrollment> enrollment;
	@XmlElement
    protected Error error;
    @XmlAttribute
    protected String registarId;
    @XmlAttribute
    protected XMLGregorianCalendar reportDate;

    /**
     * Gets the value of the enrollment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enrollment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnrollment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Enrollment }
     * 
     * 
     */
    public List<Enrollment> getEnrollment() {
        if (enrollment == null) {
            enrollment = new ArrayList<Enrollment>();
        }
        return this.enrollment;
    }

    public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
    
    
    /**
     * Gets the value of the registarId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistarId() {
        return registarId;
    }

    /**
     * Sets the value of the registarId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistarId(String value) {
        this.registarId = value;
    }

    /**
     * Gets the value of the reportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReportDate() {
        return reportDate;
    }

    /**
     * Sets the value of the reportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReportDate(XMLGregorianCalendar value) {
        this.reportDate = value;
    }

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "SrdhSearchResults [enrollment=" + enrollment + ", error="
				+ error + ", registarId=" + registarId + ", reportDate="
				+ reportDate + "]";
	}
    
	
}
