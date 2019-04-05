package com.user.info.service;

import org.springframework.web.multipart.MultipartFile;

import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;
import com.user.info.model.ImgurDeleteResponseVO;
import com.user.info.model.ImgurResponseVO;
import com.user.info.model.UserInfoVO;

public interface IUserService {

	public void createUser(UserDTO userDTO) throws UserException;
	public ImgurResponseVO uploadImage(MultipartFile file, String userName) throws UserException;
	public ImgurResponseVO viewImage(String id) throws  UserException;
	public ImgurDeleteResponseVO deleteImage(String id) throws UserException;
	public UserInfoVO viewInfo(String userName) throws UserException;
	
}
