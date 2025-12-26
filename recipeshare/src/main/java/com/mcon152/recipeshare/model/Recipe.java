// src/main/java/com/mcon152/recipeshare/model/Recipe.java
package com.mcon152.recipeshare.model;

import java.util.List;

public record Recipe(
        String title,
        String description,
        List<String> ingredients,
        List<String> instructions,
        List<String> tags
) {}
