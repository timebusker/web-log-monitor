package cn.timebusker.monitor.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 全角/半角相互转化
 */
public class StringFilterUtil {

	/**
	 * 半角转全角
	 * 
	 * @return 全角字符串.
	 */
	public static String ToSBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);
			}
		}
		return new String(c);
	}

	/**
	 * 全角转半角
	 * 
	 * @return 半角字符串
	 */
	public static String ToDBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);
			}
		}
		String returnString = new String(c);
		return returnString;
	}

	/**
	 * 去除 \n 回车  \t 水平制表符  \s 空格 \r 换行 
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
//			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Pattern p = Pattern.compile("\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
}
