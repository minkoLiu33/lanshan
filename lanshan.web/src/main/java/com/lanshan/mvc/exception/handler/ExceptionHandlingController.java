package com.lanshan.mvc.exception.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Controller
@RequestMapping(value = "error")
public class ExceptionHandlingController {
	
	@RequestMapping(value = "404")
	public ModelAndView handel404(WebRequest reques){
		ModelAndView mav = new ModelAndView("error/404");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	@RequestMapping(value = "500")
	public ModelAndView handleException(Exception e, WebRequest request){
		ModelAndView mav = new ModelAndView("error/error");
		mav.addObject("ex", e);
		return mav;
	}
	
	@RequestMapping(value = "expire")
	public ModelAndView handelExpire(WebRequest request){
		ModelAndView mav = new ModelAndView("error/expire");
		return mav;
	}
}
