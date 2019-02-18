package com.yongbingxue.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yongbingxue.blog.exception.IllegalOperationException;
import com.yongbingxue.blog.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

	/**
	 * Convert a predefined exception to an HTTP Status code
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<String> exception(HttpServletRequest request, Throwable ex) {
		return new ResponseEntity<>("系统出现了一些小问题", HttpStatus.FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public ResponseEntity<String> userNotFoundException(HttpServletRequest request, Throwable ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
	}

	@ExceptionHandler(IllegalOperationException.class)
	@ResponseBody
	public ResponseEntity<String> illegalOperationException(HttpServletRequest request, Throwable ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ResponseEntity<String> illegalArgumentException(HttpServletRequest request, Throwable ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
	}
}
