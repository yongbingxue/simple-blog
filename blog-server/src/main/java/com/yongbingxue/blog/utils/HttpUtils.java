package com.yongbingxue.blog.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpUtils {
	private static final Logger logger = LogManager.getLogger(HttpUtils.class);

	public static String getWechatFullURL(HttpServletRequest request) {
		String url = "https://" + request.getServerName() + request.getRequestURI() + getQueryString(request);
		logger.info("getWechatFullURL-url:{}", url);
		return url;
	}

	public static String getWechatServerURL(HttpServletRequest request) {
		String url = "https://" + request.getServerName();
		logger.info("getWechatServerURL-url:{}", url);
		return url;
	}

	public static String getFullURL(HttpServletRequest request) {
		String url = request.getScheme() + "://" + request.getServerName() + getPortString(request)
				+ request.getRequestURI() + getQueryString(request);
		logger.debug("getFullURL-url:{}", url);
		return url;
	}

	private static String getPortString(HttpServletRequest request) {
		if ("http".equals(request.getScheme()) && request.getServerPort() == 80) {
			return "";
		}
		if ("https".equals(request.getScheme()) && request.getServerPort() == 443) {
			return "";
		}

		return ":" + request.getServerPort();
	}

	private static String getQueryString(HttpServletRequest request) {
		if (request.getQueryString() == null) {
			return "";
		}

		String queryString = "?" + request.getQueryString();

		return queryString;
	}

}
