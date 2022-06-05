package org.telecom.telecomdto.response;

public class SimDetailsResponse {

    public SimDetailsResponse() {
    }

    public SimDetailsResponse(Integer simId, Long serviceNumber, Long simNumber, String simStatus) {
        this.simId = simId;
        this.serviceNumber = serviceNumber;
        this.simNumber = simNumber;
        this.simStatus = simStatus;
    }

    public SimDetailsResponse(String simStatus) {
        this.simStatus = simStatus;
    }

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
        return "SimDetailsResponse{" +
                "simId=" + simId +
                ", serviceNumber=" + serviceNumber +
                ", simNumber=" + simNumber +
                ", simStatus='" + simStatus + '\'' +
                '}';
    }
}
