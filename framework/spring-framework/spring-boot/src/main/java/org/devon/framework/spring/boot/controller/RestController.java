package org.devon.framework.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author devon.ye
 * @datetime 2020/1/5 11:12 上午
 * @since
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/hello")
	public String hello(){
		return "hello http2";
	}
}
