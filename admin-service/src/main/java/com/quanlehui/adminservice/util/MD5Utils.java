package com.quanlehui.adminservice.util;

import java.security.MessageDigest;

/**
 * 
 * @author SunXiaoYong.Inc
 *
 */
public class MD5Utils {
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static final String encode(String str) {
		return encode(str, null);
	}
	
	/**
	 * 
	 * @param str
	 * @param charset
	 * @return
	 */
	public static final String encode(String str, String charset) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			if(null != charset) {
				return byteArrayToHexString(md.digest(str.getBytes(charset)));
			} else {
				return byteArrayToHexString(md.digest(str.getBytes()));
			}
		} catch (Exception x) {
			throw new RuntimeException(x);
		}
	}
}