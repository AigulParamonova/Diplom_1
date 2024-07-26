import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class DatabaseTest {
    Database database = new Database();

    @Test
    public void availableBunsTest() {
        List<Bun> buns = database.availableBuns();
        Assert.assertEquals(Constants.BUNS_AVAILABLE, 3, buns.size());
    }

    @Test
    public void availableIngredientsTest() {
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertEquals(Constants.INGREDIENT_AVAILABLE, 6, ingredients.size());
    }
}
