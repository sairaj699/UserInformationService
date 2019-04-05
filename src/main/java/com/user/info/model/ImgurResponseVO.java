package com.user.info.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImgurResponseVO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private ImgurDataVO data;
	@JsonIgnore
	private String success;
	@JsonIgnore
	private String status;
	
	

}
