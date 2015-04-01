package org.tmf.dsmapi.customerBillPresentationMedia.event;

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
import org.tmf.dsmapi.billingAccount.model.CustomerBillPresentationMedia;

@XmlRootElement
@Entity
@Table(name="Event_CustomerBillPresentationMedia")
@JsonPropertyOrder(value = {"id", "eventTime", "eventType", "event"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CustomerBillPresentationMediaEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    private Date eventTime;

    @Enumerated(value = EnumType.STRING)
    private CustomerBillPresentationMediaEventTypeEnum eventType;

    private CustomerBillPresentationMedia event; //check for object

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

    public CustomerBillPresentationMediaEventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(CustomerBillPresentationMediaEventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public CustomerBillPresentationMedia getEvent() {
        return event;
    }

    public void setEvent(CustomerBillPresentationMedia event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CustomerBillPresentationMediaEvent{" + "id=" + id + ", eventTime=" + eventTime + ", eventType=" + eventType + ", event=" + event + '}';
    }

}
