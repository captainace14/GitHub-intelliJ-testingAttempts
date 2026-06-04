package unitTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    private List<String> cart;

    @BeforeEach
    public void init(){
        cart = new ArrayList<>();
        cart.add("Item1");
    }

    @Test
    public void testCartSize(){
        assertEquals(1, cart.size());
    }

    @AfterEach
    public void clean(){
        cart.clear();
    }
}
