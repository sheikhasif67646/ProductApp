package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.service.ProdService;



@Controller
public class ProdController {
	
	@Autowired
	ProdService productService;
	
	@RequestMapping("/read-product")
    public String showReadContactPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "readProduct";
    }

}
