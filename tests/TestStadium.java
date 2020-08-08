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
import pokemonTCG.types.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestStadium {

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

        P2GrassPokemon venusaur = new P2GrassPokemon(3, "Venusaur", 100, grassAbilities, 2, energies, red);
        P1WaterPokemon wartortle = new P1WaterPokemon(6, "Wartortle", 100, grassAbilities, 2, energies, red);
        P2FirePokemon charizard = new P2FirePokemon(9, "Charizard", 100, grassAbilities, 2, energies, red);

        red.getPokeList().add(venusaur);
        red.activatePokemon();
        red.getPokeList().add(wartortle);
        red.getPokeList().add(charizard);

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
    public void testTrainingCenter() {
        TrainingCenter trainingCenter = new TrainingCenter(driver);
        red.newStadium(trainingCenter);
        red.draw();
        red.selectCard(0);
        red.play();

        assertEquals(150, red.getActivePokemon().getHP());
    }


}
