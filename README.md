# dittodining-server-springboot
migration golang server to java springboot server

![image](https://github.com/user-attachments/assets/75cd40db-66f0-4144-9ddd-dce3c87a1e36)  

![image](https://github.com/user-attachments/assets/d63452bf-7aa8-47f0-ad74-9767f84a0947)


## MVC Pattern
`browser` < DTO > `controller(API)` < Model > `service`(Model 사용) <(DAO - Entity)> `repository` <-> `Database`

### DAO vs Model vs Entity
* DTO : 클라이언트의 데이터를 받는 역할, 클라이언트에서 사용하는 것으로 노출되도 상관 없는 것
* Model : 비즈니스 데이터를 담는 역할 (service 에서 사용)
* Entity : DB의 테이블과 스키마를 표현하는 역할, DB 컬럼과 연결되기 때문에 필드명 노출되면 안됨
