package com.kaka.base.dto;

public class JsonResponse extends BaseDto {

	private static final long serialVersionUID = -3195398166716013450L;

	private final static int SUCCESS = 0;

	private int code;

	private String msg;

	private Object data;

	public static JsonResponse success(Object data) {
		return new JsonResponse(SUCCESS, null, data);
	}

	public static JsonResponse success() {
		return success("");
	}

	public static JsonResponse failure(int code, String msg) {
		return new JsonResponse(code, msg, null);
	}

	public JsonResponse(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
