package org.qhs.myproduct.exception;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 自定义异常类
 * @date 2018/11/17
 */
public class ServiceException extends Exception{
	private static final long serialVersionUID = -3696131446703236504L;

	public ServiceException (String msg	 ,Throwable cause){
		super(msg,cause);
	}

	public ServiceException(int type, String msg){
		super(msg);
	}
}
