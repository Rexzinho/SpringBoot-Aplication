package com.app.vegan_pancakes_and_cakes.controllers;

import com.app.vegan_pancakes_and_cakes.models.Recipe;
import com.app.vegan_pancakes_and_cakes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeControllerRest {
    @Autowired
    private RecipeRepository recipeRepository;
    @PostMapping
    public List<Recipe> test(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("recipesList", recipeRepository.findAll());
        return recipeRepository.findAll();
    }
}
