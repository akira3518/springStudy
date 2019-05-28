package com.web.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces ="application/json;charset=utf-8")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	//void 리턴 타입
	@RequestMapping("/doA")
	public void doA() {
		logger.info("/doA called...");
	}
	
	//String 리턴 타입
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("/doC called");
		return "result";
	}
	
	//String 리턴 타입
	@RequestMapping("/doD")
	public String doD(Model model) {
		ProductVO product = new ProductVO("desktop", 10000);
		logger.info("/doD called");
		model.addAttribute(product);
		return "product_detail";
	}
	
	//doF를 리다이렉트
	@RequestMapping("/doE")
	public String doE(RedirectAttributes redirectAttributes) {
		logger.info("/doE called and redirect to /doF");
		redirectAttributes.addAttribute("msg","this is the message with redirected");
		
		return "redirect:/doF";
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute String msg) {
		logger.info("/doF called" + msg);
	}
	
	//json데이터를 생성하는 경우
	@RequestMapping("/doJson")
	@ResponseBody
	public ProductVO doJson() {
		ProductVO productVO = new ProductVO("laptop",300000);
		return productVO;
	}
}
