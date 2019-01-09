package com.jedsmart.bbe.customers.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = -8722172583887353178L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false, insertable = false, updatable = false)
	private Bank bank;

	@Column(name = "account_type")
	@NotNull
	@Enumerated(EnumType.STRING)
	private AccountType type;

	@Column(name = "account_number", nullable = false)
	@NotNull
	private String number;

	@Column(name = "holder_id", nullable = false)
	@NotNull
	private String holderId;

	@Column(name = "holder_name", nullable = false)
	@NotNull
	private String holderName;

	@Column(name = "holder_mail")
	private String holderMail;

	@Column(name = "holder_phone")
	private String holderPhone;

	@Column(name = "reg_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Column(name = "mod_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modDate;

}
