import org.junit.Before;
import org.junit.Test;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.pokemon.basic.*;
import pokemonTCG.pokemon.phase1.*;
import pokemonTCG.pokemon.phase2.*;
import pokemonTCG.types.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestType {
    private Grass grass;
    private Water water;
    private Fire fire;
    private Fighting fighting;
    private Psychic psychic;
    private Thunder thunder;

    @Before
    public void setUp(){
        grass = new Grass();
        water = new Water();
        fire = new Fire();
        fighting = new Fighting();
        psychic = new Psychic();
        thunder = new Thunder();
    }

    @Test
    public void testGetType(){
        assertEquals(grass.getTypeName(), "Grass");
        assertEquals(water.getTypeName(), "Water");
        assertEquals(fire.getTypeName(), "Fire");
        assertEquals(fighting.getTypeName(), "Fighting");
        assertEquals(psychic.getTypeName(), "Psychic");
        assertEquals(thunder.getTypeName(), "Thunder");
    }

    @Test
    public void testGeneratePokemon(){
        ArrayList<IAbility> grassAbilities = new ArrayList<>();
        BasicGrassPokemon bulbasaur = grass.generateBasicPokemon(1, "Bulbasaur", 100, grassAbilities);
        BasicWaterPokemon squirtle = water.generateBasicPokemon(1, "Squirtle", 100, grassAbilities);
        BasicFirePokemon charmander = fire.generateBasicPokemon(1, "Charmander", 100, grassAbilities);
        BasicFightingPokemon machop = fighting.generateBasicPokemon(1, "Machop", 100, grassAbilities);
        BasicThunderPokemon pikachu = thunder.generateBasicPokemon(1, "Pikachu", 100, grassAbilities);
        BasicPsychicPokemon abra = psychic.generateBasicPokemon(1, "Abra", 100, grassAbilities);

        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals("Squirtle", squirtle.getName());
        assertEquals("Charmander", charmander.getName());
        assertEquals("Machop", machop.getName());
        assertEquals("Pikachu", pikachu.getName());
        assertEquals("Abra", abra.getName());

        P1GrassPokemon ivysaur = grass.generateP1Pokemon(1, "Ivysaur", 100, grassAbilities, 1);
        P1WaterPokemon wartortle = water.generateP1Pokemon(1, "Wartortle", 100, grassAbilities, 1);
        P1FirePokemon charmeleon = fire.generateP1Pokemon(1, "Charmeleon", 100, grassAbilities, 1);
        P1FightingPokemon machoke = fighting.generateP1Pokemon(1, "Machoke", 100, grassAbilities, 1);
        P1ThunderPokemon raichu = thunder.generateP1Pokemon(1, "Raichu", 100, grassAbilities, 1);
        P1PsychicPokemon kadabra = psychic.generateP1Pokemon(1, "Kadabra", 100, grassAbilities, 1);

        assertEquals("Ivysaur", ivysaur.getName());
        assertEquals("Wartortle", wartortle.getName());
        assertEquals("Charmeleon", charmeleon.getName());
        assertEquals("Machoke", machoke.getName());
        assertEquals("Raichu", raichu.getName());
        assertEquals("Kadabra", kadabra.getName());

        P2GrassPokemon venusaur = grass.generateP2Pokemon(1, "Venusaur", 100, grassAbilities, 1);
        P2WaterPokemon blastoise = water.generateP2Pokemon(1, "Blastoise", 100, grassAbilities, 1);
        P2FirePokemon charizard = fire.generateP2Pokemon(1, "Charizard", 100, grassAbilities, 1);
        P2FightingPokemon machamp = fighting.generateP2Pokemon(1, "Machamp", 100, grassAbilities, 1);
        P2ThunderPokemon birichu = thunder.generateP2Pokemon(1, "Birichu", 100, grassAbilities, 1);
        P2PsychicPokemon alakazam = psychic.generateP2Pokemon(1, "Alakazam", 100, grassAbilities, 1);

        assertEquals("Venusaur", venusaur.getName());
        assertEquals("Blastoise", blastoise.getName());
        assertEquals("Charizard", charizard.getName());
        assertEquals("Machamp", machamp.getName());
        assertEquals("Birichu", birichu.getName());
        assertEquals("Alakazam", alakazam.getName());

    }

}
