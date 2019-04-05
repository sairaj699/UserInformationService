package com.user.info.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@NotNull
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
	

}
