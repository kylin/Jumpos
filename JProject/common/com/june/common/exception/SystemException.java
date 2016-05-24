package com.june.common.exception;

public class SystemException extends Exception {
	private static final long serialVersionUID = 836631959466620624L;

	public SystemException() {
		super();
	}

	public SystemException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SystemException(String arg0) {
		super(arg0);
	}

	public SystemException(Throwable arg0) {
		super(arg0);
	}

}
