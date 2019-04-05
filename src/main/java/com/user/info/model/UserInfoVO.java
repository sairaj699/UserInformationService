package com.user.info.model;

import java.io.Serializable;
import java.util.List;

import com.user.info.entity.Images;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoVO  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	private String phoneNumber;
	private List<Images> images;

}
