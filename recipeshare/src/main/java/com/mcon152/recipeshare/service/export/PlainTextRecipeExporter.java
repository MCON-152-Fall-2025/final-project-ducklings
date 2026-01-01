package com.mcon152.recipeshare.service.export;
import com.mcon152.recipeshare.domain.Recipe;

public class PlainTextRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader(Recipe recipe) {

        formattedRecipe.append(recipe.getTitle()).append("\n");
        formattedRecipe.append(recipe.getDescription()).append("\n");
        if (recipe.getServings() != null) formattedRecipe.append(recipe.getServings()).append("\n");
        if (recipe.getAuthor() != null) formattedRecipe.append(recipe.getAuthor()).append("\n");
        if (recipe.getTags() != null) formattedRecipe.append(recipe.getTags()).append("\n");
    }

    @Override
    void formatIngredients(Recipe recipe) {
        formattedRecipe.append("\nIngredients:");
        for (String ingredient : recipe.getIngredients().split(", "))
            formattedRecipe.append("- ").append(ingredient).append("\n");
    }

    @Override
    void formatInstructions(Recipe recipe) {
        formattedRecipe.append("\nInstructions:");
        formattedRecipe.append(recipe.getInstructions()).append("\n");
    }
}