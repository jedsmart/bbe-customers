package com.jedsmart.bbe.customers.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank implements Serializable {

	private static final long serialVersionUID = 2723873135042082959L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code")
	@NotNull
	private String code;

	@Column(name = "name")
	@NotNull
	private String name;

	@OneToMany(mappedBy = "bank")
	private List<Account> accounts;

}
