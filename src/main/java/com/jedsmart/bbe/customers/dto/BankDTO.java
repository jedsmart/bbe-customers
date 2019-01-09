package com.jedsmart.bbe.customers.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO implements Serializable {

	private static final long serialVersionUID = -816229585466898060L;

	private Long id;
	private String code;
	private String name;

}
