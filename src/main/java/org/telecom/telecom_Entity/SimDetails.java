package org.telecom.telecom_Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimDetails
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer simId;
    private Long serviceNumber;
    private Long simNumber;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public Integer getSimId() {
        return simId;
    }

    public void setSimId(Integer simId) {
        this.simId = simId;
    }

    public long getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(long serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public long getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(long simNumber) {
        this.simNumber = simNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                '}';
    }
}
