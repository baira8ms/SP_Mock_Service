package com.sp.microservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetailsDto {
	private long contractAccountNumber;
	private String service;
	private String accountBalance;
	private String directDebitAmt;
	private String meterReadingType;
	private String paymentPlan;
	private String nextMeterReadingDate;
}
