package com.user.info.imgurservice;

import org.springframework.web.multipart.MultipartFile;

import com.user.info.exception.UserException;
import com.user.info.model.ImgurDeleteResponseVO;
import com.user.info.model.ImgurResponseVO;

public interface IImgurService {

	public ImgurResponseVO uploadImage(MultipartFile file) throws UserException;
	public ImgurResponseVO viewImage(String id) throws UserException;
	public ImgurDeleteResponseVO deleteImage(String id) throws UserException;
	
}
