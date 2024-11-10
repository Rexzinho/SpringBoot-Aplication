package com.app.vegan_pancakes_and_cakes.controllers;

import com.app.vegan_pancakes_and_cakes.models.Recipe;
import com.app.vegan_pancakes_and_cakes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("recipe/home");
        mv.addObject("recipesList", recipeRepository.findAll());
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("recipe/createRecipe");
        modelAndView.addObject("recipe", new Recipe());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createRecipe(@ModelAttribute("recipe") Recipe recipe) throws Exception {
        try{
            recipeRepository.save(recipe);
        }
        catch(Error error){
            System.out.println(STR."Algo deu errado. Erro: \{error.getMessage()}");
        }
        return new ModelAndView("/recipe/home");
    }
}
