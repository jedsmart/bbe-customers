package com.jedsmart.bbe.customers.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jedsmart.bbe.customers.vo.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO implements Serializable {

	private static final long serialVersionUID = -7435433384869656299L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("customer_id")
	private Long customerId;

	@JsonProperty("bank_id")
	private Long bankId;

	@JsonProperty("type")
	private AccountType type;

	@JsonProperty("number")
	private String number;

	@JsonProperty("holder_id")
	private String holderId;

	@JsonProperty("holder_name")
	private String holderName;

	@JsonProperty("holder_mail")
	private String holderMail;

	@JsonProperty("holder_phone")
	private String holderPhone;

}
