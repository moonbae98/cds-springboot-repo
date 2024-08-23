package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TodoDAO;
import com.example.demo.dto.TodoDTO;

import lombok.RequiredArgsConstructor;

//서비스 클래스임을 나타내고 스프링 컨테이너에 빈으로 등록되게 함
@Service
@RequiredArgsConstructor //TodoDAO 클래스도 생성자에 의한 의존 자동주입이 이루어지도록 처리함
public class TodoServiceImpl implements TodoService {

	private final TodoDAO dao;
	
	@Override
	public int insert(TodoDTO dto) {
		//DB와 관련된 작업을 할 수 있는 DAO 클래스가 필요함 : TodoDAO 클래스 정의
		return dao.insert(dto);
	}

	@Override
	public List<TodoDTO> getTodoList() {
		//할일 목록 가져오기
		return dao.getTodoList();
	}

	@Override
	public TodoDTO getTodo(String id) {
		return dao.getTodo(id);
	}

	@Override
	public int updateTodo(TodoDTO dto) {
		return dao.updateTodo(dto);
	}

	@Override
	public int deleteTodo(String id) {
		return dao.deleteTodo(id);
	}
	
}
