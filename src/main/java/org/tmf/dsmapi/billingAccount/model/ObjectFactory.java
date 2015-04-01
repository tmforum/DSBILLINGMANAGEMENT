//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.03.31 à 11:07:31 AM CEST 
//


package org.tmf.dsmapi.billingAccount.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tmf.dsmapi.billingAccount.model package. 
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

    private final static QName _AppliedCustomerBillingTaxRate_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "AppliedCustomerBillingTaxRate");
    private final static QName _SettlementMethod_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "SettlementMethod");
    private final static QName _ServiceId_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "ServiceId");
    private final static QName _ProductSpecification_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "ProductSpecification");
    private final static QName _PaymentMean_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "PaymentMean");
    private final static QName _Currency_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "Currency");
    private final static QName _Issuer_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "Issuer");
    private final static QName _RelatedParty_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "RelatedParty");
    private final static QName _AppliedCustomerBillingCharge_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "AppliedCustomerBillingCharge");
    private final static QName _BillingAccountBalance_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "BillingAccountBalance");
    private final static QName _CustomerBillingCycleSpecification_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "CustomerBillingCycleSpecification");
    private final static QName _CustomerBillPresentationMedia_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "CustomerBillPresentationMedia");
    private final static QName _Receiver_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "Receiver");
    private final static QName _CustomerAccount_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "CustomerAccount");
    private final static QName _TimePeriod_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "TimePeriod");
    private final static QName _BillingAccount_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "BillingAccount");
    private final static QName _SettlementNoteAdvice_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "SettlementNoteAdvice");
    private final static QName _CustomerBillFormat_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "CustomerBillFormat");
    private final static QName _TaxItem_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "TaxItem");
    private final static QName _TaxRegistration_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "TaxRegistration");
    private final static QName _SettlementNoteItem_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "SettlementNoteItem");
    private final static QName _SettlementNoteImage_QNAME = new QName("http://orange.com/api/billingManagement/tmf/v2/model/business", "SettlementNoteImage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tmf.dsmapi.billingAccount.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SettlementNoteAdvice }
     * 
     */
    public SettlementNoteAdvice createSettlementNoteAdvice() {
        return new SettlementNoteAdvice();
    }

    /**
     * Create an instance of {@link CustomerBillFormat }
     * 
     */
    public CustomerBillFormat createCustomerBillFormat() {
        return new CustomerBillFormat();
    }

    /**
     * Create an instance of {@link TaxItem }
     * 
     */
    public TaxItem createTaxItem() {
        return new TaxItem();
    }

    /**
     * Create an instance of {@link TaxRegistration }
     * 
     */
    public TaxRegistration createTaxRegistration() {
        return new TaxRegistration();
    }

    /**
     * Create an instance of {@link SettlementNoteItem }
     * 
     */
    public SettlementNoteItem createSettlementNoteItem() {
        return new SettlementNoteItem();
    }

    /**
     * Create an instance of {@link SettlementNoteImage }
     * 
     */
    public SettlementNoteImage createSettlementNoteImage() {
        return new SettlementNoteImage();
    }

    /**
     * Create an instance of {@link CustomerAccount }
     * 
     */
    public CustomerAccount createCustomerAccount() {
        return new CustomerAccount();
    }

    /**
     * Create an instance of {@link TimePeriod }
     * 
     */
    public TimePeriod createTimePeriod() {
        return new TimePeriod();
    }

    /**
     * Create an instance of {@link BillingAccount }
     * 
     */
    public BillingAccount createBillingAccount() {
        return new BillingAccount();
    }

    /**
     * Create an instance of {@link Issuer }
     * 
     */
    public Issuer createIssuer() {
        return new Issuer();
    }

    /**
     * Create an instance of {@link RelatedParty }
     * 
     */
    public RelatedParty createRelatedParty() {
        return new RelatedParty();
    }

    /**
     * Create an instance of {@link CustomerBillingCycleSpecification }
     * 
     */
    public CustomerBillingCycleSpecification createCustomerBillingCycleSpecification() {
        return new CustomerBillingCycleSpecification();
    }

    /**
     * Create an instance of {@link BillingAccountBalance }
     * 
     */
    public BillingAccountBalance createBillingAccountBalance() {
        return new BillingAccountBalance();
    }

    /**
     * Create an instance of {@link AppliedCustomerBillingCharge }
     * 
     */
    public AppliedCustomerBillingCharge createAppliedCustomerBillingCharge() {
        return new AppliedCustomerBillingCharge();
    }

    /**
     * Create an instance of {@link CustomerBillPresentationMedia }
     * 
     */
    public CustomerBillPresentationMedia createCustomerBillPresentationMedia() {
        return new CustomerBillPresentationMedia();
    }

    /**
     * Create an instance of {@link Receiver }
     * 
     */
    public Receiver createReceiver() {
        return new Receiver();
    }

    /**
     * Create an instance of {@link SettlementMethod }
     * 
     */
    public SettlementMethod createSettlementMethod() {
        return new SettlementMethod();
    }

    /**
     * Create an instance of {@link AppliedCustomerBillingTaxRate }
     * 
     */
    public AppliedCustomerBillingTaxRate createAppliedCustomerBillingTaxRate() {
        return new AppliedCustomerBillingTaxRate();
    }

    /**
     * Create an instance of {@link ServiceId }
     * 
     */
    public ServiceId createServiceId() {
        return new ServiceId();
    }

    /**
     * Create an instance of {@link ProductSpecification }
     * 
     */
    public ProductSpecification createProductSpecification() {
        return new ProductSpecification();
    }

    /**
     * Create an instance of {@link Currency }
     * 
     */
    public Currency createCurrency() {
        return new Currency();
    }

    /**
     * Create an instance of {@link PaymentMean }
     * 
     */
    public PaymentMean createPaymentMean() {
        return new PaymentMean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link AppliedCustomerBillingTaxRate }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "AppliedCustomerBillingTaxRate")
    public JAXBElement<AppliedCustomerBillingTaxRate> createAppliedCustomerBillingTaxRate(AppliedCustomerBillingTaxRate value) {
        return new JAXBElement<AppliedCustomerBillingTaxRate>(_AppliedCustomerBillingTaxRate_QNAME, AppliedCustomerBillingTaxRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link SettlementMethod }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "SettlementMethod")
    public JAXBElement<SettlementMethod> createSettlementMethod(SettlementMethod value) {
        return new JAXBElement<SettlementMethod>(_SettlementMethod_QNAME, SettlementMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link ServiceId }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "ServiceId")
    public JAXBElement<ServiceId> createServiceId(ServiceId value) {
        return new JAXBElement<ServiceId>(_ServiceId_QNAME, ServiceId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link ProductSpecification }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "ProductSpecification")
    public JAXBElement<ProductSpecification> createProductSpecification(ProductSpecification value) {
        return new JAXBElement<ProductSpecification>(_ProductSpecification_QNAME, ProductSpecification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link PaymentMean }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "PaymentMean")
    public JAXBElement<PaymentMean> createPaymentMean(PaymentMean value) {
        return new JAXBElement<PaymentMean>(_PaymentMean_QNAME, PaymentMean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link Currency }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "Currency")
    public JAXBElement<Currency> createCurrency(Currency value) {
        return new JAXBElement<Currency>(_Currency_QNAME, Currency.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link Issuer }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "Issuer")
    public JAXBElement<Issuer> createIssuer(Issuer value) {
        return new JAXBElement<Issuer>(_Issuer_QNAME, Issuer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link RelatedParty }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "RelatedParty")
    public JAXBElement<RelatedParty> createRelatedParty(RelatedParty value) {
        return new JAXBElement<RelatedParty>(_RelatedParty_QNAME, RelatedParty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link AppliedCustomerBillingCharge }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "AppliedCustomerBillingCharge")
    public JAXBElement<AppliedCustomerBillingCharge> createAppliedCustomerBillingCharge(AppliedCustomerBillingCharge value) {
        return new JAXBElement<AppliedCustomerBillingCharge>(_AppliedCustomerBillingCharge_QNAME, AppliedCustomerBillingCharge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link BillingAccountBalance }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "BillingAccountBalance")
    public JAXBElement<BillingAccountBalance> createBillingAccountBalance(BillingAccountBalance value) {
        return new JAXBElement<BillingAccountBalance>(_BillingAccountBalance_QNAME, BillingAccountBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link CustomerBillingCycleSpecification }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "CustomerBillingCycleSpecification")
    public JAXBElement<CustomerBillingCycleSpecification> createCustomerBillingCycleSpecification(CustomerBillingCycleSpecification value) {
        return new JAXBElement<CustomerBillingCycleSpecification>(_CustomerBillingCycleSpecification_QNAME, CustomerBillingCycleSpecification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link CustomerBillPresentationMedia }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "CustomerBillPresentationMedia")
    public JAXBElement<CustomerBillPresentationMedia> createCustomerBillPresentationMedia(CustomerBillPresentationMedia value) {
        return new JAXBElement<CustomerBillPresentationMedia>(_CustomerBillPresentationMedia_QNAME, CustomerBillPresentationMedia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link Receiver }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "Receiver")
    public JAXBElement<Receiver> createReceiver(Receiver value) {
        return new JAXBElement<Receiver>(_Receiver_QNAME, Receiver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link CustomerAccount }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "CustomerAccount")
    public JAXBElement<CustomerAccount> createCustomerAccount(CustomerAccount value) {
        return new JAXBElement<CustomerAccount>(_CustomerAccount_QNAME, CustomerAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link TimePeriod }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "TimePeriod")
    public JAXBElement<TimePeriod> createTimePeriod(TimePeriod value) {
        return new JAXBElement<TimePeriod>(_TimePeriod_QNAME, TimePeriod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link BillingAccount }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "BillingAccount")
    public JAXBElement<BillingAccount> createBillingAccount(BillingAccount value) {
        return new JAXBElement<BillingAccount>(_BillingAccount_QNAME, BillingAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link SettlementNoteAdvice }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "SettlementNoteAdvice")
    public JAXBElement<SettlementNoteAdvice> createSettlementNoteAdvice(SettlementNoteAdvice value) {
        return new JAXBElement<SettlementNoteAdvice>(_SettlementNoteAdvice_QNAME, SettlementNoteAdvice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link CustomerBillFormat }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "CustomerBillFormat")
    public JAXBElement<CustomerBillFormat> createCustomerBillFormat(CustomerBillFormat value) {
        return new JAXBElement<CustomerBillFormat>(_CustomerBillFormat_QNAME, CustomerBillFormat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link TaxItem }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "TaxItem")
    public JAXBElement<TaxItem> createTaxItem(TaxItem value) {
        return new JAXBElement<TaxItem>(_TaxItem_QNAME, TaxItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link TaxRegistration }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "TaxRegistration")
    public JAXBElement<TaxRegistration> createTaxRegistration(TaxRegistration value) {
        return new JAXBElement<TaxRegistration>(_TaxRegistration_QNAME, TaxRegistration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link SettlementNoteItem }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "SettlementNoteItem")
    public JAXBElement<SettlementNoteItem> createSettlementNoteItem(SettlementNoteItem value) {
        return new JAXBElement<SettlementNoteItem>(_SettlementNoteItem_QNAME, SettlementNoteItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@currencyCode <}{@link SettlementNoteImage }{@currencyCode >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/billingManagement/tmf/v2/model/business", name = "SettlementNoteImage")
    public JAXBElement<SettlementNoteImage> createSettlementNoteImage(SettlementNoteImage value) {
        return new JAXBElement<SettlementNoteImage>(_SettlementNoteImage_QNAME, SettlementNoteImage.class, null, value);
    }

}
