package com.mcon152.recipeshare.service;

class PlainTextRecipeExporter extends AbstractMethodError {
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
    void formatInstructionss() {
        System.out.println("Adding lemon");
    }
}