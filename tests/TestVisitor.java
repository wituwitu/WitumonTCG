import org.junit.Before;
import org.junit.Test;
import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.GrassAttack;
import pokemonTCG.trainercards.items.EquipItem;
import pokemonTCG.types.Grass;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestVisitor {

    private Trainer red;
    private Trainer green;

    @Before
    public void setUp(){
        red = new Trainer();
        Grass grass = new Grass();
        ArrayList<IAbility> grassAbilities = new ArrayList<>();

        HashMap<String, Integer> grassCost = new HashMap<>();

        grassCost.put("Grass", 1);

        GrassAttack grassAttack = new GrassAttack("Grass", "Performs a Grass-type attack", grassCost, 6);

        grassAbilities.add(grassAttack);

        red.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        red.newP1Pokemon(grass, 2, "Ivysaur", 100, grassAbilities, 1);
        red.newP2Pokemon(grass, 3, "Venusaur", 100, grassAbilities, 2);
        red.newEnergy(grass);

        green = new Trainer();
        green.newBasicPokemon(grass, 213, "Chikorita", 100, grassAbilities);
    }

    @Test
    public void testPlayVisitor(){
        red.draw();
        red.selectCard(0);
        red.play();
        assertEquals("Bulbasaur", red.getPokeList().get(0).getName());
        assertEquals(0, red.getHand().size());

        red.selectBenchPokemon(0);

        assertEquals("Bulbasaur", red.getSelectedPokemon().getName());

        red.draw();
        assertEquals("Ivysaur", red.getHand().get(0).getName());
        red.selectCard(0);
        red.play();
        assertEquals("Ivysaur", red.getPokeList().get(0).getName());

        red.activatePokemon();

        assertEquals("Ivysaur", red.getActivePokemon().getName());

        red.draw();
        assertEquals("Venusaur", red.getHand().get(0).getName());
        red.selectCard(0);

        red.selectActivePokemon();

        assertEquals("Ivysaur", red.getSelectedPokemon().getName());
        assertEquals("Ivysaur", red.getActivePokemon().getName());

        red.play();

        assertEquals("Venusaur", red.getActivePokemon().getName());

        red.draw();
        assertEquals("Grass Energy", red.getHand().get(0).getName());
        red.selectCard(0);
        red.play();
        assertEquals((Integer) 1, red.getActivePokemon().getEnergyList().get("Grass"));

        EquipItem item = new EquipItem("Item", "Test item. Does nothing.", null);
        red.newItem(item);
        red.draw();
        assertEquals("Item", red.getHand().get(0).getCardObject());
        red.selectCard(0);
        red.play();
        assertEquals(red, red.getActivePokemon().getItem().getTrainer());
        assertEquals(red.getActivePokemon(), red.getActivePokemon().getItem().getPokemon());

    }


    @Test
    public void testAbilityVisitor(){

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

        assertEquals("Grass Energy", red.getHand().get(0).getName());
        red.selectCard(0);
        red.play();

        assertEquals((Integer) 1, red.getActivePokemon().getEnergyList().get("Grass"));

        red.selectAbility(0);
        assertEquals("Grass", red.getActivePokemon().getSelectedAbility().getName());

        assertEquals("Venusaur", red.getActivePokemon().getSelectedAbility().getPokemon().getName());

        red.getActivePokemon().getSelectedAbility().setTarget(green.getActivePokemon());

        assertEquals("Chikorita", red.getActivePokemon().getSelectedAbility().getTarget().getName());

        assertEquals((Integer) 1, red.getActivePokemon().getEnergyList().get("Grass"));

        assertEquals((Integer) 1, red.getActivePokemon().getSelectedAbility().getCosts().get("Grass"));

        assertFalse(red.getActivePokemon().getSelectedAbility().isBlocked());

        red.getActivePokemon().getSelectedAbility().activate();

        assertEquals(100-6, green.getActivePokemon().getHP());


    }

}
