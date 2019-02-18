package com.yongbingxue.blog.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.yongbingxue.blog.jackson.views.Views;

@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

	@JsonView(Views.Public.class)
	@GetMapping(value = "runtime", produces = "application/json;charset=UTF-8")
	public String runTimeException() {
		throw new RuntimeException("test测试runtime");
	}

	@JsonView(Views.Public.class)
	@GetMapping(value = "argument", produces = "application/json;charset=UTF-8")
	public String illegalArgumentException() {
		throw new IllegalArgumentException("test测试argument");
	}
}
