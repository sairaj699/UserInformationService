package com.user.info.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;
import com.user.info.model.ImgurResponseVO;
import com.user.info.model.UserInfoVO;
import com.user.info.model.UserVO;
import com.user.info.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private UserDTO userDTO;

	// this method is used to save new user details into database.
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@Validated @RequestBody UserVO userVO) throws UserException {

		userDTO = new UserDTO();
		userVO.setPassWord(bCryptPasswordEncoder.encode(userVO.getPassWord()));
		userDTO.setUserVO(userVO);
		userService.createUser(userDTO);

	}

	// this method is used to interact with imgur API to upload image file
	@PostMapping(value = "/image/upload") // 
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ImgurResponseVO uploadImage(@RequestParam("file") MultipartFile file, Principal prinicipal)
			throws UserException {
		ImgurResponseVO imgurResponseVO = userService.uploadImage(file, prinicipal.getName());
		return imgurResponseVO;

	}

	// this method will interact with imgur Api and used to delete image for given Id
	@DeleteMapping("/image/delete/{id}")
	@ResponseStatus(HttpStatus.OK) 
	public void deleteimage(@PathVariable("id") String id) throws UserException {

		 userService.deleteImage(id);


	}

	// this method will interact with imgur Api and used to view image for given Id
	@GetMapping("/image/{id}")
	@ResponseStatus(HttpStatus.OK) 
	public ImgurResponseVO viewImage(@PathVariable("id") String id) throws UserException {

		ImgurResponseVO imgurViewResponseVO = userService.viewImage(id);

		return imgurViewResponseVO;
	}

	// this method will interact with h2 DataBase and used to fetch userBasic information
	@GetMapping("/{userName}/info")
	@ResponseStatus(HttpStatus.OK) 
	public UserInfoVO viewInfo(@PathVariable("userName") String userName) throws UserException {

		return userService.viewInfo(userName);

	}

}
