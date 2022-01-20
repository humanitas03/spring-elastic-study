## Spring-elastic Study

* [] spring-elastic-practice-kotlin
* [] spring-elastic-reactive-practice
* [] spring-elastic-client-demo


# Reference
* https://github.com/deviantony/docker-elk


# Winsows 한정 추가 설정 부분
* Mysql Container까지 추가를 하니 로컬의 도커가 불안정하고 DB 접속이 원활하지 않은 문제 발생
* .wslconfig의 메모리 할당 설정을 6GB까지 올림.
* ES와 키바나 컨테이너 max heap을 512로 조정 
* ```wsl -l --running``` 으로 프로세스 확인 후 사용을 안하는 자원을 즉각즉각 정리해주자.