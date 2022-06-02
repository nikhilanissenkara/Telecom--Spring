package org.telecom.telecom_repository;

import org.springframework.data.repository.CrudRepository;
import org.telecom.telecom_Entity.SimDetails;

public interface TelecomRepository extends CrudRepository<SimDetails,Integer>
{
      SimDetails FindBySimNumberAndServiceNumber(Long simNumber,Long serviceNumber);
}
