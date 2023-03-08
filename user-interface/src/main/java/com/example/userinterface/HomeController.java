package com.example.userinterface;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 *
 */
// @RestController
@Controller
public class HomeController {
	/**
	 * homeのindex
	 */
    @GetMapping("/")
    public String index() {
        return "index";
    }

	/**
	 * login
	 */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}