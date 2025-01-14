# dittodining-server-springboot
migration golang server to java springboot server


## server side rendering case
`browser` <-> `controller` <-> `service` <-> `entity`(DAO) <-> `Database`

## api case
`browser` <-> `api` <-> `service` <-> `entity` (DAO) <-> `Database`

### DAO vs Model vs Entity
* DTO : 클라이언트의 데이터를 받는 역할, 클라이언트에서 사용하는 것으로 노출되도 상관 없는 것
* Model : 비즈니스 데이터를 담는 역할 (service 에서 사용)
* Entity : DB의 테이블과 스키마를 표현하는 역할, DB 컬럼과 연결되기 때문에 필드명 노출되면 안됨