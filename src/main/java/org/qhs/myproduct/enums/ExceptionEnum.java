package org.qhs.myproduct.enums;

public enum ExceptionEnum {


	NO_DATA_EXCTPTION(204,"数据为空"),
	SUCCEE(200,"成功"),
	BAD_REQUEST(400,"请求参数有误"),
	UNAUTHORIZED(401,"未授权"),
	FORBIDDEN(403,"拒绝访问"),
	NO_FOUND(404,"访问资源未找到");


	public int type;
	public String label;

	ExceptionEnum(int type, String label){
		this.type=type;
		this.label=label;
	}
}
