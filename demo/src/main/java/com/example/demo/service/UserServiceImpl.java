package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;

import lombok.RequiredArgsConstructor;
import oracle.ucp.jdbc.DataSourceConnectionFactoryAdapter;

//클래스를 스프링의 빈으로 등록하기 : 서비스클래스 - @Service
//빈(bean) : 스프링 컨테이너에 등록 및 관리되는 자바 객체
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	//스프링 컨테이너에 의해서 의존 자동 주입이 이루어지도록 함(클래스 위에 @RequiredArgsConstructor 붙여줌)
	private final UserDAO dao;
	

	@Override
	public List<UserDTO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public int updateUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.updateUser(dto);
	}

	@Override
	public UserDTO login(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Override
	public UserDTO getUser(int uIdx) {
		// TODO Auto-generated method stub
		return dao.getUser(uIdx);
	}

	@Override
	public int deleteUser(int uIdx) {
		// TODO Auto-generated method stub
		return dao.deleteUser(uIdx);
	}

	@Override
	public int signup(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.signup(dto);
	}


}
