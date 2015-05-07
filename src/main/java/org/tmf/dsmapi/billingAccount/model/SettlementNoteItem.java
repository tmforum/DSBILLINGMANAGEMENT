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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * <p>Classe Java pour SettlementNoteItem complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="SettlementNoteItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxItem" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}TaxItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="period" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}TimePeriod" minOccurs="0"/>
 *         &lt;element name="productSpecification" type="{http://orange.com/api/billingManagement/tmf/v2/model/business}ProductSpecification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementNoteItem", propOrder = {
    "itemNumber",
    "itemId",
    "itemLabel",
    "quantity",
    "taxItem",
    "period",
    "productSpecification"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity(name = "SettlementNoteItem")
@Table(name = "SETTLEMENT_NOTE_ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
public class SettlementNoteItem
    implements Serializable
{

    private final static long serialVersionUID = 11L;
    protected String itemNumber;
    protected String itemId;
    protected String itemLabel;
    protected String quantity;
    protected List<TaxItem> taxItem;
    protected Float taxExcludedUnitPrice;
    protected Float taxExcludedAmount;
    protected Float taxIncludedAmount;
    protected TimePeriod period;
    protected ProductSpecification productSpecification;
    @org.codehaus.jackson.annotate.JsonIgnore
    protected Long hjid;

    /**
     * Obtient la valeur de la propriété itemNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "ITEM_NUMBER", length = 255)
    public String getItemNumber() {
        return itemNumber;
    }

    /**
     * Définit la valeur de la propriété itemNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemNumber(String value) {
        this.itemNumber = value;
    }

    /**
     * Obtient la valeur de la propriété itemId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "ITEM_ID", length = 255)
    public String getItemId() {
        return itemId;
    }

    /**
     * Définit la valeur de la propriété itemId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

    /**
     * Obtient la valeur de la propriété itemLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "ITEM_LABEL", length = 255)
    public String getItemLabel() {
        return itemLabel;
    }

    /**
     * Définit la valeur de la propriété itemLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemLabel(String value) {
        this.itemLabel = value;
    }

    /**
     * Obtient la valeur de la propriété quantity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "QUANTITY", length = 255)
    public String getQuantity() {
        return quantity;
    }

    /**
     * Définit la valeur de la propriété quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantity(String value) {
        this.quantity = value;
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
    @JoinColumn(name = "TAX_ITEM_SETTLEMENT_NOTE_ITE_0")
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
     * Obtient la valeur de la propriété period.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriod }
     *     
     */
    @ManyToOne(targetEntity = TimePeriod.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "PERIOD_SETTLEMENT_NOTE_ITEM__0")
    public TimePeriod getPeriod() {
        return period;
    }

    /**
     * Définit la valeur de la propriété period.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriod }
     *     
     */
    public void setPeriod(TimePeriod value) {
        this.period = value;
    }

    /**
     * Obtient la valeur de la propriété productSpecification.
     * 
     * @return
     *     possible object is
     *     {@link ProductSpecification }
     *     
     */
    @ManyToOne(targetEntity = ProductSpecification.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "PRODUCT_SPECIFICATION_SETTLE_0")
    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    /**
     * Définit la valeur de la propriété productSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductSpecification }
     *     
     */
    public void setProductSpecification(ProductSpecification value) {
        this.productSpecification = value;
    }

    /**
     * Obtient la valeur de la propriété hjid.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @org.codehaus.jackson.annotate.JsonIgnore
    public Long getHjid() {
        return hjid;
    }

    /**
     * Définit la valeur de la propriété hjid.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    @Basic
    @Column(name = "TAX_EXCLUDED_UNITPRICE", precision = 20, scale = 10)
    public Float getTaxExcludedUnitPrice() {
        return taxExcludedUnitPrice;
    }

    public void setTaxExcludedUnitPrice(Float taxExcludedUnitPrice) {
        this.taxExcludedUnitPrice = taxExcludedUnitPrice;
    }

    @Basic
    @Column(name = "TAX_EXCLUDED_AMOUNT", precision = 20, scale = 10)
    public Float getTaxExcludedAmount() {
        return taxExcludedAmount;
    }

    public void setTaxExcludedAmount(Float taxExcludedAmount) {
        this.taxExcludedAmount = taxExcludedAmount;
    }

    @Basic
    @Column(name = "TAX_INCLUDED_AMOUNT", precision = 20, scale = 10)
    public Float getTaxIncludedAmount() {
        return taxIncludedAmount;
    }

    public void setTaxIncludedAmount(Float taxIncludedAmount) {
        this.taxIncludedAmount = taxIncludedAmount;
    }

}
