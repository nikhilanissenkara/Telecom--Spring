package org.telecom.dao;

import org.telecom.exception.IdNotFoundException;
import org.telecom.exception.TelecomException;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecomdto.response.SimDetailsResponse;

import java.util.List;


public interface TelecomDao {

    SimDetailsResponse simStatus(SimDetails simDetails);

    List<SimDetailsResponse> simDetails();

    SimDetailsResponse getSimDetail(SimDetails simDetails) throws TelecomException, IdNotFoundException;

    List<SimDetailsResponse> addSim(SimDetails simDetails);

    SimDetailsResponse updateSim(SimDetails simDetails) throws TelecomException;

    List<SimDetailsResponse> deleteSim(SimDetails simDetails) throws TelecomException;
}
