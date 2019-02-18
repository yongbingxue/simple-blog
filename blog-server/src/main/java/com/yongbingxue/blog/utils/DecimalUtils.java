package com.yongbingxue.blog.utils;

import java.text.DecimalFormat;

public class DecimalUtils {

	public static String formatPrice(int price) {
		if (price == 0) {
			return "0";
		}
		int remainder = price % 100;
		if (remainder == 0) {
			int intValue = price / 100;
			return String.valueOf(intValue);
		}
		double doubleValue = price / 100.00;
		DecimalFormat df = new DecimalFormat("0.0#");
		return df.format(doubleValue);
	}

	public static String formatCredit(int credit) {
		if (credit == 0) {
			return "0";
		}
		int remainder = credit % 100;
		if (remainder == 0) {
			int intValue = credit / 100;
			return String.valueOf(intValue);
		}
		double doubleValue = credit / 100.00;
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(doubleValue);
	}

	public static String formatPopularity(int popularity) {
		if (popularity == 0) {
			return "0";
		}
		int remainder = popularity % 100;
		if (remainder == 0) {
			int intValue = popularity / 100;
			return String.valueOf(intValue);
		}
		double doubleValue = popularity / 100.00;
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(doubleValue);
	}

	public static String formatRating(int rating) {
		if (rating == 0) {
			return "0";
		}
		int remainder = rating % 100;
		if (remainder == 0) {
			int intValue = rating / 100;
			return String.valueOf(intValue);
		}
		double doubleValue = rating / 100.00;
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(doubleValue);
	}
}
