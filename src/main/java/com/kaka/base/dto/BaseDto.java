package com.kaka.base.dto;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseDto implements Serializable {

	private static final long serialVersionUID = 7380591515138482674L;

	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(this.getClass().getName());
		strBuf.append("{");

		Field[] fields = this.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field fd = fields[i];

			String stringLetter = fd.getName().substring(0, 1).toUpperCase();
			String getName = "get" + stringLetter + fd.getName().substring(1);
			Class<? extends BaseDto> classType = this.getClass();
			try {
				// 获取相应的方法
				Method getMethod = classType.getMethod(getName, new Class[] {});
				// 调用源对象的getXXX（）方法
				Object value = getMethod.invoke(this, new Object[] {});

				strBuf.append(fd.getName() + ":");
				strBuf.append(value);
			} catch (Exception e) {
				continue;
			}
			if (i != fields.length - 1)
				strBuf.append(", ");
		}

		strBuf.append("}");
		return strBuf.toString();
	}
}
