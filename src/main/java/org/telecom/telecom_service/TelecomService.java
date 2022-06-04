package org.telecom.telecom_service;

import org.telecom.exception.TelecomException;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.telecom_Entity.SimDetails;

import java.util.List;

public interface TelecomService {
    String simStatus(SimDetailsRequest simDetailsRequest);

    List<SimDetails> simDetails();

    SimDetails getSimDetail(SimDetailsRequest simDetailsRequest) throws TelecomException;

    Integer addSim(SimDetailsRequest simDetailsRequest);

    void updateSim(SimDetailsRequest simDetailsRequest) throws TelecomException;

    void deleteSim(SimDetailsRequest simDetailsRequest) throws TelecomException;
}
