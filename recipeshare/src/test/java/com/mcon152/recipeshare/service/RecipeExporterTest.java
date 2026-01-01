package com.mcon152.recipeshare.service;

import com.mcon152.recipeshare.domain.BasicRecipe;
import com.mcon152.recipeshare.model.Recipe;
import com.mcon152.recipeshare.service.export.MarkdownRecipeExporter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RecipeExporterTest {
    private BasicRecipe newBasicRecipe() {
        return new BasicRecipe(
                null,
                "Chocolate Cake",
                "Moist chocolate cake",
                "flour, eggs, cocoa",
                "mix, bake",
                8
        );
    }

    private Recipe newFullRecipe() {
        return new Recipe (
                "Challah",
                "Great stuff",
                Arrays.asList("3 1/8 cups warm water", "7/8 cups sugar", "2 tbsp yeast", "3 tbsp salt", "7/8 cup olive oil", "2 eggs", "9 cups flour"),
                Arrays.asList("Dissolve sugar in water", "Stir in yeast and let floof", "Mix in salt, oil, and eggs", "Add in flour slowly, and start kneading when it gets thick", "Knead a lot", "Cover and let rise", "Braid and let rise again", "Bake at 350 until done"),
                Arrays.asList("Bread", "Shabbos", "Yum")
        );
    }


    @BeforeAll
    static void setup() {

    }

    @Test
    void exportMarkdownBasic() {
        BasicRecipe recipe = newBasicRecipe();
        String exported = new MarkdownRecipeExporter().export(recipe);
        assertEquals("Markdown", exported);
    }

    @Test
    void exportHtml() {

    }

    @Test
    void exportPlaintext() {

    }
}