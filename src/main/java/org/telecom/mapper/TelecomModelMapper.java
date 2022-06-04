package org.telecom.mapper;


import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecomdto.response.SimDetailsResponse;

public class TelecomModelMapper {

    public SimDetails convertToEntity(SimDetailsRequest simDetailsRequest) {
        SimDetails simDetails = new SimDetails();
        simDetails.setSimStatus(simDetailsRequest.getSimStatus());
        simDetails.setSimNumber(simDetailsRequest.getSimNumber());
        simDetails.setServiceNumber(simDetails.getServiceNumber());
        simDetails.setSimId(simDetails.getSimId());
        return simDetails;
    }

    public SimDetailsResponse converToResponse(SimDetails simDetails) {
        return new SimDetailsResponse(simDetails.getSimId(), simDetails.getServiceNumber(), simDetails.getSimNumber(), simDetails.getSimStatus());
    }
}
