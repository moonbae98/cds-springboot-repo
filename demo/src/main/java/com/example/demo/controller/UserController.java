package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import oracle.as.management.opmn.integrator.StopCallback;

//REST API를 처리할 수 있는 컨트롤러로 명시함
@RestController
@RequiredArgsConstructor
public class UserController {

	// 요청에 대해서 실제적으로 처리하는 클래스 : UserServiceImpl 클래스
	// 상위의 인터페이스를 이용해서 필드로 정의함
	private final UserService userService;
	// 스프링 컨테이너로부터 의존 자동주입을 받기 위해서 클래스 위에 @RequiredArgsConstructor 어노테이션을 추가함

	// 회원정보 입력하기 : POST
	@PostMapping("/Signup")
	public Map<String, String> signup(@RequestBody UserDTO dto) {
		// @RequestBody : HTTP 요청 객체의 Body에 저장된 JSON 객체를 UserDTO 타입으로 변환시켜서 저장해줌
		//프론트 엔드로 전송되는 데이터의 형식이 Json형식으로 전달이 되어야하기 때문에
//		Map자료구조를 이용함. Map은 데이터를 저장할 때 키와 값의 쌍으로 저장하는 특징을가짐
//		Map자료구조를 객체로 만들어서 사용할 수 있도록 지원하는클래스:HashMap
		Map<String,String> result =new HashMap<String,String>(); 

		if (userService.signup(dto) == 1) {
			result.put("result","ok");
		}else {
			result.put("result","fail");
			
		}

		return result;
	}

	// 회원 목록 가져오기 : GET
	@GetMapping("/user/getUserList")
	public List<UserDTO> getUserList() {
		List<UserDTO> userList = null;

		userList = userService.getUserList();
		if (userList != null) {
			System.out.println("회원목록이 정상적으로 조회되었습니다.");
		} else {
			System.out.println("회원목록으로 조회된 내용이 없습니다.");
		}

		return userList;
	}

	@PutMapping("/user/updateUser")
	public Map<String, String> updateUser(@RequestBody UserDTO dto) {
		Map<String,String> result =new HashMap<String,String>();

		if (userService.updateUser(dto) == 1) {
			result.put("result", "OK");
		}else {
			result.put("result", "false");
		}

		return result;
	}
	//로그인
	@PostMapping("/user/login")
	public Map<String, String> login(@RequestBody UserDTO dto) {
		//프론트 엔드로 전송되는 데이터의 형식이 Json형식으로 전달이 되어야하기 때문에
//		Map자료구조를 이용함. Map은 데이터를 저장할 때 키와 값의 쌍으로 저장하는 특징을가짐
//		Map자료구조를 객체로 만들어서 사용할 수 있도록 지원하는클래스:HashMap
		Map<String,String> result =new HashMap<String,String>(); 

		UserDTO rexDto =userService.login(dto);
		
		if (rexDto != null) {
			result.put("result","ok");
			result.put("uIdx", String.valueOf(rexDto.getUIdx()));
			result.put("userId", rexDto.getUserId());
			
		}else {
			result.put("result","fail");
			
		}

		return result;
	}
	
	
	
	//회원번호(idx)로 가져오기
	@GetMapping("/user/{uIdx}/getUser")
	public UserDTO getUser(@PathVariable("uIdx") String uIdx) {
		UserDTO dto =userService.getUser(Integer.parseInt(uIdx));
		
		if(dto != null) {
			System.out.println("회원정보 조회 성공");
		}else {
			System.out.println("회원정보조회실패");
		}
		return dto;
	}
	
	@DeleteMapping("/user/{uIdx}/deleteUser")
	public Map<String, String> deleteUser(@PathVariable("uIdx") String uIdx) {
		Map<String,String> result =new HashMap<String,String>();

		if (userService.deleteUser(Integer.parseInt(uIdx)) == 1) {
			result.put("result", "OK");//회원탈퇴요청 처리 성공
		}else {
			result.put("result", "false");//회원탈퇴 요청 처리 실패
		}

		return result;
	}
}
