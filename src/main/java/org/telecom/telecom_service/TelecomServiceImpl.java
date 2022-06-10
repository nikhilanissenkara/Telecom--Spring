package org.telecom.telecom_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telecom.controller.TelecomController;
import org.telecom.exception.TelecomException;
import org.telecom.mapper.TelecomModelMapper;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.dao.TelecomDao;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecomdto.response.SimDetailsResponse;

import javax.transaction.Transactional;
import java.util.List;

// @Service(value="service")
// @Transactional
@Service
@Transactional
public class TelecomServiceImpl implements TelecomService {
    Logger logger = LoggerFactory.getLogger(TelecomController.class);
    @Autowired
    private TelecomDao daoImpl;

    TelecomModelMapper telecomModelMapper =  new TelecomModelMapper();

    @Override
    public SimDetailsResponse simStatus(SimDetailsRequest simDetailsRequest) {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        logger.debug("In service sim status");
        return daoImpl.simStatus(simDetails);
    }

    @Override
    public List<SimDetailsResponse> simDetails() {
        return daoImpl.simDetails();
    }

    @Override
    public SimDetailsResponse getSimDetail(SimDetailsRequest simDetailsRequest) throws TelecomException {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        return daoImpl.getSimDetail(simDetails);
    }

    @Override
    public List<SimDetailsResponse> addSim(SimDetailsRequest simDetailsRequest) {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        return daoImpl.addSim(simDetails);
    }

    @Override
    public SimDetailsResponse updateSim(SimDetailsRequest simDetailsRequest) throws TelecomException {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        return daoImpl.updateSim(simDetails);
    }

    public List<SimDetailsResponse> deleteSim(SimDetailsRequest simDetailsRequest) throws TelecomException {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        return daoImpl.deleteSim(simDetails);
    }
}
