package com.kaka.base.resolver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kaka.base.exception.BusinessException;

public class BaseHandlerExceptionResolver implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(BaseHandlerExceptionResolver.class);

	private String defaultErrorMessage;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		try (PrintWriter writer = response.getWriter()) {
			if (exception instanceof BusinessException) {
				writer.write(exception.getMessage());
				writer.flush();
				return new ModelAndView();
			} else {
				writer.write(defaultErrorMessage);
				writer.flush();
			}
		} catch (IOException e) {
			logger.error("", e);
		}
		return null;
	}

	public void setDefaultErrorMessage(String defaultErrorMessage) {
		this.defaultErrorMessage = defaultErrorMessage;
	}

}
