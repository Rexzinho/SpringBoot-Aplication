package com.app.vegan_pancakes_and_cakes.controllers;

import com.app.vegan_pancakes_and_cakes.models.Recipe;
import com.app.vegan_pancakes_and_cakes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;
    @GetMapping("/list")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("recipesList", recipeRepository.findAll());
        return mv;
    }
}
