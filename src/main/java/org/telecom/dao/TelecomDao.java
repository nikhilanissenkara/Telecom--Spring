package org.telecom.dao;

import org.telecom.exception.TelecomException;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.telecom_Entity.SimDetails;

import java.util.List;


public interface TelecomDao {

    String simStatus(SimDetails simDetails);

    List<SimDetails> simDetails();

    SimDetails getSimDetail(SimDetails simDetails) throws TelecomException;

    Integer addSim(SimDetails simDetails);

    void updateSim(SimDetails simDetails) throws TelecomException;

    void deleteSim(SimDetails simDetails) throws TelecomException;
}
