//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.03.31 à 11:07:31 AM CEST 
//


package org.tmf.dsmapi.billingAccount.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * <p>Classe Java pour SettlementNoteImage complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="SettlementNoteImage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imageFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageFileURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementNoteImage", propOrder = {
    "imageFormat",
    "imageSize",
    "imageFileName",
    "imageFileURL"
})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity(name = "SettlementNoteImage")
@Table(name = "SETTLEMENT_NOTE_IMAGE")
@Inheritance(strategy = InheritanceType.JOINED)
public class SettlementNoteImage
    implements Serializable
{

    private final static long serialVersionUID = 11L;
    protected String imageFormat;
    protected String imageSize;
    protected String imageFileName;
    protected String imageFileURL;
    @org.codehaus.jackson.annotate.JsonIgnore
    protected Long hjid;

    /**
     * Obtient la valeur de la propriété imageFormat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "IMAGE_FORMAT", length = 255)
    public String getImageFormat() {
        return imageFormat;
    }

    /**
     * Définit la valeur de la propriété imageFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageFormat(String value) {
        this.imageFormat = value;
    }

    /**
     * Obtient la valeur de la propriété imageSize.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "IMAGE_SIZE", length = 255)
    public String getImageSize() {
        return imageSize;
    }

    /**
     * Définit la valeur de la propriété imageSize.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageSize(String value) {
        this.imageSize = value;
    }

    /**
     * Obtient la valeur de la propriété imageFileName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "IMAGE_FILE_NAME", length = 255)
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * Définit la valeur de la propriété imageFileName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageFileName(String value) {
        this.imageFileName = value;
    }

    /**
     * Obtient la valeur de la propriété imageFileURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "IMAGE_FILE_URL", length = 255)
    public String getImageFileURL() {
        return imageFileURL;
    }

    /**
     * Définit la valeur de la propriété imageFileURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageFileURL(String value) {
        this.imageFileURL = value;
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

}
