package org.telecom.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telecom.exception.TelecomException;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.dao.TelecomDao;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecom_repository.TelecomRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class TelecomDaoImpl implements TelecomDao {
    @Autowired
    private TelecomRepository telecomRepository;

    @Override
    public String simStatus(SimDetails simDetails) {
        SimDetails simDetailsEntity = telecomRepository.findBySimNumberAndServiceNumber(simDetails.getSimNumber(), simDetails.getServiceNumber());
        return simDetailsEntity.getSimStatus();
    }

    @Override
    public List<SimDetails> simDetails() {
        return (List<SimDetails>) telecomRepository.findAll();
    }

    @Override
    public SimDetails getSimDetail(Integer simId) throws TelecomException {
        Optional<SimDetails> optional=telecomRepository.findById(simId);
        SimDetails s = optional.orElseThrow(()-> new TelecomException("not found"));
        return s;
    }

    @Override
    public Integer addSim(TelecomDTO telecomDTO) {
        SimDetails simEntity=new SimDetails();
        simEntity.setSimId(telecomDTO.getSimId());
        simEntity.setSimNumber(telecomDTO.getSimNumber());
        simEntity.setServiceNumber(telecomDTO.getServiceNumber());
        simEntity.setSimStatus(telecomDTO.getStatus());
        SimDetails simEntity2 =telecomRepository.save(simEntity);
        return simEntity2.getSimId();
    }

    @Override
    public void updateSim(Integer simId, String status) throws TelecomException {
        Optional<SimDetails> optional = telecomRepository.findById(simId);
        SimDetails simDetails = optional.orElseThrow(() -> new TelecomException("not found"));
        simDetails.setSimStatus(status);
    }

    @Override
    public void deleteSim(Integer simId) throws TelecomException {
        Optional<SimDetails> optional=telecomRepository.findById(simId);
        optional.orElseThrow(()->new TelecomException("Not Found"));
        telecomRepository.deleteById(simId);
    }
}
