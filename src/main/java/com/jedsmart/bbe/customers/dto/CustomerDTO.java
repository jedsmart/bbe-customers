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
public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = -7779439771989018332L;

	private Long id;
	private String firstName;
	private String lastName;

}
