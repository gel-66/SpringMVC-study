package com.gary.mvcdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Test2Interceptor implements HandlerInterceptor {

	/**
	 * 返回值表示是否要将当前的请求拦截
	 * false:请求将被终止
	 * true:请求继续运行
	 * Object handler 表示的是被拦截的请求的目标对象
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("run with preHandle2..........");
		return true;
	}

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("run with postHandle2..........");
		//可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法
		modelAndView.addObject("msg", "Intercepter-msg");
		modelAndView.setViewName("home");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("run with afterCompletion2..........");
	}

}
