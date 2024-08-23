package com.example.demo.dto;

import lombok.Data;

@Data //lombok API를 통해서 getters and setters 메서드가 정의됨
public class TodoDTO {
	private String id;
	private String userid;
	private String title;
	private String done;
}
