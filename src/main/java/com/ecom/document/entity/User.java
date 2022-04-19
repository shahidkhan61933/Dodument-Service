package com.ecom.document.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "ecom_user")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", initialValue = 1, allocationSize = 1, sequenceName = "id_seq")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "gmail")
	private String gmail;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "createdat")
	private Date createdAt= new Date();
	
	@OneToOne
	private PanCardFile panFile;
	
	
	
	

}
