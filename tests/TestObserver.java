import org.junit.Before;
import org.junit.Test;
import pokemonTCG.Driver;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.Trainer;
import pokemonTCG.abilities.attacks.GrassAttack;
import pokemonTCG.types.Grass;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestObserver {

    private Trainer red;
    private Trainer green;
    private Driver driver;
    private Grass grass = new Grass();
    private ArrayList<IAbility> grassAbilities = new ArrayList<>();

    @Before
    public void setUp(){
        red = new Trainer();
        ArrayList<IAbility> grassAbilities = new ArrayList<>();

        HashMap<String, Integer> grassCost = new HashMap<>();
        GrassAttack grassAttack = new GrassAttack("Grass", "Performs a Grass-type attack", grassCost, 6);
        grassCost.put("Grass", 1);
        grassAbilities.add(grassAttack);

        red.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        red.newP1Pokemon(grass, 2, "Ivysaur", 100, grassAbilities, 1);
        red.newP2Pokemon(grass, 3, "Venusaur", 100, grassAbilities, 2);
        red.newEnergy(grass);

        green = new Trainer();
        green.newBasicPokemon(grass, 213, "Chikorita", 100, grassAbilities);

        driver = new Driver();
        driver.setActiveTrainer(red);
        driver.setPassiveTrainer(green);

        red.addObserver(driver);
        green.addObserver(driver);
    }

    @Test
    public void testDriver(){
        red.draw();
        red.selectCard(0);
        red.play();
        red.selectBenchPokemon(0);
        red.activatePokemon();
        red.draw();
        red.selectCard(0);
        red.play();
        red.draw();
        red.selectCard(0);
        red.selectActivePokemon();
        red.play();
        green.draw();
        green.selectCard(0);
        green.play();
        green.selectBenchPokemon(0);
        green.activatePokemon();
        red.draw();
        red.selectCard(0);
        red.play();
        red.selectAbility(0);
        red.getActivePokemon().getSelectedAbility().setTarget(green.getActivePokemon());
        driver.useAbility();

        assertEquals("Chikorita", driver.getActiveTrainer().getActivePokemon().getName());
        assertEquals(green, driver.getActiveTrainer());
        assertEquals(red, driver.getPassiveTrainer());

        green.newBasicPokemon(grass, 252, "Treecko", 100, grassAbilities);
        driver.draw();
        assertEquals("Treecko", green.getHand().get(0).getName());

        driver.showHand();

        driver.showPokemon();

        green.endTurn();

        assertEquals(red, driver.getActiveTrainer());



    }
}
