## 스프링 부트, 멀티모듈 설정 스켈레톤 프로젝트

- module-api : API 어플리케이션
- module-batch : 배치 어플리케이션 
- module-core : 엔티티, 공통 설정, 공통 유틸 등

module-core는 추후 module-commons, module-model로 분리도 가능 (아니면 애초에 이렇게 구성해도 됨)
<br>
### kafka를 사용한다면 <br>
module-kafka / module-kafka-listener

### api를 외부 / 내부로 분리한다면 </br>
module-internal-api / module-external-api

### MSA 환경의 다른 마이크로서비스를 호출한다면<br>
module-client

