package org.telecom.Telecom_DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TelecomDTO
{

    private Integer simId;
    @NotNull
    @Min(value=10)
    private long serviceNumber;

    @NotNull
    @Min(value=10)
    private long simNumber;
    private String status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                '}';
    }
}
