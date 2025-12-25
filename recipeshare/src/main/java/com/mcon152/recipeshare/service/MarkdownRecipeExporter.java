package com.mcon152.recipeshare.service;

public class MarkdownRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader() {
        System.out.println("Steeping the tea");
    }

    @Override
    void formatIngredients() {
        System.out.println("Adding lemon");
    }

    @Override
    void formatInstructions() {
        System.out.println("Stirring");
    }
}