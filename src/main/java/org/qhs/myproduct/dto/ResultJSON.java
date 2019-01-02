package org.qhs.myproduct.dto;

import org.qhs.myproduct.enums.ExceptionEnum;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 返回类
 * @date 2018/11/17
 */
public class ResultJSON {
	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 数据
	 */
	private Object data;

	/**
	 * 返回的消息
	 */
	private String msg;

	public ResultJSON() {
	}

	public ResultJSON(Integer code, Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public ResultJSON(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultJSON(String msg,Object data) {
		this.data = data;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultJSON success(String msg,Object data){
		return new ResultJSON(ExceptionEnum.SUCCEE.type,data,msg);
	}

	public ResultJSON success(String msg){
		return new ResultJSON(ExceptionEnum.SUCCEE.type,msg);
	}

	public ResultJSON failure(Integer code,String msg){
		return new ResultJSON(code,msg);
	}
}
