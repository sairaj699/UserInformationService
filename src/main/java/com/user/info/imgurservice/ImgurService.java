package com.user.info.imgurservice;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.user.info.exception.UserException;
import com.user.info.model.ImgurDeleteResponseVO;
import com.user.info.model.ImgurResponseVO;

@Component
public class ImgurService implements IImgurService {
    
	@Autowired
	private RestTemplate restTemplate;

	@Value("${imgur.url}")
	private String imgUrl;

	@Value("${imgur.upload.url}")
	private String imgUploadUrl;

	@Value("${imgur.auth.token}") 
	private String token;

	@Override
	public ImgurResponseVO uploadImage(MultipartFile file) throws UserException {
		ImgurResponseVO imgurResponseVO = null;
		try { // add exception types in controllerAdvice
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			headers.add("Authorization", "Bearer " + token);
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			Base64.Encoder encoder = Base64.getEncoder();
			body.add("image", encoder.encode(file.getBytes()));
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
			imgurResponseVO = restTemplate.postForObject(imgUploadUrl, requestEntity, ImgurResponseVO.class);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}

		return imgurResponseVO;

	}

	@Override
	public ImgurResponseVO viewImage(String id) throws UserException { 

		ImgurResponseVO imgurViewResponseVO = null;
		ResponseEntity<ImgurResponseVO> response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + token);
			HttpEntity<String> entity = new HttpEntity<>(headers);
			response = restTemplate.exchange(imgUrl + id, HttpMethod.GET, entity, ImgurResponseVO.class);
			imgurViewResponseVO = response.getBody();
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		return imgurViewResponseVO;

	}

	@Override
	public ImgurDeleteResponseVO deleteImage(String id) throws UserException {
		ImgurDeleteResponseVO imgurDeleteResponseVO = null;

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + token);
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<ImgurDeleteResponseVO> response = restTemplate.exchange(imgUrl + id, HttpMethod.DELETE,
					entity, ImgurDeleteResponseVO.class);
			imgurDeleteResponseVO = response.getBody();
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		return imgurDeleteResponseVO;

	}

}
