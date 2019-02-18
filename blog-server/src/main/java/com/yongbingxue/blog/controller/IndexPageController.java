package com.yongbingxue.blog.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class IndexPageController {
	private static final Logger logger = LogManager.getLogger(IndexPageController.class);

	@GetMapping(value = "/")
	public String index(@RequestHeader(name = "User-Agent", required = false) Optional<String> userAgent,
			HttpServletRequest request) {
		logger.info("userAgent:{}", userAgent);
		return "index";
	}

}
