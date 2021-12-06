package com.example.authorization.controller;

import com.example.authorization.model.Product;
import com.example.authorization.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    private final ProductService productService;

    public AppController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        List<Product> products = productService.listAll();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/new")
    public String newProduct (Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "form";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");

        Product product = productService.get(id);
        modelAndView.addObject("product", product);

        return modelAndView;
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

    @GetMapping("/login")
    public String login(Model model, String error){
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        return "login";
    }

}
