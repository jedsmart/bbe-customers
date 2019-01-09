package com.jedsmart.bbe.customers.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO implements Serializable {

	private static final long serialVersionUID = 6017038340780505665L;

	private String code;
	private String url;
	private String reason;
	private Date timestamp;

}
