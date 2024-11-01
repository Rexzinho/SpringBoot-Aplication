package com.app.vegan_pancakes_and_cakes.repositories;

import com.app.vegan_pancakes_and_cakes.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}