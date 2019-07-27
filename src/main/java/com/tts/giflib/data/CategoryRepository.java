package com.tts.giflib.data;

import com.tts.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "silly"),
            new Category(2, "colorful"),
            new Category(3, "animated")
    );

    public List<Category> findAll() {
        return ALL_CATEGORIES;
    }
}
