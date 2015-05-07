//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.03.31 à 11:07:31 AM CEST 
//


package org.tmf.dsmapi.billingAccount.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * <p>Classe Java pour BillingAccount complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="BillingAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="href" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ratingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}BillingAccountState" minOccurs="0"/>
 *         &lt;element name="validFor" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}TimePeriod" minOccurs="0"/>
 *         &lt;element name="customerAccount" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}CustomerAccount" minOccurs="0"/>
 *         &lt;element name="customerBillingCycleSpecification" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}CustomerBillingCycleSpecification" minOccurs="0"/>
 *         &lt;element name="customerBillFormat" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}CustomerBillFormat" minOccurs="0"/>
 *         &lt;element name="customerBillPresentationMedia" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}CustomerBillPresentationMedia" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}Currency" minOccurs="0"/>
 *         &lt;element name="billingAccountBalance" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}BillingAccountBalance" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="relatedParty" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}RelatedParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paymentMean" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}PaymentMean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAccount", propOrder = {
    "id",
    "href",
    "ratingType",
    "name",
    "state",
    "validFor",
    "customerAccount",
    "customerBillingCycleSpecification",
    "customerBillFormat",
    "customerBillPresentationMedia",
    "currency",
    "billingAccountBalance",
    "relatedParty",
    "paymentMean"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity(name = "BillingAccount")
@Table(name = "BILLING_ACCOUNT")
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingAccount
    implements Serializable
{

    private final static long serialVersionUID = 11L;
    protected Long id;
    protected String href;
    protected String ratingType;
    protected String name;
    protected BillingAccountState state;
    protected TimePeriod validFor;
    protected BillingReference customerAccount;
    protected BillingReference customerBillingCycleSpecification;
    protected BillingReference customerBillFormat;
    protected BillingReference customerBillPresentationMedia;
    protected Currency currency;
    protected List<BillingAccountBalance> billingAccountBalance;
    protected List<BillingReference> relatedParty;
    protected BillingReference paymentMean;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "ID", scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété href.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "HREF", length = 255)
    public String getHref() {
        return href;
    }

    /**
     * Définit la valeur de la propriété href.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Obtient la valeur de la propriété ratingType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "RATING_TYPE", length = 255)
    public String getRatingType() {
        return ratingType;
    }

    /**
     * Définit la valeur de la propriété ratingType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatingType(String value) {
        this.ratingType = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "NAME_", length = 255)
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété state.
     * 
     * @return
     *     possible object is
     *     {@link BillingAccountState }
     *     
     */
    @Basic
    @Column(name = "STATE_", length = 255)
    @Enumerated(EnumType.STRING)
    public BillingAccountState getState() {
        return state;
    }

    /**
     * Définit la valeur de la propriété state.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingAccountState }
     *     
     */
    public void setState(BillingAccountState value) {
        this.state = value;
    }

    /**
     * Obtient la valeur de la propriété validFor.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriod }
     *     
     */
    @ManyToOne(targetEntity = TimePeriod.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "VALID_FOR_BILLING_ACCOUNT_HJ_0")
    public TimePeriod getValidFor() {
        return validFor;
    }

    /**
     * Définit la valeur de la propriété validFor.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriod }
     *     
     */
    public void setValidFor(TimePeriod value) {
        this.validFor = value;
    }

    /**
     * Obtient la valeur de la propriété customerAccount.
     * 
     * @return
     *     possible object is
     *     {@link BillingReference }
     *     
     */
    @ManyToOne(targetEntity = BillingReference.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "CUSTOMER_ACCOUNT_BILLING_ACC_0")
    public BillingReference getCustomerAccount() {
        return customerAccount;
    }

    /**
     * Définit la valeur de la propriété customerAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingReference }
     *     
     */
    public void setCustomerAccount(BillingReference value) {
        this.customerAccount = value;
    }

    /**
     * Obtient la valeur de la propriété customerBillingCycleSpecification.
     * 
     * @return
     *     possible object is
     *     {@link BillingReference }
     *     
     */
    @ManyToOne(targetEntity = BillingReference.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "CUSTOMER_BILLING_CYCLE_SPECI_1")
    public BillingReference getCustomerBillingCycleSpecification() {
        return customerBillingCycleSpecification;
    }

    /**
     * Définit la valeur de la propriété customerBillingCycleSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingReference }
     *     
     */
    public void setCustomerBillingCycleSpecification(BillingReference value) {
        this.customerBillingCycleSpecification = value;
    }

    /**
     * Obtient la valeur de la propriété customerBillFormat.
     * 
     * @return
     *     possible object is
     *     {@link BillingReference }
     *     
     */
    @ManyToOne(targetEntity = BillingReference.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "CUSTOMER_BILL_FORMAT_BILLING_0")
    public BillingReference getCustomerBillFormat() {
        return customerBillFormat;
    }

    /**
     * Définit la valeur de la propriété customerBillFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingReference }
     *     
     */
    public void setCustomerBillFormat(BillingReference value) {
        this.customerBillFormat = value;
    }

    /**
     * Obtient la valeur de la propriété customerBillPresentationMedia.
     * 
     * @return
     *     possible object is
     *     {@link BillingReference }
     *     
     */
    @ManyToOne(targetEntity = BillingReference.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "CUSTOMER_BILL_PRESENTATION_M_1")
    public BillingReference getCustomerBillPresentationMedia() {
        return customerBillPresentationMedia;
    }

    /**
     * Définit la valeur de la propriété customerBillPresentationMedia.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingReference }
     *     
     */
    public void setCustomerBillPresentationMedia(BillingReference value) {
        this.customerBillPresentationMedia = value;
    }

    /**
     * Obtient la valeur de la propriété currency.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    @ManyToOne(targetEntity = Currency.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "CURRENCY_BILLING_ACCOUNT_HJID")
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Définit la valeur de la propriété currency.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrency(Currency value) {
        this.currency = value;
    }

    /**
     * Gets the value of the billingAccountBalance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingAccountBalance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingAccountBalance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingAccountBalance }
     * 
     * 
     */
    @OneToMany(targetEntity = BillingAccountBalance.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "BILLING_ACCOUNT_BALANCE_BILL_0")
    public List<BillingAccountBalance> getBillingAccountBalance() {
        if (billingAccountBalance == null) {
            billingAccountBalance = new ArrayList<BillingAccountBalance>();
        }
        return this.billingAccountBalance;
    }

    /**
     * 
     * 
     */
    public void setBillingAccountBalance(List<BillingAccountBalance> billingAccountBalance) {
        this.billingAccountBalance = billingAccountBalance;
    }

    /**
     * Gets the value of the relatedParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingReference }
     * 
     * 
     */
    @OneToMany(targetEntity = BillingReference.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "RELATED_PARTY_BILLING_ACCOUN_0")
    public List<BillingReference> getRelatedParty() {
        if (relatedParty == null) {
            relatedParty = new ArrayList<BillingReference>();
        }
        return this.relatedParty;
    }

    /**
     * 
     * 
     */
    public void setRelatedParty(List<BillingReference> relatedParty) {
        this.relatedParty = relatedParty;
    }

    /**
     * Obtient la valeur de la propriété paymentMean.
     * 
     * @return
     *     possible object is
     *     {@link BillingReference }
     *     
     */
    @ManyToOne(targetEntity = BillingReference.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "PAYMENT_MEAN_BILLING_ACCOUNT_0")
    public BillingReference getPaymentMean() {
        return paymentMean;
    }

    /**
     * Définit la valeur de la propriété paymentMean.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingReference }
     *     
     */
    public void setPaymentMean(BillingReference value) {
        this.paymentMean = value;
    }

}
