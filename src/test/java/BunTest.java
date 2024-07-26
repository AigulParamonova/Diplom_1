import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import org.junit.Assert;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBuns() {
        return new Object[][] {
                { "black bun", 100 },
                { "white bun", 200 },
                { "red bun", 300 },
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(Constants.INCORRECT_BUN_NAME, name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(Constants.INCORRECT_BUN_PRICE, price, bun.getPrice(), 0.0);
    }

}
