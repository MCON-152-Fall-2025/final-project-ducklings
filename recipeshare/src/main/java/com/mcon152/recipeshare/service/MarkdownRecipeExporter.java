package com.mcon152.recipeshare.service;

import com.mcon152.recipeshare.model.Recipe;

import java.util.List;

public class MarkdownRecipeExporter extends AbstractRecipeExporter {


    private final StringBuilder sb = new StringBuilder();

    public String export(Recipe recipe) {
        sb.setLength(0);

        // Header
        if (recipe.title() != null && !recipe.title().isEmpty()) {
            sb.append("# ").append(recipe.title()).append("\n\n");
        }

        // Description
        if (recipe.description() != null && !recipe.description().isEmpty()) {
            sb.append(recipe.description()).append("\n\n");
        }


        // Ingredients
        sb.append("## Ingredients\n\n");
        List<String> ingredients = recipe.ingredients();
        if (ingredients != null && !ingredients.isEmpty()) {
            for (String ing : ingredients) {
                sb.append("- ").append(ing).append("\n");
            }
        } else {
            sb.append("_No ingredients provided._\n");
        }
        sb.append("\n");

        // Instructions
        sb.append("## Instructions\n\n");
        List<String> instructions = recipe.instructions();
        if (instructions != null && !instructions.isEmpty()) {
            for (int i = 0; i < instructions.size(); i++) {
                sb.append(i + 1).append(". ").append(instructions.get(i)).append("\n");
            }
        } else {
            sb.append("_No instructions provided._\n");
        }

        // Tags (optional)
        if (recipe.tags() != null && !recipe.tags().isEmpty()) {
            sb.append("\n## Tags\n\n");
            sb.append(String.join(", ", recipe.tags())).append("\n");
        }

        return sb.toString();

    }
    // Implementing abstract methods
    @Override
    void formatHeader() {
        System.out.println("Steeping the tea"); }

    @Override
    void formatIngredients() {
        System.out.println("Adding lemon");
    }

    @Override
    void formatInstructions() {
        System.out.println("Stirring");
    }
}