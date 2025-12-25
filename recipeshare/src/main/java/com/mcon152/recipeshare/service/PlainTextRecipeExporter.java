package com.mcon152.recipeshare.service;

import java.util.List;

public class PlainTextRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader() {
        System.out.println("Steeping the tea");
    }

    @Override
    void formatIngredients() {
        System.out.println("Adding sugar");
    }

    @Override
    void formatInstructions() {
        System.out.println("Stirring");
    }
}