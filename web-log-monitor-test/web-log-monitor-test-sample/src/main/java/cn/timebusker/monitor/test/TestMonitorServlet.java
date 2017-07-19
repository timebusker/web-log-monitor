package cn.timebusker.monitor.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @topic 打印log日志
 * @description 此servlet用于测试，以便看到效果
 *
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/log/test" })
public class TestMonitorServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(TestMonitorServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 记录debug级别的信息
		log.debug("This is debug message. ");
		// 记录info级别的信息
		log.info("This is info message.");
		// 记录error级别的信息
		log.error("This is error message.");
		try {
			@SuppressWarnings("unused")
			int k = 1/0;
		} catch (Exception e) {
			log.info(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);

	}
	
}
