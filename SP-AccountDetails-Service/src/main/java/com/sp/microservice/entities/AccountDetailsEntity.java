package com.sp.microservice.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Account_Details")
@Data
@NoArgsConstructor
public class AccountDetailsEntity {

	@Id
	@Column(name = "CONTRACT_ACCOUNT_NUMBER", length = 15, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_SEQ")
    @SequenceGenerator(sequenceName = "account_sequence", allocationSize = 1, name = "ACC_SEQ")
    private long contractAccountNumber;

	@Column(name = "SERVICE", length = 25)
	private String service;

	@Column(name = "ACCOUNT_BALANCE", length = 15)
	private String accountBalance;

	@Column(name = "DIRECT_DEBIT_AMT", length = 15)
	private String directDebitAmt;

	@Column(name = "METER_READING_TYPE", length = 25)
	private String meterReadingType;

	@Column(name = "PAYMENT_PLAN", length = 15)
	private String paymentPlan;

	@Column(name = "NEXT_METER_READING_DATE")
	private Instant nextMeterReadingDate;
}