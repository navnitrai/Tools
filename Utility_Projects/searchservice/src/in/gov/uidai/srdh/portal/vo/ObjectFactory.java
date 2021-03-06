//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.21 at 03:14:12 PM GMT+05:30 
//


package in.gov.uidai.srdh.portal.vo;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the in.gov.uidai.srdh.batch.xmlprocessor.exception package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnrollmentReport_QNAME = new QName("SRDH web Services Search", "srdhSearchResults");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: in.gov.uidai.srdh.batch.xmlprocessor.exception
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SrdhSearchResults }
     * 
     */
    public SrdhSearchResults createEnrollmentReport() {
        return new SrdhSearchResults();
    }

    /**
     * Create an instance of {@link Enrollment }
     * 
     */
    public Enrollment createEnrollment() {
        return new Enrollment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SrdhSearchResults }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "SRDH web Services Search", name = "srdhSearchResults")
    public JAXBElement<SrdhSearchResults> createEnrollmentReport(SrdhSearchResults value) {
        return new JAXBElement<SrdhSearchResults>(_EnrollmentReport_QNAME, SrdhSearchResults.class, null, value);
    }

}
