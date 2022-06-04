package org.telecom.telecom_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telecom.exception.TelecomException;
import org.telecom.mapper.TelecomModelMapper;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.dao.TelecomDao;
import org.telecom.telecom_Entity.SimDetails;

import javax.transaction.Transactional;
import java.util.List;

// @Service(value="service")
// @Transactional
@Service
@Transactional
public class TelecomServiceImpl implements TelecomService {
    @Autowired
    private TelecomDao daoImpl;

    TelecomModelMapper telecomModelMapper =  new TelecomModelMapper();

    @Override
    public String simStatus(SimDetailsRequest simDetailsRequest) {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        return daoImpl.simStatus(simDetails);
    }

    @Override
    public List<SimDetails> simDetails() {
        return daoImpl.simDetails();
    }

    @Override
    public SimDetails getSimDetail(SimDetailsRequest simDetailsRequest) throws TelecomException {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        return daoImpl.getSimDetail(simDetails);
    }

    @Override
    public Integer addSim(SimDetailsRequest simDetailsRequest) {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        return daoImpl.addSim(simDetails);
    }

    @Override
    public void updateSim(SimDetailsRequest simDetailsRequest) throws TelecomException {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        daoImpl.updateSim(simDetails);
    }

    public void deleteSim(SimDetailsRequest simDetailsRequest) throws TelecomException {
        SimDetails simDetails = telecomModelMapper.convertToEntity(simDetailsRequest);
        daoImpl.deleteSim(simDetails);
    }
}
