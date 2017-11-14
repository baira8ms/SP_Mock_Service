package com.sp.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.microservice.config.ModelMapperConfiguration;
import com.sp.microservice.dto.TariffChangeDto;
import com.sp.microservice.repositories.TariffChangeRepository;

@RestController
@RequestMapping(value = "/sp/tariff_change")
public class TariffChangeController {

	@Autowired
	TariffChangeRepository tariffChangeRepository;

	@Autowired
	ModelMapperConfiguration modelMapperConfiguration;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<TariffChangeDto> getAllTariffChange() {
		return modelMapperConfiguration.retuntTariffChangeDtosList(tariffChangeRepository.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<TariffChangeDto> getTariffChangeById(@PathVariable String id) {
		return modelMapperConfiguration.retuntTariffChangeDtosList(tariffChangeRepository.findById(Long.valueOf(id)));
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public TariffChangeDto addTariffChange(@RequestBody TariffChangeDto dto) throws ParseException, java.text.ParseException {
		return modelMapperConfiguration.retuntTariffChangeDto(
				tariffChangeRepository.save(modelMapperConfiguration.convertToTariffChangeEntity(dto)));
	}

	 @RequestMapping(value = "/timestamps", method = RequestMethod.GET)
	 public List getTimeStampsInScope() {
	 return tariffChangeRepository.getTimeStampsInRange();
	 }
}