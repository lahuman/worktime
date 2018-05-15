# Work Timer Write(업무 시간 관리)

정부에서 주 52시간을 일하는 좋은 정책을 만들었다.

덕분에 회사에서는 안하던 출근 퇴근 시간을 관리 한다고 한다.

**웹으로 단순하게 출근 시간과 퇴근 시간을 저장하는 관리 기능**을 만들어 보자!


## 요구 사항
* 회원 등록/수정/삭제 기능 필요
* 회원별 출근/퇴근 시간 체크
  + 출근 퇴근은 간단하게 버튼을 눌러서 저장되며, 수정은 관리자만 가능하게 한다.
  + 비고(야근 사유)를 작성하도록 한다.
* 첫 페이지에서 회원별 주/월 별 근무 시간 표출
 
## 개발 환경
* JDK 1.8 이상
* Maven
* SpringBoot

## 실행
### 토큰 발행 
~~~
curl -XPOST http://testjwtclientid:XY7kmzoNzl100@localhost:8080/oauth/token?grant_type=password&username=john.doe&password=jwtpass
~~~
### 정보 요청
~~~
curl -XGET http://localhost:8080/worktime/users -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTI1NDUzMjQ5LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiJiMWIxNzY1NS05ODA1LTQ5NGUtYTc2OS0zMTA3Y2Q2OGZjMmQiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.W_7BrBBJjrUerduS5tIp6VNeBh4-ZbB9Qh8N5oqw050"

curl -XGET http://localhost:8080/worktime/work -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTI1NDUzMjQ5LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiJiMWIxNzY1NS05ODA1LTQ5NGUtYTc2OS0zMTA3Y2Q2OGZjMmQiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.W_7BrBBJjrUerduS5tIp6VNeBh4-ZbB9Qh8N5oqw050"

curl -XPOST http://localhost:8080/worktime/work -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTI1NDUzMjQ5LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiJiMWIxNzY1NS05ODA1LTQ5NGUtYTc2OS0zMTA3Y2Q2OGZjMmQiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.W_7BrBBJjrUerduS5tIp6VNeBh4-ZbB9Qh8N5oqw050"
~~~
## 추가 TIP
JDK 9 실행시 java parameter option을 줘야 한다
~~~
java  lahuman.worktime.WorktimeApplication --add-modules=java.xml.bind,java.activation
~~~

## 참고 자료
* [springboot-jwt](https://github.com/nydiarra/springboot-jwt)
* [How to resolve java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException in Java 9](https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception-in-j?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa)