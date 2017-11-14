package com.sp.microservice.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import com.sp.microservice.dto.AccountDetailsDto;
import com.sp.microservice.dto.TariffChangeDto;
import com.sp.microservice.entities.AccountDetailsEntity;
import com.sp.microservice.entities.TariffChangeEntity;

@Component
public class ModelMapperConfiguration {

	private ModelMapper modelMapper;

	ModelMapperConfiguration() {
		modelMapper = new ModelMapper();
	}

	public List<TariffChangeDto> retuntTariffChangeDtosList(Iterable<TariffChangeEntity> tariffChanges) {
		List<TariffChangeDto> tariffDTOList = new ArrayList<TariffChangeDto>();
		tariffChanges.forEach(tariffChange -> {
			tariffDTOList.add(modelMapper.map(tariffChange, TariffChangeDto.class));
		});
		return tariffDTOList;
	}

	public List<AccountDetailsDto> retuntAccountDetailsDtosList(Iterable<AccountDetailsEntity> accountDetailsEntity) {
		List<AccountDetailsDto> accountDTOList = new ArrayList<AccountDetailsDto>();

		accountDetailsEntity.forEach(account -> {
			accountDTOList.add(modelMapper.map(account, AccountDetailsDto.class));
		});
		return accountDTOList;
	}

	public AccountDetailsDto retuntAccountDetailsDto(AccountDetailsEntity account) {
		return modelMapper.map(account, AccountDetailsDto.class);
	}

	public TariffChangeDto retuntTariffChangeDto(TariffChangeEntity tariffChange) {
		return modelMapper.map(tariffChange, TariffChangeDto.class);
	}

	public AccountDetailsEntity convertToAccountDetailEntity(AccountDetailsDto dto) throws ParseException {
		AccountDetailsEntity entity = modelMapper.map(dto, AccountDetailsEntity.class);
		entity.setNextMeterReadingDate(Instant.parse(dto.getNextMeterReadingDate()));
		return entity;
	}

	public TariffChangeEntity convertToTariffChangeEntity(TariffChangeDto dto)
			throws ParseException, java.text.ParseException {
		TariffChangeEntity tariffChangeEntity = modelMapper.map(dto, TariffChangeEntity.class);

		java.sql.Date sql = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getTimestamp()).getTime());
		tariffChangeEntity.setTimestamp(sql);
		return tariffChangeEntity;
	}
}
