package com.kaka.base.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaka.base.dto.JsonResponse;

/**
 * 权限过滤
 *
 * @author lzx
 */
public class SecurityFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

	/**
	 * 排除不校验权限的URL
	 */
	private List<String> excludeUrlList = new ArrayList<String>();

	public void init(FilterConfig filterConfig) throws ServletException {
		String contextPath = filterConfig.getServletContext().getContextPath();
		String excludeUrl = filterConfig.getInitParameter("excludeUrl");
		String[] urls = excludeUrl.split(",");
		for (String url : urls) {
			excludeUrlList.add(contextPath + url);
		}
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpServletRequest request = (HttpServletRequest) req;

		logger.debug("RequestURI:" + request.getRequestURI());

		// 校验权限
		if (excludeUrlList.contains(request.getRequestURI())) {
			chain.doFilter(req, resp);
			return;
		}
		if (request.getSession().getAttribute("user") != null) {
			chain.doFilter(req, resp);
			return;
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		JsonResponse jsonResult = JsonResponse.failure(403, request.getContextPath());
		PrintWriter out = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(jsonResult);
			out = response.getWriter();
			out.print(jsonString);
		} catch (IOException e) {
			logger.error("JsonExceptionResolver throw exception:", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public void destroy() {

	}
}
