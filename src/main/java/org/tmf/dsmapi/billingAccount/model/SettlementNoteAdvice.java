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
import javax.persistence.ManyToOne;
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
 * <p>Classe Java pour SettlementNoteAdvice complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="SettlementNoteAdvice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="href" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentDueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="taxDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxExcludedAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="taxIncludedAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="taxItem" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}TaxItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="settlementMethod" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}SettlementMethod" minOccurs="0"/>
 *         &lt;element name="receiver" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}Receiver" minOccurs="0"/>
 *         &lt;element name="issuer" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}Issuer" minOccurs="0"/>
 *         &lt;element name="settlementNoteImage" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}SettlementNoteImage" minOccurs="0"/>
 *         &lt;element name="settlementNoteItem" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}SettlementNoteItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementNoteAdvice", propOrder = {
    "id",
    "href",
    "date",
    "description",
    "paymentDueDate",
    "taxDate",
    "currencyCode",
    "taxExcludedAmount",
    "taxIncludedAmount",
    "taxItem",
    "settlementMethod",
    "receiver",
    "issuer",
    "settlementNoteImage",
    "settlementNoteItem"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity(name = "SettlementNoteAdvice")
@Table(name = "SETTLEMENT_NOTE_ADVICE")
@Inheritance(strategy = InheritanceType.JOINED)
public class SettlementNoteAdvice
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
    @XmlElement(type = String.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @XmlSchemaType(name = "dateTime")
    protected Date paymentDueDate;
    @XmlElement(type = String.class)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @XmlSchemaType(name = "dateTime")
    protected Date taxDate;
    protected String currencyCode;
    protected Float taxExcludedAmount;
    protected Float taxIncludedAmount;
    protected List<TaxItem> taxItem;
    protected SettlementMethod settlementMethod;
    protected Receiver receiver;
    protected Issuer issuer;
    protected SettlementNoteImage settlementNoteImage;
    protected List<SettlementNoteItem> settlementNoteItem;

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
     * Obtient la valeur de la propriété paymentDueDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "PAYMENT_DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * Définit la valeur de la propriété paymentDueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDueDate(Date value) {
        this.paymentDueDate = value;
    }

    /**
     * Obtient la valeur de la propriété taxDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "TAX_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTaxDate() {
        return taxDate;
    }

    /**
     * Définit la valeur de la propriété taxDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxDate(Date value) {
        this.taxDate = value;
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
     * Gets the value of the taxItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxItem }
     * 
     * 
     */
    @OneToMany(targetEntity = TaxItem.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "TAX_ITEM_SETTLEMENT_NOTE_ADV_0")
    public List<TaxItem> getTaxItem() {
        if (taxItem == null) {
            taxItem = new ArrayList<TaxItem>();
        }
        return this.taxItem;
    }

    /**
     * 
     * 
     */
    public void setTaxItem(List<TaxItem> taxItem) {
        this.taxItem = taxItem;
    }

    /**
     * Obtient la valeur de la propriété settlementMethod.
     * 
     * @return
     *     possible object is
     *     {@link SettlementMethod }
     *     
     */
    @ManyToOne(targetEntity = SettlementMethod.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SETTLEMENT_METHOD_SETTLEMENT_0")
    public SettlementMethod getSettlementMethod() {
        return settlementMethod;
    }

    /**
     * Définit la valeur de la propriété settlementMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementMethod }
     *     
     */
    public void setSettlementMethod(SettlementMethod value) {
        this.settlementMethod = value;
    }

    /**
     * Obtient la valeur de la propriété receiver.
     * 
     * @return
     *     possible object is
     *     {@link Receiver }
     *     
     */
    @ManyToOne(targetEntity = Receiver.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "RECEIVER_SETTLEMENT_NOTE_ADV_0")
    public Receiver getReceiver() {
        return receiver;
    }

    /**
     * Définit la valeur de la propriété receiver.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiver }
     *     
     */
    public void setReceiver(Receiver value) {
        this.receiver = value;
    }

    /**
     * Obtient la valeur de la propriété issuer.
     * 
     * @return
     *     possible object is
     *     {@link Issuer }
     *     
     */
    @ManyToOne(targetEntity = Issuer.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "ISSUER_SETTLEMENT_NOTE_ADVIC_0")
    public Issuer getIssuer() {
        return issuer;
    }

    /**
     * Définit la valeur de la propriété issuer.
     * 
     * @param value
     *     allowed object is
     *     {@link Issuer }
     *     
     */
    public void setIssuer(Issuer value) {
        this.issuer = value;
    }

    /**
     * Obtient la valeur de la propriété settlementNoteImage.
     * 
     * @return
     *     possible object is
     *     {@link SettlementNoteImage }
     *     
     */
    @ManyToOne(targetEntity = SettlementNoteImage.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SETTLEMENT_NOTE_IMAGE_SETTLE_0")
    public SettlementNoteImage getSettlementNoteImage() {
        return settlementNoteImage;
    }

    /**
     * Définit la valeur de la propriété settlementNoteImage.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementNoteImage }
     *     
     */
    public void setSettlementNoteImage(SettlementNoteImage value) {
        this.settlementNoteImage = value;
    }

    /**
     * Gets the value of the settlementNoteItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the settlementNoteItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSettlementNoteItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SettlementNoteItem }
     * 
     * 
     */
    @OneToMany(targetEntity = SettlementNoteItem.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SETTLEMENT_NOTE_ITEM_SETTLEM_0")
    public List<SettlementNoteItem> getSettlementNoteItem() {
        if (settlementNoteItem == null) {
            settlementNoteItem = new ArrayList<SettlementNoteItem>();
        }
        return this.settlementNoteItem;
    }

    /**
     * 
     * 
     */
    public void setSettlementNoteItem(List<SettlementNoteItem> settlementNoteItem) {
        this.settlementNoteItem = settlementNoteItem;
    }

}
