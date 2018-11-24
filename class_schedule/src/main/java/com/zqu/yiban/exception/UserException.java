package com.zqu.yiban.exception;

/**
 *	用户层面的异常
 */
public class UserException extends RuntimeException{
	public UserException(String msg) {
		super(msg);
	}
}
