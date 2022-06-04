package org.telecom.telecom_Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Sim_Details")
public class SimDetails
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer simId;
    private Long serviceNumber;
    private Long simNumber;
    private String simStatus;

    public Integer getSimId() {
        return simId;
    }

    public void setSimId(Integer simId) {
        this.simId = simId;
    }

    public Long getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(Long serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public Long getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(Long simNumber) {
        this.simNumber = simNumber;
    }

    public String getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(String simStatus) {
        this.simStatus = simStatus;
    }

    @Override
    public String toString() {
        return "SimDetails{" +
                "simId=" + simId +
                ", serviceNumber=" + serviceNumber +
                ", simNumber=" + simNumber +
                ", simStatus='" + simStatus + '\'' +
                '}';
    }
}
