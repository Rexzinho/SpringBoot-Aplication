package com.app.vegan_pancakes_and_cakes.controllers;

import com.app.vegan_pancakes_and_cakes.models.Recipe;
import com.app.vegan_pancakes_and_cakes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/creater")
    public Recipe createRecipe(@RequestBody Recipe recipe){
        try{
            recipeRepository.save(recipe);
        }
        catch(Error error){
            System.out.println(STR."Algo deu errado. Erro: \{error.getMessage()}");
        }
        return recipe;
    }
    @GetMapping("/a/{id}")
    public Optional<Recipe> getRecipe(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            ModelAndView mv = new ModelAndView("recipe/recipe");
            Optional<Recipe> recipe = recipeRepository.findById(id);
            return recipe;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao deletar receita.");
        }
        return Optional.of(new Recipe());
    }
}
