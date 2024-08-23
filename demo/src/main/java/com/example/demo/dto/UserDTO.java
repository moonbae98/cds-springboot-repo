package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {

	private int uIdx;			//회원번호(시퀀스를 이용)
	private String userName;	//회원이름
	private String userId;		//회원아이디(이메일을 이용)
	private String userPw;		//비밀번호
	private String birthday;	//생일(YYYYMMDD 형식의 8자리)
	private String phone;		//핸드폰번호(010다음의 -를 포함한 9자리)
	private Date regDate;		//가입일
	private Date updateDate;	//수정일
	private String userStatus;	//회원상태(N:탈퇴요청하지 않음, Y:탈퇴요청함)
	private int userGrade;		//회원등급(1:일반회원, 2:관리자, 3:슈퍼관리자-시스템운영자)
	
}
