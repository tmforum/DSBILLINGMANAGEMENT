//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.03.31 à 11:07:31 AM CEST 
//


package org.tmf.dsmapi.billingAccount.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;


/**
 * <p>Classe Java pour BillingAccountState.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="BillingAccountState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Defined"/>
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Pending_Update"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="Pending_Closed"/>
 *     &lt;enumeration value="Closed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BillingAccountState")
@XmlEnum
public enum BillingAccountState {

    @XmlEnumValue("Defined")
    Defined("Defined"),
    @XmlEnumValue("Active")
    Active("Active"),
    @XmlEnumValue("Pending_Update")
    Pending_Update("Pending_Update"),
    @XmlEnumValue("Suspended")
    Suspended("Suspended"),
    @XmlEnumValue("Pending_Closed")
    Pending_Closed("Pending_Closed"),
    @XmlEnumValue("Closed")
    Closed("Closed");
    private final String value;

    BillingAccountState(String v) {
        value = v;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static BillingAccountState fromValue(String v) {
        for (BillingAccountState c: BillingAccountState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    @Override
    public String toString() {
        return value();
    }

}
