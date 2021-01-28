# git pull을 잘못쓰다가. 깃이 꼬여버렸습니다. 
문제를 해결하지 못해서 새로운 Repository [를 생성했습니다.
# JSP 블로그 프로젝트 ( blog 만 해당됨 )

## 환경

- windows10
- jdk1.8
- tomcat9.0
- sts tool
- mysql8.0
- postman
- lombok
- gson (json파싱)
- 인코딩 utf-8
- git

## MySQL 데이터베이스 생성 및 사용자 생성

```sql
create user 'bloguser'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'bloguser'@'%';
create database blog;
```

## MySQL 테이블 생성

- bloguser 사용자로 접속
- use blog; 데이터 베이스 선택

```sql
CREATE TABLE user(
    id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100) not null,
    address varchar(100),
    userRole varchar(20),
    createDate timestamp
) engine=InnoDB default charset=utf8;

CREATE TABLE board(
    id int primary key auto_increment,
    userId int,
    title varchar(100) not null,
    content longtext,
    readCount int default 0,
    createDate timestamp,
    foreign key (userId) references user (id)
) engine=InnoDB default charset=utf8;

CREATE TABLE reply(
    id int primary key auto_increment,
    userId int,
    boardId int,
    content varchar(300) not null,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null,
    foreign key (boardId) references board (id) on delete cascade
) engine=InnoDB default charset=utf8;
```





# ExpressBus 프로젝트

## 남은 작업목록
index 페이지에서 지역 - 지역코드 매칭되게 하기
(대전복합 을누르면 NAEK010 이입력되도록)

result 페이지에서 xml데이터를 잘 가공해서 table로 보여주기

