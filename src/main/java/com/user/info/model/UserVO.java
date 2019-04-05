package com.user.info.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@NotNull
	@Size( min = 3 , max = 20)
	@Pattern(regexp = "^[A-Za-z0-9]*$")
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
