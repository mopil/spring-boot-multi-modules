## 스프링 부트 멀티 모듈 템플릿
새로운 프로젝트를 생성할 때 참고하는 템플릿 레포

- module-api : API 어플리케이션
- module-batch : 배치 어플리케이션 
- module-core : 모델, 공통 설정, 공통 유틸 등

`application-secret.properties`는 module-core > resources에 `application-db.properties`와 함께 위치시키고, 해당 파일에는
github에 올라가면 안 되는 비밀정보 (ex. secret key)를 담아둔다.
