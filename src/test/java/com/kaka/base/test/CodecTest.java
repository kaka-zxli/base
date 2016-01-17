package com.kaka.base.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class CodecTest {

	public static void main(String[] args) {

		System.out.println(Hex.encodeHexString(new byte[] { 127 }));
		try {
			byte[] bytes = Hex.decodeHex("5a14a10000000100000000c00000000000002e0a".toCharArray());

			byte check = 0;

			for (int i = 0; i < 18; i++) {
				check ^= bytes[i];
			}
			System.out.println(check);
			System.out.println(Hex.encodeHex(new byte[] { check }));
		} catch (DecoderException e) {
			e.printStackTrace();
		}
	}

}
