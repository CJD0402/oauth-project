package com.jedong.oauthback.service;

import org.springframework.http.ResponseEntity;

import com.jedong.oauthback.dto.request.auth.SignUpRequestDto;
import com.jedong.oauthback.dto.response.auth.SignUpResponseDto;

public interface AuthService {

  ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
  
}
