package cn.timebusker.monitor.core;

import java.io.Writer;

import org.apache.log4j.Layout;
import org.apache.log4j.WriterAppender;

/**
 * @topic log4j日志输出
 * @description TODO
 *
 */
public class Log4jAppender extends WriterAppender {

	private Writer writer = new Log4jAsyncWriter();

	public Log4jAppender() {
		setWriter(writer);
	}
	
	public Log4jAppender(Layout layout) {
		this();
		super.layout = layout;
	}

}
