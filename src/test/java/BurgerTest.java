import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient sauceIngredient;
    Burger burger = new Burger();
    List<Ingredient> ingredients = new ArrayList<>();

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(Constants.BUNS_CHOOSE, bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        ingredients.add(sauceIngredient);
        burger.addIngredient(sauceIngredient);
        Assert.assertEquals(Constants.INGREDIENT_CHOOSE,ingredients, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauceIngredient);
        burger.removeIngredient(0);
        Assert.assertEquals(Constants.INGREDIENT_CHOOSE_FOR_REMOVE,ingredients, burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.moveIngredient(0, 1);
        Assert.assertEquals(1,  burger.ingredients.indexOf(sauceIngredient));
    }

    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(15.5f);
        Mockito.when(sauceIngredient.getPrice()).thenReturn(10f);
        burger.addIngredient(sauceIngredient);
        burger.setBuns(bun);
        Assert.assertEquals(Constants.INCORRECT_BURGER_PRICE,41f, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(15.5F);
        Mockito.when(sauceIngredient.getPrice()).thenReturn(10f);
        Mockito.when(sauceIngredient.getName()).thenReturn("hot sauce");
        Mockito.when(sauceIngredient.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(sauceIngredient);
        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format(
                "= %s %s =%n",
                sauceIngredient.getType().toString().toLowerCase(),
                sauceIngredient.getName()));
        expected.append(String.format("(==== %s ====)%n", bun.getName()));
        expected.append(String.format("%nPrice: %f%n", burger.getPrice()));
        Assert.assertEquals(Constants.INCORRECT_BURGER_RECEIPT,expected.toString(),burger.getReceipt());
    }
}
