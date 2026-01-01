package com.mcon152.recipeshare.service.export;

import com.mcon152.recipeshare.domain.Recipe;

public class HtmlRecipeExporter extends AbstractRecipeExporter {

    // Implementing abstract methods
    @Override
    void formatHeader(Recipe recipe) {
        formattedRecipe.append("""
                <div style="display: inline-block;
                        padding: 1em;
                        margin: 2em;
                        max-width: 40vw;
                        border: 4px ridge gold;
                        background-color: floralwhite;
                        color: saddlebrown; ">
                """);
        formattedRecipe.append("<h2>").append(recipe.getTitle()).append("</h2>");
        formattedRecipe.append("<h3>").append(recipe.getDescription()).append("</h3>");
        if (recipe.getServings() != null) formattedRecipe.append("<h4>").append(recipe.getServings()).append("</h4>");
        if (recipe.getAuthor() != null) formattedRecipe.append("<h4>").append(recipe.getAuthor()).append("</h4>");
        if (recipe.getTags() != null) formattedRecipe.append("<h5>").append(recipe.getTags()).append("</h5>");
    }

    @Override
    void formatIngredients(Recipe recipe) {
        formattedRecipe.append("<h4>Ingredients: </h4>");
        formattedRecipe.append("<ul>");
        for (String ingredient : recipe.getIngredients().split(", "))
            formattedRecipe.append("<li>").append(ingredient).append("</li>");
        formattedRecipe.append("</ul>");
    }

    @Override
    void formatInstructions(Recipe recipe) {
        formattedRecipe.append("<h4>Instructions:</h4>");
        formattedRecipe.append("<p>").append(recipe.getInstructions()).append("</p>");
        formattedRecipe.append("</div>");
    }
}
