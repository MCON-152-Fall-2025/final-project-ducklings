package com.mcon152.recipeshare.service.export;
import com.mcon152.recipeshare.domain.Recipe;
import com.mcon152.recipeshare.domain.Tag;

import java.util.List;

public class MarkdownRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader(Recipe recipe) {
        // Header
        if (recipe.getTitle() != null && !recipe.getTitle().isEmpty()) {
            formattedRecipe.append("# ").append(recipe.getTitle()).append("\n");
        }

        // Description
        if (recipe.getDescription() != null && !recipe.getDescription().isEmpty()) {
            formattedRecipe.append("### ").append(recipe.getDescription()).append("\n");
        }
        //Servings
        if (recipe.getServings() != null)
            formattedRecipe.append("\n### Servings: ").append(recipe.getServings()).append("\n\n");
        //Author
        if (recipe.getAuthor() != null)
            formattedRecipe.append("\n### Author: ").append(recipe.getAuthor().getDisplayName()).append("\n");
        //Tags
        if (recipe.getTags() != null && !recipe.getTags().isEmpty()) {
            formattedRecipe.append("\n### Tags: ");
            for (Tag tag : recipe.getTags()) formattedRecipe.append(tag.getName()).append(" ");
            formattedRecipe.append("\n\n");
        }
    }

    @Override
    void formatIngredients(Recipe recipe) {
        // Ingredients
        formattedRecipe.append("## Ingredients\n");
        for (String ingredient : recipe.getIngredients().split(", "))
            formattedRecipe.append("- ").append(ingredient.replace(", ", "\n")).append("\n");
        formattedRecipe.append("\n");
    }

    @Override
    void formatInstructions(Recipe recipe) {
        // Instructions
        formattedRecipe.append("## Instructions\n");
        String instructions = recipe.getInstructions();
        if (instructions != null) {
           formattedRecipe.append(instructions.replace(" .\\.", "\n")).append("\n");

        } else {
            formattedRecipe.append("_No instructions provided._\n");
        }
    }
}