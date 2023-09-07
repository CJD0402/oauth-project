# OAuth 작업 순서 (Back-End)
1. Spring Security / Oauth2-client 의존성 주입

2. oAtuh 제공자(github, kakao, naver, ...)에서 oauth application 등록
	=> client id, client secret key 제공받음

3. spring에서 application 설정 (application.properties, application.{yaml, yml})
	=> spring.security.oauth2.client.registration.{provider}.clientId / clientSecret / redirectUri / scope
	=> spring.provider.{provider}.authorizatin-uri / token-uri / user-info-uri

4. WebSecurityConfig에 .oauth2Login() 추가
  => http://localhost:{port}/oauth2/authorization/{provider} 요청으로 확인
  => oauth 인증 경로 변경 할 때 redirectionEndpoint().baseUri("?") 뒤에 추가
    -> .and.authorizationEndpoint().baseUri("{변경할 url 패턴}").and()
    -> .antMatchers() 내부에 경로 수정
    -> domain/변경한 url 패턴/{provider} 로 oauth 인증 시작

5. WebSecurityConfig에 .redirectionEndpoint().baseUri("?") [? = oauth application 등록시 사용했던 redirection url 패턴]

6. ApplicationOAuth2User Class 작성

7. OAuth2UserServiceImplement 작성

8. OAuthSuccessHandler 작성

9. WebSecurityConfig에 .and().userInfoEndpoint().userService(OAuth2UserServiceImplement 객체) 추가

10. WebSecurityConfig 에 .and().successHandler(OAuthSuccessHandler 객체) 추가

# OAuth-Front
### 설치
npm i react-router-dom axios react-cookie
