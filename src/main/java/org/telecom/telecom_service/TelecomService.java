package org.telecom.telecom_service;

import org.telecom.exception.IdNotFoundException;
import org.telecom.exception.TelecomException;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecomdto.response.SimDetailsResponse;

import java.util.List;

public interface TelecomService {
    SimDetailsResponse simStatus(SimDetailsRequest simDetailsRequest);

    List<SimDetailsResponse> simDetails();

    SimDetailsResponse getSimDetail(SimDetailsRequest simDetailsRequest) throws TelecomException, IdNotFoundException;

    List<SimDetailsResponse> addSim(SimDetailsRequest simDetailsRequest);

    SimDetailsResponse updateSim(SimDetailsRequest simDetailsRequest) throws TelecomException;

    List<SimDetailsResponse> deleteSim(SimDetailsRequest simDetailsRequest) throws TelecomException;
}
