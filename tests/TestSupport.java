
import org.junit.Before;
import org.junit.Test;
import pokemonTCG.Driver;
import pokemonTCG.Trainer;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.pokemon.phase1.P1FightingPokemon;
import pokemonTCG.pokemon.phase1.P1ThunderPokemon;
import pokemonTCG.pokemon.phase1.P1WaterPokemon;
import pokemonTCG.pokemon.phase2.P2FirePokemon;
import pokemonTCG.pokemon.phase2.P2GrassPokemon;
import pokemonTCG.pokemon.phase2.P2PsychicPokemon;
import pokemonTCG.trainercards.stadiums.TrainingCenter;
import pokemonTCG.trainercards.supportcards.ProfessorJuniper;
import pokemonTCG.types.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestSupport {

    private Trainer red;
    private Trainer green;
    private Driver driver;
    private Grass grass;
    private Water water;
    private ArrayList<IAbility> grassAbilities;
    private Fire fire;
    private Fighting fighting;
    private Psychic psychic;
    private Thunder thunder;

    @Before
    public void setUp() {
        grass = new Grass();
        water = new Water();
        fire = new Fire();
        fighting = new Fighting();
        psychic = new Psychic();
        thunder = new Thunder();

        red = new Trainer();

        ArrayList<IAbility> grassAbilities = new ArrayList<>();

        HashMap<String, Integer> energies = new HashMap<>();

        red.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        red.draw();
        red.newBasicPokemon(grass, 2, "Ivysaur", 100, grassAbilities);
        red.draw();
        red.newBasicPokemon(grass, 3, "Venusaur", 100, grassAbilities);
        red.draw();

        green = new Trainer();

        P1ThunderPokemon electroboy = new P1ThunderPokemon(213, "Electroboy", 100, grassAbilities, 2, energies, green);
        P2PsychicPokemon alakazam = new P2PsychicPokemon(213, "Alakazam", 100, grassAbilities, 2, energies, green);
        P1FightingPokemon machoke = new P1FightingPokemon(213, "Machoke", 100, grassAbilities, 2, energies, green);

        green.getPokeList().add(electroboy);
        green.activatePokemon();
        red.getPokeList().add(alakazam);
        red.getPokeList().add(machoke);

        driver = new Driver();
        driver.setActiveTrainer(red);
        driver.setPassiveTrainer(green);

        red.addObserver(driver);
        green.addObserver(driver);
    }

    @Test
    public void testProfessorJuniper(){
        ProfessorJuniper professorJuniper = new ProfessorJuniper(red);
        red.newSupport(professorJuniper);

        red.newBasicPokemon(grass, 152, "Chikorita", 100, grassAbilities);
        red.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 2, "Ivysaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 3, "Venusaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 152, "Chikorita", 100, grassAbilities);
        red.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 2, "Ivysaur", 100, grassAbilities);
        red.newBasicPokemon(grass, 3, "Venusaur", 100, grassAbilities);

        red.draw();
        red.selectCard(3);
        assertEquals("Professor Juniper", red.getHand().get(3).getName());
        red.play();

        assertEquals("Chikorita", red.getHand().get(0).getName());
    }
}