package com.sp.microservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TariffChangeDto {
	private long id;
	private String canumber;
	private String quoteId;
	private String referenceId;
	private String error;
	private String selectedProduct;
	private String timestamp;
	private String channel;
	private String currentProduct;
}
