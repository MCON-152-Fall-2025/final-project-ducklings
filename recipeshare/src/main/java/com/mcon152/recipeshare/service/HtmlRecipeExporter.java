package com.mcon152.recipeshare.service;

import com.mcon152.recipeshare.domain.Recipe;

public class HtmlRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
        @Override
        void formatHeader(Recipe recipe) {
            formattedRecipe.append("Recipe in HTML Format\n");
        }

        @Override
        void formatIngredients(Recipe recipe) {
            formattedRecipe.append("html \n");
        }

        @Override
        void formatInstructions(Recipe recipe) {
            formattedRecipe.append("The End");
        }
    }
