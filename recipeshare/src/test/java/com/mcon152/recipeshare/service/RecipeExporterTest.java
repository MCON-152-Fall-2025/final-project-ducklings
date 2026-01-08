package com.mcon152.recipeshare.service;

import com.mcon152.recipeshare.domain.BasicRecipe;
import com.mcon152.recipeshare.service.export.HtmlRecipeExporter;
import com.mcon152.recipeshare.service.export.MarkdownRecipeExporter;
import com.mcon152.recipeshare.service.export.PlainTextRecipeExporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeExporterTest {

    private BasicRecipe newRecipe() {
        return new BasicRecipe(
                null,
                "Challah",
                "Great stuff",
                "3 1/8 cups warm water, 7/8 cups sugar, 2 tbsp yeast, 3 tbsp salt, 7/8 cup olive oil, 2 eggs, 9 cups flour",
                "1. Dissolve sugar in water 2. Stir in yeast and let floof 3. Mix in salt, oil, and eggs 4. Add in flour slowly, and start kneading when it gets thick 5. Knead a lot 6. Cover and let rise 7. Braid and let rise again 8. Bake at 350 until done",
                9
        );
    }

    @Test
    void exportMarkdownBasic() {
        BasicRecipe recipe = newRecipe();
        String exported = new MarkdownRecipeExporter().export(recipe);
        String expectedMd = """
                # Challah
                ### Great stuff
                
                ### Servings: 9
                
                ## Ingredients
                - 3 1/8 cups warm water
                - 7/8 cups sugar
                - 2 tbsp yeast
                - 3 tbsp salt
                - 7/8 cup olive oil
                - 2 eggs
                - 9 cups flour
                
                ## Instructions
                1. Dissolve sugar in water 2. Stir in yeast and let floof 3. Mix in salt, oil, and eggs 4. Add in flour slowly, and start kneading when it gets thick 5. Knead a lot 6. Cover and let rise 7. Braid and let rise again 8. Bake at 350 until done
                """;
        assertEquals(expectedMd, exported);
    }


    @Test
    void exportHtml() {
        BasicRecipe recipe = newRecipe();
        String exported = new HtmlRecipeExporter().export(recipe);
        String expectedHtml = """
                <div style="display: inline-block;
                        padding: 1em;
                        margin: 2em;
                        max-width: 40vw;
                        border: 4px ridge gold;
                        background-color: floralwhite;
                        color: saddlebrown; ">
                <h2>Challah</h2><h3>Great stuff</h3><h4>Servings: 9</h4><h5>Tags: </h5><h4>Ingredients: </h4><ul><li>3 1/8 cups warm water</li><li>7/8 cups sugar</li><li>2 tbsp yeast</li><li>3 tbsp salt</li><li>7/8 cup olive oil</li><li>2 eggs</li><li>9 cups flour</li></ul><h4>Instructions:</h4><p>1. Dissolve sugar in water 2. Stir in yeast and let floof 3. Mix in salt, oil, and eggs 4. Add in flour slowly, and start kneading when it gets thick 5. Knead a lot 6. Cover and let rise 7. Braid and let rise again 8. Bake at 350 until done</p></div>""";
        assertEquals(expectedHtml, exported);
    }

    @Test
    void exportPlaintext() {
        BasicRecipe recipe = newRecipe();
        String exported = new PlainTextRecipeExporter().export(recipe);
        String expectedTxt = """
                Challah
                Great stuff
                
                Servings: 9
                Tags:\s
                
                Ingredients:
                - 3 1/8 cups warm water
                - 7/8 cups sugar
                - 2 tbsp yeast
                - 3 tbsp salt
                - 7/8 cup olive oil
                - 2 eggs
                - 9 cups flour
                
                Instructions:
                1. Dissolve sugar in water 2. Stir in yeast and let floof 3. Mix in salt, oil, and eggs 4. Add in flour slowly, and start kneading when it gets thick 5. Knead a lot 6. Cover and let rise 7. Braid and let rise again 8. Bake at 350 until done
                """;
        assertEquals(expectedTxt, exported);
    }
}