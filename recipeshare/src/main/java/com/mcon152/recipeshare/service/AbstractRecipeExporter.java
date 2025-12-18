package com.mcon152.recipeshare.service;

import com.mcon152.recipeshare.domain.Recipe;
import org.springframework.http.ResponseEntity;

public abstract class AbstractRecipeExporter {
    //general exporting stuff

    /* Abstract class defining the template method */

    public final void export(Recipe recipe) {
        this.formatHeader();
        this.formatIngredients();
        this.formatInstructions();
    }

    // Abstract methods to be implemented by subclasses
    abstract void formatHeader();
    abstract void formatIngredients();
    abstract void formatInstructions();

    // Common methods
    /*void boilWater() {
        System.out.println("Boiling water");
    }*/
}
