package com.yongbingxue.blog.exception;

public class UnsupportedImageTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3186691587368850091L;
	private String imageType;

	public UnsupportedImageTypeException(String message, String imageType) {
		super(message);
		this.imageType = imageType;
	}

	public String getMimeType() {
		return imageType;
	}

	@Override
	public String toString() {
		return super.toString() + ". ImageType=" + imageType;
	}
}
