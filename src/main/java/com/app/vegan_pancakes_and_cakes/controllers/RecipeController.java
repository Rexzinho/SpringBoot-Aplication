package com.app.vegan_pancakes_and_cakes.controllers;

import com.app.vegan_pancakes_and_cakes.models.Recipe;
import com.app.vegan_pancakes_and_cakes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return new ModelAndView("redirect:/recipe/list");
    }

    @PostMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            recipeRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Receita deletada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao deletar receita.");
        }
        return "redirect:/recipe/list"; // Redireciona para a página de listagem ou outra que desejar
    }

    @GetMapping("/{id}")
    public ModelAndView getRecipe(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            ModelAndView mv = new ModelAndView("recipe/recipe");
            Recipe recipe = recipeRepository.findById(id).orElse(null);
            mv.addObject("recipe", recipe);
            return mv;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao deletar receita.");
        }
        return new ModelAndView("recipe/recipe");
    }
}
