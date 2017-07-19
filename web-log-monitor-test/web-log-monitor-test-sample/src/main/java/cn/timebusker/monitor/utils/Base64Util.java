package cn.timebusker.monitor.utils;

import java.io.UnsupportedEncodingException;
import sun.misc.*;

@SuppressWarnings("restriction")
public class Base64Util {
	
	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public static String encoder(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/**
	 * 解密
	 * @param s
	 * @return
	 */
	public static String decoder(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "aaa";
		str = Base64Util.encoder(str);
		System.out.println(str);
		str = Base64Util.decoder(str);
		System.out.println(str);
	}
}
