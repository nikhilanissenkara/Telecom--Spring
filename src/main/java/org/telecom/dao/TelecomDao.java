package org.telecom.dao;

import org.telecom.exception.TelecomException;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecomdto.response.SimDetailsResponse;

import java.util.List;


public interface TelecomDao {

    SimDetailsResponse simStatus(SimDetails simDetails);

    List<SimDetailsResponse> simDetails();

    SimDetails getSimDetail(SimDetails simDetails) throws TelecomException;

    Integer addSim(SimDetails simDetails);

    void updateSim(SimDetails simDetails) throws TelecomException;

    void deleteSim(SimDetails simDetails) throws TelecomException;
}
