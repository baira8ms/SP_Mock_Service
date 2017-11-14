package com.sp.microservice.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tariff_Change")
@Data
@NoArgsConstructor
@NamedNativeQueries({
		@NamedNativeQuery(name = "getAllEmployees", query = "SELECT COUNT(*),TO_CHAR(TIMESTAMP,'HH24') FROM TARIFF_CHANGE WHERE TRUNC(TIMESTAMP) = TRUNC(SYSDATE) GROUP BY TO_CHAR(TIMESTAMP,'HH24') ORDER BY TO_CHAR(TIMESTAMP,'HH24')", resultClass = TariffChangeEntity.class) })
public class TariffChangeEntity {

	@Column(name = "ID", length = 20, nullable = false, unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TARIFF_SEQ")
	@SequenceGenerator(sequenceName = "Tariff_sequence", allocationSize = 1, name = "TARIFF_SEQ")
	private long id;

	@Column(name = "CANUMBER", length = 20)
	private String canumber;

	@Column(name = "QUOTEID", length = 20)
	private String quoteId;

	@Column(name = "REFERENCEID", length = 15)
	private String referenceId;

	@Column(name = "ERROR", length = 200)
	private String error;

	@Column(name = "SELECTEDPRODUCT", length = 50)
	private String selectedProduct;

	@Column(name = "TIMESTAMP")
	private Date timestamp;

	@Column(name = "CHANNEL", length = 15)
	private String channel;

	@Column(name = "CURRENTPRODUCT", length = 80)
	private String currentProduct;
}