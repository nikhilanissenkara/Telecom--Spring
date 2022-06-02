package org.telecom.telecom_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telecom.Telecom_DTO.TelecomDTO;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecom_repository.TelecomRepository;

import javax.transaction.Transactional;
import java.util.List;

// @Service(value="service")
// @Transactional
@Service
public class TelecomServiceImpl implements TelecomService {
    @Autowired
    private TelecomRepository telecomRepository;

    @Override
    public String simStatus(Long simNumber,Long serviceNumber) {
        SimDetails simDetails=telecomRepository.FindBySimNumberAndServiceNumber(simNumber,serviceNumber);
        TelecomDTO telecomDTO=new TelecomDTO();
        telecomDTO.setServiceNumber(simDetails.getServiceNumber());
        telecomDTO.setSimNumber(simDetails.getSimNumber());
        telecomDTO.setStatus(simDetails.getStatus());
       return telecomDTO.getStatus();
    }
}
