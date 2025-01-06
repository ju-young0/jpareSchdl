# 🗒️ 프로젝트 소개
이 프로젝트는 스프링 부트와 JPA를 활용하여 일정 관리 및 사용자 인증 기능을 구현하는 애플리케이션입니다.
주요 기능은 일정 CRUD, 사용자 CRUD, 회원가입, 로그인(인증)입니다.
</br>

## 🏷️ API 명세서
### 1. 유저 , 인증 api
| 구분 | Method | URL | 상태코드 |
|---|---|---|---|
| 회원가입 | `POST` | /users/signup | 200 |
| 로그인 | `POST` | /users/login | 200 |
| 로그아웃 | `POST` | /users/logout | 200 |
| 유저 조회 | `GET` | /users/`{id}` | 200 |
| 유저 수정 | `PATCH` | /users/`{id}` | 200 |
| 유저 삭제 | `DELETE` | /users/`{id}` | 200 |

### 2. 일정 api
| 구분 | Method | URL | 상태코드 |
|---|---|---|---|
| 일정 등록 | `POST` | /schedules | 200 |
| 특정 일정 조회 | `GET` | /schedules/`{id}` | 200 |
| 전체 일정 조회 | `GET` | /schedules/ | 200 |
| 일정 수정 | `PATCH` | /schedules/`{id}` | 200 |
| 일정 삭제 | `DELETE` | /schedules/`{id}` | 200 |

</br>

## ⛔️ ErrorCode
| 구분 | 코드 | 설명 |
|---|---|---|
| 회원 | `ACCOUNT-001` | 사용자가 없는 경우 |


</br>

## 요청 본문 및 응답 상세
### 1. 회원가입 POST
```
{
    "username" : "홍길동",
    "email" : "aaa@ko.com",
    "password" : "1234"
}
```
```
{
    "id": 1,
    "username": "홍길동",
    "email": "aaa@ko.com",
    "createdAt": "2024-12-18T17:49:52.478274",
    "updatedAt": "2024-12-18T17:49:52.478274"
}
```
### 2. 로그인 POST
```
{
    "email" : "aaa@ko.com",
    "password" : "1234"
}
```
```
정상적으로 로그인되었습니다.
```
### 3. 일정 등록 POST
```
{
    "name" : "홍길동",
    "contents" : "내용"
}
```
```
{
    "id": 1,
    "userId": 2,
    "title": "제목",
    "contents": "내용",
    "createdAt": "2024-12-18T17:37:19.184441",
    "updatedAt": "2024-12-18T17:37:19.184441"
}
```
### 4. 일정 수정 PATCH
```
{
    "title" : "수정된 제목",
    "contents" : "수정된 내용",
    "username" : "홍남식"
}
```
```
{
    "id": 9,
    "name": "수정된 홍길동2",
    "contents": "수정된 내용2",
    "createdAt": "2024-12-09T19:13:23",
    "updatedAt": "2024-12-09T19:17:57"
}
```
### 5. 유저 수정 PATCH
```
{
    "email" : "aaa1@ko.com",
    "password" : "222"
}
```
```
{
    "id": 1,
    "username": "홍길동",
    "email": "aaa1@ko.com",
    "createdAt": "2024-12-18T20:25:53.880293",
    "updatedAt": "2024-12-18T20:25:53.880293"
}
```
</br>

## 오류 응답 코드
- 404 : 요청한 리소스를 찾을 수 없습니다.
- 405 : get메소드를 불러올 수 없습니다.
- 500 : 서버오류

</br>

## 🧲 ERD
![스크린샷 2024-12-18 20 03 13](https://github.com/user-attachments/assets/681a0039-ea44-49d3-bbb2-8f7866fbda9a)

</br>



