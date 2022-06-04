package org.telecom.telecom_repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.telecom.telecom_Entity.SimDetails;

public interface TelecomRepository extends CrudRepository<SimDetails,Integer> {
    /**
    @Query("select s from Sim_Details s where s.simNumber = :simNumber and s.serviceNumber = :serviceNumber")
    SimDetails findBySimNumberAndServiceNumber(@Param("simNumber") Long simNumber, @Param("serviceNumber") Long serviceNumber);
    **/
    // cannot find column FindBySimNumber
    SimDetails findBySimNumberAndServiceNumber(Long simNumber, Long serviceNumber);
}
