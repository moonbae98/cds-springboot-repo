package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;

import lombok.RequiredArgsConstructor;

//REST API에 대해서 처리해 줄 수 있는 컨트롤러
@RestController
@RequiredArgsConstructor
public class TodoController {
	//메소드 내에서 사용되는 클래스에 대한 개체 주입을 
	//생성자 방식을 이용해서 자동으로 주입받을 수 있도록 함
	//lombok API에서 @RequiredArgsConstructor 어노테이션을
	//클래스 위에 붙이고 필드에는 final을 붙여줌
	private final TodoService todoService;
	
	//이하 구문을 lombok의 @RequiredArgsConstructor 어노테이션을
	//사용함으로써 대체함
//	@Autowired //자동으로 의존주입을 받을 수 있는 방식: 생성자를 이용한 방식
//	public TodoController(TodoService todoService) {
//		this.todoService = todoService;
//	}
	
	//할일 1개를 todo 테이블에 추가하기
	@PostMapping("/todo/insert")
	public List<TodoDTO> insert(@RequestBody TodoDTO dto) {
	//@RequestBody: 사용자로부터 전달되는 데이터가 HTTP의 body부분에
	//포함되어졌을 경우 그것을 받는 객체임을 나타내줌	
		List<TodoDTO> todoList = null;//조회된 결과가 없을 때 결과값
		
		//사용자로부터 받은 데이터를 DB에 저장하려면
		//TodoServiceImpl 클래스를 이용해야 함
		//스프링으로부터 의존주입을 받아서 이용함
		//입력값이 정상적으로 DB에 입력이 되면 1을 반환하게 됨
		if(todoService.insert(dto) == 1) {//정상 입력되어진 경우
			todoList =  getTodoList();//할일 추가 성공 시 할일 목록 조회
		}
		
		return todoList;
	}
	
	//할일 목록 반환하기
	@GetMapping("/todo/getTodoList")
	public List<TodoDTO> getTodoList(){
		List<TodoDTO> todoList = null;//조회된 결과가 없을 때 결과값
		
		todoList = todoService.getTodoList();
		if(todoList != null) {
			System.out.println("정상적으로 조회되었습니다");
		}else {
			System.out.println("조회된 결과가 없습니다");
		}
		
		return todoList;
	}
	
	//할일 1개를 반환하기
	@GetMapping("/todo/{id2}/getTodo")
	//URL을 통해서 들어오는 값을 변수로 사용할 수 있도록 해주는 경로변수
	//{경로변수명}으로 정의함
	//요청을 처리하는 메소드의 매개변수로 저장할 때는 @PathVariable("경로변수명")을
	//사용함
	public TodoDTO getTodo(@PathVariable("id2") String id2) {
		TodoDTO dto = null; //조회된 데이터가 없을 때 결과값
		
		String id = "ff8080"+id2;
		dto = todoService.getTodo(id);
		
		if(dto != null) {
			System.out.println("정상적으로 조회되었습니다");
		}else {
			System.out.println("조회된 결과가 없습니다");
		}
		
		return dto;
	}
	
	//할일 변경하기
	@PutMapping("/todo/updateTodo")
	public List<TodoDTO> updateTodo(@RequestBody TodoDTO dto) {
		List<TodoDTO> todoList = null;//조회된 결과가 없을 때 결과값
		
		if(todoService.updateTodo(dto) == 1) {
			todoList =  getTodoList();//할일 변경 성공 시 할일 목록 조회
		}
		
		return todoList;
	}
	
	//완료된 할일 삭제하기
	@DeleteMapping("/todo/{id2}/deleteTodo")
	//URL을 통해서 들어오는 값을 변수로 사용할 수 있도록 해주는 경로변수
	//{경로변수명}으로 정의함
	//요청을 처리하는 메소드의 매개변수로 저장할 때는 @PathVariable("경로변수명")을
	//사용함
	public List<TodoDTO> deleteTodo(@PathVariable("id2") String id2) {
		List<TodoDTO> todoList = null;//조회된 결과가 없을 때 결과값
		
		String id = "ff8080"+id2;
		
		if(todoService.deleteTodo(id) == 1) {
			todoList =  getTodoList();//할일 삭제 성공 시 할일 목록 조회
		}
	
		return todoList;
	}
	
	

}