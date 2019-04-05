package com.user.info.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.info.model.ErrorVO;
import com.user.info.util.ApplicationConstants;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorVO methodArgumentNotValidException() {
		ErrorVO errorVO = new ErrorVO();
		errorVO.setErrorMsg(ApplicationConstants.BAD_REQUEST_DESC);
		return errorVO;
	}

	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) 
	public void globalExceptionhandle() {

	}
	

}
