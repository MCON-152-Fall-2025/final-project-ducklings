package com.mcon152.recipeshare.service.export;
import com.mcon152.recipeshare.domain.Recipe;
import java.util.List;

public class MarkdownRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader(Recipe recipe) {
        // Header
        if (recipe.getTitle() != null && !recipe.getTitle().isEmpty()) {
            formattedRecipe.append("# ").append(recipe.getTitle()).append("\n\n");
        }

        // Description
        if (recipe.getDescription() != null && !recipe.getDescription().isEmpty()) {
            formattedRecipe.append(recipe.getDescription()).append("\n\n");
        }

        // Tags (optional)
        if (recipe.getTags() != null && !recipe.getTags().isEmpty()) {
            formattedRecipe.append("\n## Tags\n\n");
            formattedRecipe.append(String.join(", ", recipe.getTags())).append("\n");
        }
    }

    @Override
    void formatIngredients(Recipe recipe) {
        // Ingredients
        formattedRecipe.append("## Ingredients\n\n");
        List<String> ingredients = recipe.getIngredients();
        if (ingredients != null && !ingredients.isEmpty()) {
            for (String ing : ingredients) {
                formattedRecipe.append("- ").append(ing).append("\n");
            }
        } else {
            formattedRecipe.append("_No ingredients provided._\n");
        }
        formattedRecipe.append("\n");
    }

    @Override
    void formatInstructions(Recipe recipe) {
        // Instructions
        formattedRecipe.append("## Instructions\n\n");
        List<String> instructions = recipe.getInstructions();
        if (instructions != null && !instructions.isEmpty()) {
            for (int i = 0; i < instructions.size(); i++) {
                formattedRecipe.append(i + 1).append(". ").append(instructions.get(i)).append("\n");
            }
        } else {
            formattedRecipe.append("_No instructions provided._\n");
        }
    }
}