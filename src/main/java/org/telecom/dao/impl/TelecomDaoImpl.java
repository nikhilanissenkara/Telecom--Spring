package org.telecom.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telecom.exception.TelecomException;
import org.telecom.dao.TelecomDao;
import org.telecom.mapper.TelecomModelMapper;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecom_repository.TelecomRepository;
import org.telecom.telecomdto.response.SimDetailsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TelecomDaoImpl implements TelecomDao {
    @Autowired
    private TelecomRepository telecomRepository;

    private SimDetailsResponse simDetailsResponse;

    @Override
    public SimDetailsResponse simStatus(SimDetails simDetails) {
        try {
            SimDetails simDetailsEntity = telecomRepository.findBySimNumberAndServiceNumber(simDetails.getSimNumber(), simDetails.getServiceNumber());
            return  new SimDetailsResponse(simDetailsEntity.getSimId(),simDetailsEntity.getServiceNumber(), simDetailsEntity.getSimNumber(), simDetailsEntity.getSimStatus());
        } catch (Exception e) {
            throw new TelecomException("simStatus details" + e.getMessage());
        }
    }


    @Override
    public List<SimDetailsResponse> simDetails() {
        List<SimDetails> simDetailsList = (List<SimDetails>) telecomRepository.findAll();
        TelecomModelMapper telecomModelMapper = new TelecomModelMapper();
        List<SimDetailsResponse> simDetailsResponses = simDetailsList.stream().map(simDetails -> telecomModelMapper.converToResponse(simDetails)).collect(Collectors.toList());
        return simDetailsResponses;
    }

    @Override
    public SimDetailsResponse getSimDetail(SimDetails simDetails) throws TelecomException {
        Optional<SimDetails> optional=telecomRepository.findById(simDetails.getSimId());
        SimDetails simDetailsEntity =optional.orElseThrow(()-> new TelecomException("not found"));
        return new SimDetailsResponse(simDetailsEntity.getSimId(),simDetailsEntity.getServiceNumber(), simDetailsEntity.getSimNumber(), simDetailsEntity.getSimStatus());
    }

    @Override
    public List<SimDetailsResponse> addSim(SimDetails simDetails) {
        telecomRepository.save(simDetails);
        List <SimDetailsResponse> simDetailsResponses=this.simDetails();
        return simDetailsResponses;
    }

    @Override
    public SimDetailsResponse updateSim(SimDetails simDetails) throws TelecomException {
        Optional<SimDetails> optional = telecomRepository.findById(simDetails.getSimId());
        SimDetails simDetailsEntity = optional.orElseThrow(() -> new TelecomException("not found"));
        simDetailsEntity.setSimStatus(simDetails.getSimStatus());
        return new SimDetailsResponse(simDetailsEntity.getSimId(),simDetailsEntity.getServiceNumber(), simDetailsEntity.getSimNumber(), simDetailsEntity.getSimStatus());
    }

    @Override
    public List<SimDetailsResponse> deleteSim(SimDetails simDetails) throws TelecomException {
        Optional<SimDetails> optional=telecomRepository.findById(simDetails.getSimId());
        optional.orElseThrow(()->new TelecomException("Not Found"));
        telecomRepository.deleteById(simDetails.getSimId());
        List <SimDetailsResponse> simDetailsResponses=this.simDetails();
        return simDetailsResponses;
    }
}
