package org.telecom.telecom_service;

import org.telecom.Telecom_DTO.TelecomDTO;

public interface TelecomService {
    public String simStatus(Long simNumber,Long serviceNumber);
}
