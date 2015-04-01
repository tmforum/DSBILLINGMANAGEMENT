package org.tmf.dsmapi.customerBillingCycleSpecification.event;

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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tmf.dsmapi.commons.utils.CustomJsonDateSerializer;
import org.tmf.dsmapi.billingAccount.model.CustomerBillingCycleSpecification;

@XmlRootElement
@Entity
@Table(name="Event_CustomerBillingCycleSpecification")
@JsonPropertyOrder(value = {"id", "eventTime", "eventType", "event"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CustomerBillingCycleSpecificationEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date eventTime;

    @Enumerated(value = EnumType.STRING)
    private CustomerBillingCycleSpecificationEventTypeEnum eventType;

    private CustomerBillingCycleSpecification event; //check for object

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

    public CustomerBillingCycleSpecificationEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(CustomerBillingCycleSpecificationEventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public CustomerBillingCycleSpecification getEvent() {
        return event;
    }

    public void setEvent(CustomerBillingCycleSpecification event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CustomerBillingCycleSpecificationEvent{" + "id=" + id + ", eventTime=" + eventTime + ", eventType=" + eventType + ", event=" + event + '}';
    }

}
