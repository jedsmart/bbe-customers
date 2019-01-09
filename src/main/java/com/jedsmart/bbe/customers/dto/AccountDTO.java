package com.jedsmart.bbe.customers.dto;

import java.io.Serializable;

import com.jedsmart.bbe.customers.model.AccountType;

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

	private Long id;
	private Long customerId;
	private Long bankId;
	private AccountType type;
	private String number;
	private String holderId;
	private String holderName;
	private String holderMail;
	private String holderPhone;

}
