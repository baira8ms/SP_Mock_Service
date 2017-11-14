package com.sp.microservice.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sp.microservice.entities.AccountDetailsEntity;

@Transactional
public interface AccountDetailsRepository extends CrudRepository<AccountDetailsEntity, Long> {

	List<AccountDetailsEntity> findByContractAccountNumber(long key);
}
