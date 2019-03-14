package com.his.exception;

/**
 * 处理公式错误
 * @author lsy
 *
 */
public class FormulaHandlerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormulaHandlerException() {
		super();
	}

	public FormulaHandlerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FormulaHandlerException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormulaHandlerException(String message) {
		super(message);
	}

	public FormulaHandlerException(Throwable cause) {
		super(cause);
	}

	
	
}
