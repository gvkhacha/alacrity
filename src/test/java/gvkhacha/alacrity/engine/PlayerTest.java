package gvkhacha.alacrity.engine;

import org.junit.Assert;
import org.junit.Test;


public class PlayerTest {
    private static final double DELTA = 1e-15;
    @Test
    public void defaultConstructor(){
        Player p = new Player();

        Assert.assertEquals("Unnamed", p.getName());
        Assert.assertEquals(0.0, p.getScore(), DELTA);
    }

    @Test
    public void createPlayerWithName(){
        Player p1 = new Player("");
        Player p2 = new Player("Hello");

        Assert.assertEquals("", p1.getName());
        Assert.assertEquals("Hello", p2.getName());
    }
}
