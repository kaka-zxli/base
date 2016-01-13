package com.kaka.base.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class CodecTest {

	public static void main(String[] args) {

		System.out.println(Hex.encodeHexString(new byte[] { 127 }));
		try {
			byte[] bytes = Hex.decodeHex("5A141F".toCharArray());
			for(byte b : bytes){
				System.out.println(b);
			}
		} catch (DecoderException e) {
			e.printStackTrace();
		}
	}

}
