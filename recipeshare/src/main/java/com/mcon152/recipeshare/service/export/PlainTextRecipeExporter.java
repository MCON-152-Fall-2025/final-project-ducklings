package com.mcon152.recipeshare.service.export;
import com.mcon152.recipeshare.domain.Recipe;

public class PlainTextRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader(Recipe recipe) {
        formattedRecipe.append("Recipe in Plain Text Format\n");
    }

    @Override
    void formatIngredients(Recipe recipe) {
        formattedRecipe.append("Plain Text \n");
    }

    @Override
    void formatInstructions(Recipe recipe) {
        formattedRecipe.append("The End");
    }
}