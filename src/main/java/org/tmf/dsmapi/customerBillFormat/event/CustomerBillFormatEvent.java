package org.tmf.dsmapi.customerBillFormat.event;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import static org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.ANY;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tmf.dsmapi.billingAccount.model.BillingAccount;
import org.tmf.dsmapi.commons.utils.CustomJsonDateSerializer;
import org.tmf.dsmapi.billingAccount.model.CustomerBillFormat;

@XmlRootElement
@Entity
@Table(name="Event_CustomerBillFormat")
@JsonPropertyOrder(value = {"id", "eventTime", "eventType", "event"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CustomerBillFormatEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date eventTime;

    @Enumerated(value = EnumType.STRING)
    private CustomerBillFormatEventTypeEnum eventType;

    private CustomerBillFormat resource; //check for object

     @JsonAutoDetect(fieldVisibility = ANY)
    class EventBody {
        private CustomerBillFormat customerBillFormat;
        public CustomerBillFormat getCustomerBillFormat() {
            return customerBillFormat;
        }
        public EventBody(CustomerBillFormat customerBillFormat) { 
        this.customerBillFormat = customerBillFormat;
    }
    
       
    }
   @JsonProperty("event")
   public EventBody getEvent() {
       
       return new EventBody(getResource() );
   }

   
    @JsonIgnore 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public CustomerBillFormatEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(CustomerBillFormatEventTypeEnum eventType) {
        this.eventType = eventType;
    }

   @JsonIgnore
    public CustomerBillFormat getResource() {
        
        
        return resource;
    }

    public void setResource(CustomerBillFormat resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "CustomerBillFormatEvent{" + "id=" + id + ", eventTime=" + eventTime + ", eventType=" + eventType + ", resource=" + resource + '}';
    }


  

}
