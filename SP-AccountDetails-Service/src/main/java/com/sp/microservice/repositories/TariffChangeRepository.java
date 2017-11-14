package com.sp.microservice.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.microservice.entities.TariffChangeEntity;

@Transactional
public interface TariffChangeRepository extends CrudRepository<TariffChangeEntity, Long> {

	List<TariffChangeEntity> findById(long id);

	@Query(value = "Select TO_CHAR(TIMESTAMP, 'hh24') FROM TARIFF_CHANGE WHERE TRUNC(TIMESTAMP)=TRUNC(SYSDATE) GROUP BY TO_CHAR(TIMESTAMP, 'hh24') ORDER BY TO_CHAR(TIMESTAMP, 'hh24')", nativeQuery = true)
	public List getTimeStampsInRange();

	@SuppressWarnings("unchecked")
	TariffChangeEntity save(TariffChangeEntity tariffChangeEntity);

}
