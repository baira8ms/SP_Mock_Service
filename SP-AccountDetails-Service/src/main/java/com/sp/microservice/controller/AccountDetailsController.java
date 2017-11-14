package com.sp.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.microservice.config.ModelMapperConfiguration;
import com.sp.microservice.dto.AccountDetailsDto;
import com.sp.microservice.repositories.AccountDetailsRepository;
import com.sp.microservice.repositories.TariffChangeRepository;

@RestController
@RequestMapping(value = "/sp/account_details")
public class AccountDetailsController {

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	TariffChangeRepository tariffChangeRepository;

	@Autowired
	ModelMapperConfiguration modelMapperConfiguration;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<AccountDetailsDto> getAllAccountDetails() {
		return modelMapperConfiguration.retuntAccountDetailsDtosList(accountDetailsRepository.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<AccountDetailsDto> getAccountDetailsByAccountId(@PathVariable String id) {
		return modelMapperConfiguration
				.retuntAccountDetailsDtosList(accountDetailsRepository.findByContractAccountNumber(Long.valueOf(id)));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public AccountDetailsDto addAccountDetails(@RequestBody AccountDetailsDto accountDetailsDto) {
		return modelMapperConfiguration.retuntAccountDetailsDto(accountDetailsRepository
				.save(modelMapperConfiguration.convertToAccountDetailEntity(accountDetailsDto)));
	}

}
