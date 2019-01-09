package com.jedsmart.bbe.customers.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 150733654573554225L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "firstname", length = 128)
	@NotNull
	private String firstName;

	@Column(name = "lastname", length = 128)
	@NotNull
	private String lastName;

	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;

	@Column(name = "reg_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Column(name = "mod_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modDate;

}