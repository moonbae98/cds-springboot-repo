package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TodoDTO;

public interface TodoService {

	int insert(TodoDTO dto);

	List<TodoDTO> getTodoList();

	TodoDTO getTodo(String id);

	int updateTodo(TodoDTO dto);

	int deleteTodo(String id);
	
}
