//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.03.31 à 11:07:31 AM CEST 
//


package org.tmf.dsmapi.billingAccount.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tmf.dsmapi.commons.utils.CustomJsonDateSerializer;


/**
 * <p>Classe Java pour AppliedCustomerBillingCharge complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AppliedCustomerBillingCharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="href" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxIncludedAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="taxExcludedAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="appliedCustomerBillingTaxRate" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}AppliedCustomerBillingTaxRate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="serviceId" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}ServiceId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productSpecification" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}ProductSpecification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="period" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}TimePeriod" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppliedCustomerBillingCharge", propOrder = {
    "id",
    "href",
    "date",
    "description",
    "type",
    "currencyCode",
    "taxIncludedAmount",
    "taxExcludedAmount",
    "appliedCustomerBillingTaxRate",
    "serviceId",
    "productSpecification",
    "period"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity(name = "AppliedCustomerBillingCharge")
@Table(name = "APPLIED_CUSTOMER_BILLING_CHA_0")
@Inheritance(strategy = InheritanceType.JOINED)
public class AppliedCustomerBillingCharge
    implements Serializable
{

    private final static long serialVersionUID = 11L;
    protected Long id;
    protected String href;
    @XmlElement(type = String.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @XmlSchemaType(name = "dateTime")
    protected Date date;
    protected String description;
    protected String type;
    protected String currencyCode;
    protected Float taxIncludedAmount;
    protected Float taxExcludedAmount;
    protected List<AppliedCustomerBillingTaxRate> appliedCustomerBillingTaxRate;
    protected List<ServiceId> serviceId;
    protected List<ProductSpecification> productSpecification;
    protected List<TimePeriod> period;

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
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "DATE_")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(Date value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "DESCRIPTION", length = 255)
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "TYPE_", length = 255)
    public String getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriété currencyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CURRENCY_CODE", length = 255)
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Définit la valeur de la propriété currencyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Obtient la valeur de la propriété taxIncludedAmount.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    @Basic
    @Column(name = "TAX_INCLUDED_AMOUNT", precision = 20, scale = 10)
    public Float getTaxIncludedAmount() {
        return taxIncludedAmount;
    }

    /**
     * Définit la valeur de la propriété taxIncludedAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTaxIncludedAmount(Float value) {
        this.taxIncludedAmount = value;
    }

    /**
     * Obtient la valeur de la propriété taxExcludedAmount.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    @Basic
    @Column(name = "TAX_EXCLUDED_AMOUNT", precision = 20, scale = 10)
    public Float getTaxExcludedAmount() {
        return taxExcludedAmount;
    }

    /**
     * Définit la valeur de la propriété taxExcludedAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTaxExcludedAmount(Float value) {
        this.taxExcludedAmount = value;
    }

    /**
     * Gets the value of the appliedCustomerBillingTaxRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appliedCustomerBillingTaxRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppliedCustomerBillingTaxRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppliedCustomerBillingTaxRate }
     * 
     * 
     */
    @OneToMany(targetEntity = AppliedCustomerBillingTaxRate.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "APPLIED_CUSTOMER_BILLING_TAX_1")
    public List<AppliedCustomerBillingTaxRate> getAppliedCustomerBillingTaxRate() {
        if (appliedCustomerBillingTaxRate == null) {
            appliedCustomerBillingTaxRate = new ArrayList<AppliedCustomerBillingTaxRate>();
        }
        return this.appliedCustomerBillingTaxRate;
    }

    /**
     * 
     * 
     */
    public void setAppliedCustomerBillingTaxRate(List<AppliedCustomerBillingTaxRate> appliedCustomerBillingTaxRate) {
        this.appliedCustomerBillingTaxRate = appliedCustomerBillingTaxRate;
    }

    /**
     * Gets the value of the serviceId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceId }
     * 
     * 
     */
    @OneToMany(targetEntity = ServiceId.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SERVICE_ID_APPLIED_CUSTOMER__0")
    public List<ServiceId> getServiceId() {
        if (serviceId == null) {
            serviceId = new ArrayList<ServiceId>();
        }
        return this.serviceId;
    }

    /**
     * 
     * 
     */
    public void setServiceId(List<ServiceId> serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Gets the value of the productSpecification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productSpecification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductSpecification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductSpecification }
     * 
     * 
     */
    @OneToMany(targetEntity = ProductSpecification.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "PRODUCT_SPECIFICATION_APPLIE_0")
    public List<ProductSpecification> getProductSpecification() {
        if (productSpecification == null) {
            productSpecification = new ArrayList<ProductSpecification>();
        }
        return this.productSpecification;
    }

    /**
     * 
     * 
     */
    public void setProductSpecification(List<ProductSpecification> productSpecification) {
        this.productSpecification = productSpecification;
    }

    /**
     * Gets the value of the period property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the period property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimePeriod }
     * 
     * 
     */
    @OneToMany(targetEntity = TimePeriod.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "PERIOD_APPLIED_CUSTOMER_BILL_0")
    public List<TimePeriod> getPeriod() {
        if (period == null) {
            period = new ArrayList<TimePeriod>();
        }
        return this.period;
    }

    /**
     * 
     * 
     */
    public void setPeriod(List<TimePeriod> period) {
        this.period = period;
    }

}
