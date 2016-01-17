package com.kaka.base.mina;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

public class SessionMap {

	private static Map<String, IoSession> map = new HashMap<String, IoSession>();

	// 构造私有化 单例
	private SessionMap() {
	}

	public static void put(String key, IoSession session) {
		map.put(key, session);
	}

	public static IoSession get(String key) {
		return map.get(key);
	}

}
