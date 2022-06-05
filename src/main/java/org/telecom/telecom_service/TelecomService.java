package org.telecom.telecom_service;

import org.telecom.exception.TelecomException;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecomdto.response.SimDetailsResponse;

import java.util.List;

public interface TelecomService {
    SimDetailsResponse simStatus(SimDetailsRequest simDetailsRequest);

    List<SimDetailsResponse> simDetails();

    SimDetails getSimDetail(SimDetailsRequest simDetailsRequest) throws TelecomException;

    Integer addSim(SimDetailsRequest simDetailsRequest);

    void updateSim(SimDetailsRequest simDetailsRequest) throws TelecomException;

    void deleteSim(SimDetailsRequest simDetailsRequest) throws TelecomException;
}
