package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.TodoDTO;

import lombok.RequiredArgsConstructor;

//DB와 관련해서 작업하는 클래스 : @Repository을 붙여서 구분하고 해당 클래스가 빈으로 등록되게 함
@Repository
@RequiredArgsConstructor //자동의존주입
public class TodoDAO {
	
	public static final String Mapper = "com.example.demo.mapper.TodoMapper";
	//MyBatis를 사용할 때 각각의 Mapper 내에 있는 SQL 구문을 Mapper의 네임스페이스와 SQL 구문의 id값으로 구분하므로 
	//각 Mapper 파일의 네임스페이스를 상수로 정의해서 SqlSession 메소드 호출 시 사용함
	
	private final SqlSession sqlSession;
	//MyBatis를 이용한 DB작업은 SqlSession 객체가 담당함
	
	

	//할 일 추가하기
	public int insert(TodoDTO dto) {
		return sqlSession.insert(Mapper+".insertTodo", dto);
	}

	//할일 목록 가져오기
	public List<TodoDTO> getTodoList() {
		return sqlSession.selectList(Mapper+".getTodoList");
	}

	//할일 1개 가져오기
	public TodoDTO getTodo(String id) {
		return sqlSession.selectOne(Mapper+".getTodo", id);
	}
	
	//할일 변경하기
	public int updateTodo(TodoDTO dto) {
		return sqlSession.update(Mapper+".updateTodo", dto);
	}

	//할일 삭제하기
	public int deleteTodo(String id) {
		return sqlSession.delete(Mapper+".deleteTodo", id);
	}
}
