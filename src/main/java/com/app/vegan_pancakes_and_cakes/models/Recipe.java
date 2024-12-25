package com.app.vegan_pancakes_and_cakes.models;

import jakarta.persistence.Lob;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String ingredients;
    @Lob
    private String preparationMethod;
    private String difficulty;

    public Recipe() {}

    public Recipe(String name, String description, String ingredients, String preparationMethod,
                  String difficulty){
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.preparationMethod = preparationMethod;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return String.format(
                "Recipe[name=%d, description='%s', ingridients='%s', difficulty='%s']",
                id, name, description, ingredients, difficulty);
    }

}