import org.junit.Test;

import static org.junit.Assert.assertArrayEquals; 
import static org.junit.Assert.assertTrue; 

enum Engine {

    ELECTRIC("Environmentally friendly"),
    STEAM("Old fashioned");

    String description;

    // Enum constructor must be private or package-private:
    /*public*/ Engine(String description) {
        this.description = description;
    }

}

public class EnumTest {
    
    @Test
    public void testValues() {
        Engine[] engines = Engine.values();
        assertArrayEquals(engines, 
                new Engine[]{Engine.ELECTRIC, Engine.STEAM});
    }

    @Test 
    public void testInstanceof() {
        // Enums implicitly extend java.lang.Enum:
        for (Engine e : Engine.values()) {
            assertTrue(e instanceof java.lang.Enum);
        }
    }

}

