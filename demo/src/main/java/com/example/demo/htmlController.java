package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class htmlController {
    @GetMapping("/")
    public ModelAndView renderAddPage() {
        ModelAndView modelAndView = new ModelAndView("add.html");
        return modelAndView;
    }

    @GetMapping("/searchPage")
    public ModelAndView renderSearchPage() {
        ModelAndView modelAndView = new ModelAndView("search");
        return modelAndView;
    }

    @GetMapping("/deletePage")
    public ModelAndView renderDeletePage() {
        ModelAndView modelAndView = new ModelAndView("delete");
        return modelAndView ;
    }

    @GetMapping("/updatePage")
    public ModelAndView renderUpdatePage() {
        ModelAndView modelAndView = new ModelAndView("update");
        return modelAndView ;
    }

    @GetMapping("/sortPage")
    public ModelAndView renderSortPage() {
        ModelAndView modelAndView = new ModelAndView("sort");
        return modelAndView ;
    }

}
