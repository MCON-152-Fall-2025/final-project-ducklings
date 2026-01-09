package com.mcon152.recipeshare.service.export;

import com.mcon152.recipeshare.domain.Recipe;

public abstract class AbstractRecipeExporter {
    //general exporting stuff

    /* Abstract class defining the template method */
    StringBuilder formattedRecipe = new StringBuilder();

    public final String export(Recipe recipe) {
        this.formatHeader(recipe);
        this.formatIngredients(recipe);
        this.formatInstructions(recipe);
        return formattedRecipe.toString();
    }

    // Abstract methods to be implemented by subclasses
    abstract void formatHeader(Recipe recipe);
    abstract void formatIngredients(Recipe recipe);
    abstract void formatInstructions(Recipe recipe);

}
