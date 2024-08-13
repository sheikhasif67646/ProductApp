package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.product.model.Product;
import com.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
    private ProductService productService;

  

   /**
    * List all products.
    *
    * @param model
    * @return
    */
  @GetMapping("/")
   public String list(Model model) {
       model.addAttribute("products", productService.listAllProducts());
       System.out.println("Returning products:");
       return "products";
   }

   /**
    * View a specific product by its id.
    *
    * @param id
    * @param model
    * @return
    */
   @GetMapping("/{id}")
   public String showProduct(@PathVariable Integer id, Model model) {
       model.addAttribute("product", productService.getProductById(id));
       return "productshow";
   }

   // Afficher le formulaire de modification du Product
   @PutMapping("/edit/{id}")
   public String edit(@PathVariable Integer id, Model model) {
       model.addAttribute("product", productService.getProductById(id));
       return "productform";
   }

   /**
    * New product.
    *
    * @param model
    * @return
    */
   @RequestMapping("product/new")
   public String newProduct(Model model) {
       model.addAttribute("product", new Product());
       return "productform";
   }

   /**
    * Save product to database.
    *
    * @param product
    * @return
    */
   @RequestMapping(value = "product", method = RequestMethod.POST)
   public String saveProduct(Product product) {
       productService.saveProduct(product);
       return "redirect:/product/" + product.getId();
   }

   /**
    * Delete product by its id.
    *
    * @param id
    * @return
    */
   @DeleteMapping("/{id}")
   public String delete(@PathVariable Integer id) {
       productService.deleteProduct(id);
       return "redirect:/products";
   }

}
