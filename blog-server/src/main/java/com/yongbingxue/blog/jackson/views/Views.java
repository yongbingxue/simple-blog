package com.yongbingxue.blog.jackson.views;

public class Views {
	public static class Public {
	}

	public static class Protected extends Public {
	}

	public static class Restricted extends Protected {
	}

	public static class Internal extends Restricted {
	}

	public static class Admin extends Internal {
	}
}
