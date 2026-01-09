package com.mcon152.recipeshare.service.export;
import com.mcon152.recipeshare.domain.Recipe;
import com.mcon152.recipeshare.domain.Tag;

public class PlainTextRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader(Recipe recipe) {
        formattedRecipe.append(recipe.getTitle()).append("\n");
        formattedRecipe.append(recipe.getDescription()).append("\n\n");
        if (recipe.getServings() != null)
            formattedRecipe.append("Servings: ").append(recipe.getServings()).append("\n");
        if (recipe.getAuthor() != null)
            formattedRecipe.append("Author: ").append(recipe.getAuthor().getDisplayName()).append("\n");
        if (recipe.getTags() != null && !recipe.getTags().isEmpty()) {
            formattedRecipe.append("Tags: ");
            for (Tag tag : recipe.getTags())
                formattedRecipe.append(tag.getName()).append(" ");
            formattedRecipe.append("\n");
        }
    }

    @Override
    void formatIngredients(Recipe recipe) {
        formattedRecipe.append("\nIngredients:\n");
        for (String ingredient : recipe.getIngredients().split(", "))
            formattedRecipe.append("- ").append(ingredient).append("\n");
    }

    @Override
    void formatInstructions(Recipe recipe) {
        formattedRecipe.append("\nInstructions:\n");
        formattedRecipe.append(recipe.getInstructions()).append("\n");
    }
}