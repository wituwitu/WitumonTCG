import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import pokemonTCG.AbstractCard;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.Trainer;
import pokemonTCG.energies.GrassEnergy;
import pokemonTCG.pokemon.basic.BasicGrassPokemon;
import pokemonTCG.types.*;

import java.util.ArrayList;

public class TestTrainer {
    private Trainer red;
    private ArrayList<AbstractCard> deck;
    private ArrayList<AbstractCard> pokeList;
    private IPokemon activePokemon;
    private Grass grass;
    private GrassEnergy grassEnergy;

    private ArrayList<IAbility> grassAbilities;
    private IPokemon bulbasaur;

    @Before
    public void setUp(){
        deck = new ArrayList<>();
        pokeList = new ArrayList<>();
        grass = new Grass();
        grassAbilities = new ArrayList<>();
        grassEnergy = new GrassEnergy();
        bulbasaur = new BasicGrassPokemon(1, "Bulbasaur", 100, grassAbilities, null);
    }

    @Test
    public void testNewEnergy(){
        Trainer red = new Trainer();
        red.newEnergy(grass);
        assertEquals(red.getDeck().get(0), grassEnergy);
    }

    @Test
    public void testNewPokemon(){
        Trainer red = new Trainer();
        red.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        assertEquals(red.getDeck().get(0), bulbasaur);
    }

    @Test
    public void testToBench() {
        Trainer red = new Trainer();
        assertTrue(red.getPrizeCards().isEmpty());
        red.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 2, "Ivysaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 3, "Venusaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 152, "Chikorita", 100, grassAbilities);
        red.newBasicPokemon(grass, 154, "Meganium", 0, grassAbilities);


        assertEquals(red.getDeck().get(0).getName(), "Bulbasaur");
        red.draw();
        red.toBench(red.getHand().get(0));
        assertEquals(red.getPokeList().size(), 1);
        assertEquals(red.getPokeList().get(0).getName(), "Bulbasaur");

        assertEquals(red.getDeck().get(0).getName(), "Ivysaur");
        red.draw();
        red.toBench(red.getHand().get(0));
        assertEquals(red.getPokeList().size(), 2);
        assertEquals(red.getPokeList().get(1).getName(), "Ivysaur");

        assertEquals(red.getDeck().get(0).getName(), "Venusaur");
        red.draw();
        red.toBench(red.getHand().get(0));
        assertEquals(red.getPokeList().size(), 3);
        assertEquals(red.getPokeList().get(2).getName(), "Venusaur");

        assertEquals(red.getDeck().get(0).getName(), "Chikorita");
        red.draw();
        red.toBench(red.getHand().get(0));
        assertEquals(red.getPokeList().size(), 4);

        assertEquals(red.getDeck().get(0).getName(), "Meganium");
        red.draw();
        red.toBench(red.getHand().get(0));
        assertEquals(red.getPokeList().size(), 5);

        assertEquals(red.getPokeList().get(4).getName(), "Meganium");

        red.activatePokemon();
        assertEquals("Bulbasaur", red.getActivePokemon().getName());

        red.activateBenchPokemon(3);
        assertEquals("Meganium", red.getActivePokemon().getName());

        red.checkActivePokemon();
        assertEquals("Ivysaur", red.getActivePokemon().getName());

        red.newEnergy(grass);
        assertEquals(red.getCard(0), "0. Name: Grass Energy; Object: Energy");

    }

    @Test
    public void testGenerate(){
        Trainer red = new Trainer();

        Grass grass = new Grass();
        Water water = new Water();
        Fire fire = new Fire();
        Fighting fighting = new Fighting();
        Psychic psychic = new Psychic();
        Thunder thunder = new Thunder();

        ArrayList<IAbility> grassAbilities = new ArrayList<>();
        ArrayList<IAbility> waterAbilities = new ArrayList<>();
        ArrayList<IAbility> fireAbilities = new ArrayList<>();
        ArrayList<IAbility> fightingAbilities = new ArrayList<>();
        ArrayList<IAbility> psychicAbilities = new ArrayList<>();
        ArrayList<IAbility> thunderAbilities = new ArrayList<>();

        red.newBasicPokemon(grass,1, "Bulbasaur", 100, grassAbilities);
        red.newBasicPokemon(water,4, "Squirtle", 100, waterAbilities);
        red.newBasicPokemon(fire, 7, "Charmander", 100, fireAbilities);
        red.newBasicPokemon(fighting,66, "Machop", 100, fightingAbilities);
        red.newBasicPokemon(psychic,63, "Abra", 100, psychicAbilities);
        red.newBasicPokemon(thunder,25, "Pikachu", 100, thunderAbilities);

        red.newEnergy(grass);
        red.newEnergy(water);
        red.newEnergy(fire);
        red.newEnergy(fighting);
        red.newEnergy(psychic);
        red.newEnergy(thunder);

        assertEquals(red.getDeck().get(0).getName(), "Bulbasaur");
        assertEquals(red.getDeck().get(1).getName(), "Squirtle");
        assertEquals(red.getDeck().get(2).getName(), "Charmander");
        assertEquals(red.getDeck().get(3).getName(), "Machop");
        assertEquals(red.getDeck().get(4).getName(), "Abra");
        assertEquals(red.getDeck().get(5).getName(), "Pikachu");
        assertEquals(red.getDeck().get(6).getName(), "Grass Energy");
        assertEquals(red.getDeck().get(7).getName(), "Water Energy");
        assertEquals(red.getDeck().get(8).getName(), "Fire Energy");
        assertEquals(red.getDeck().get(9).getName(), "Fighting Energy");
        assertEquals(red.getDeck().get(10).getName(), "Psychic Energy");
        assertEquals(red.getDeck().get(11).getName(), "Thunder Energy");
    }


}
