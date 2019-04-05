package com.user.info.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // need to add regex and change it to Vo
	@Id
	@GeneratedValue
	private int user_id;
	@NotEmpty
	@NotNull
	@Column(unique=true)
	private String userName;
	@NotEmpty
	@NotNull
	private String passWord;
	@Email
	@NotEmpty
	@NotNull
	private String email;
	@NotEmpty
	@NotNull
	private String phoneNumber;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_images", joinColumns = @JoinColumn(name ="user_id") )
	private List<Images> images;



	
}
