package com.jedong.oauthback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jedong.oauthback.dto.request.auth.SignUpRequestDto;
import com.jedong.oauthback.dto.response.ResponseDto;
import com.jedong.oauthback.dto.response.auth.SignUpResponseDto;
import com.jedong.oauthback.entity.UserEntity;
import com.jedong.oauthback.repository.UserRepository;
import com.jedong.oauthback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplements implements AuthService {

  private final UserRepository userRepository;
  
  @Override
  public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

    String id = dto.getId();
    
    try {

      boolean hasId = userRepository.existsById(id);
      if (hasId) return SignUpResponseDto.existedId();

      UserEntity userEntity = new UserEntity(dto);
      userRepository.save(userEntity);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return SignUpResponseDto.success();
    
  }
  
}
