package com.yongbingxue.blog.exception;

public class UnsupportedMimeTypeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4288780371591253581L;

	private String mimeType;

	public UnsupportedMimeTypeException(String message, String mimeType) {
		super(message);
		this.mimeType = mimeType;
	}

	public String getMimeType() {
		return mimeType;
	}

	@Override
	public String toString() {
		return super.toString() + ". Mimetype=" + mimeType;
	}
}
