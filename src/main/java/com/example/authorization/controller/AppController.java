package com.example.authorization.controller;

import com.example.authorization.model.Product;
import com.example.authorization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String homePage(Model model){
        List<Product> products = productService.listAll();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/new")
    public String newProduct (Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new";
    }

    @RequestMapping("/edit/{id}")
    public String editProduct (Model model, @PathVariable(name = "id") Long id){
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);

        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);

        return "redirect:/";
    }
}
