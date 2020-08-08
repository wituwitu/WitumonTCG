import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.*;
import pokemonTCG.energies.*;
import pokemonTCG.pokemon.basic.*;
import pokemonTCG.pokemon.phase1.*;
import pokemonTCG.pokemon.phase2.*;
import pokemonTCG.trainercards.items.EquipItem;
import pokemonTCG.types.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TestPokemon {
    private BasicGrassPokemon bulbasaur;
    private BasicWaterPokemon squirtle;
    private BasicFirePokemon charmander;
    private BasicFightingPokemon machop;
    private BasicPsychicPokemon abra;
    private BasicThunderPokemon pikachu;
    private BasicGrassPokemon bulbasaur2;
    private BasicWaterPokemon squirtle2;
    private BasicFirePokemon charmander2;
    private BasicFightingPokemon machop2;
    private BasicPsychicPokemon abra2;
    private BasicThunderPokemon pikachu2;

    private ArrayList<IAbility> grassAbilities = new ArrayList<>();
    private ArrayList<IAbility> waterAbilities = new ArrayList<>();
    private ArrayList<IAbility> fireAbilities = new ArrayList<>();
    private ArrayList<IAbility> fightingAbilities = new ArrayList<>();
    private ArrayList<IAbility> psychicAbilities = new ArrayList<>();
    private ArrayList<IAbility> thunderAbilities = new ArrayList<>();

    private GrassAttack grassAttack;
    private WaterAttack waterAttack;
    private FireAttack fireAttack;
    private FightingAttack fightingAttack;
    private PsychicAttack psychicAttack;
    private ThunderAttack thunderAttack;

    private GrassEnergy grassEnergy;
    private WaterEnergy waterEnergy;
    private FireEnergy fireEnergy;
    private FightingEnergy fightingEnergy;
    private PsychicEnergy psychicEnergy;
    private ThunderEnergy thunderEnergy;

    private HashMap<String, Integer> grassCost = new HashMap<>();
    private HashMap<String, Integer> waterCost = new HashMap<>();
    private HashMap<String, Integer> fireCost = new HashMap<>();
    private HashMap<String, Integer> fightingCost = new HashMap<>();
    private HashMap<String, Integer> psychicCost = new HashMap<>();
    private HashMap<String, Integer> thunderCost = new HashMap<>();

    @Before public void setUp(){

        Trainer trainer = new Trainer();

        grassCost.put("Grass", 1);
        waterCost.put("Water", 1);
        fireCost.put("Fire", 1);
        fightingCost.put("Fighting", 1);
        psychicCost.put("Psychic", 1);
        thunderCost.put("Thunder", 1);

        grassAttack = new GrassAttack("Grass", "Performs a Grass-type attack", grassCost, 6);
        waterAttack = new WaterAttack("Water", "Performs a Water-type attack", waterCost, 6);
        fireAttack = new FireAttack("Fire", "Performs a Fire-type attack", fireCost, 6);
        fightingAttack = new FightingAttack("Fighting", "Performs a Fighting-type attack", fightingCost, 6);
        psychicAttack = new PsychicAttack("Psychic", "Performs a Psychic-type attack", psychicCost, 6);
        thunderAttack = new ThunderAttack("Thunder", "Performs a Thunder-type attack", thunderCost, 6);

        grassAbilities.add(grassAttack);
        waterAbilities.add(waterAttack);
        fireAbilities.add(fireAttack);
        fightingAbilities.add(fightingAttack);
        psychicAbilities.add(psychicAttack);
        thunderAbilities.add(thunderAttack);

        bulbasaur = new BasicGrassPokemon(1, "Bulbasaur", 100, grassAbilities, trainer);
        squirtle = new BasicWaterPokemon(4, "Squirtle", 100, waterAbilities, trainer);
        charmander = new BasicFirePokemon(7, "Charmander", 100, fireAbilities, trainer);
        machop = new BasicFightingPokemon(66, "Machop", 100, fightingAbilities, trainer);
        abra = new BasicPsychicPokemon(63, "Abra", 100, psychicAbilities, trainer);
        pikachu = new BasicThunderPokemon(25, "Pikachu", 100, thunderAbilities, trainer);
        bulbasaur2 = new BasicGrassPokemon(1, "Bulbasaur", 100, grassAbilities, trainer);
        squirtle2 = new BasicWaterPokemon(4, "Squirtle", 100, waterAbilities, trainer);
        charmander2 = new BasicFirePokemon(7, "Charmander", 100, fireAbilities, trainer);
        machop2 = new BasicFightingPokemon(66, "Machop", 100, fightingAbilities, trainer);
        abra2 = new BasicPsychicPokemon(63, "Abra", 100, psychicAbilities, trainer);
        pikachu2 = new BasicThunderPokemon(25, "Pikachu", 100, thunderAbilities, trainer);

        grassEnergy = new GrassEnergy();
        waterEnergy = new WaterEnergy();
        fireEnergy = new FireEnergy();
        fightingEnergy = new FightingEnergy();
        psychicEnergy = new PsychicEnergy();
        thunderEnergy = new ThunderEnergy();

    }

    @Test
    public void testGetID(){
        assertEquals(bulbasaur.getID(), 1);
        assertEquals(squirtle.getID(), 4);
        assertEquals(charmander.getID(), 7);
        assertEquals(machop.getID(), 66);
        assertEquals(abra.getID(), 63);
        assertEquals(pikachu.getID(), 25);
    }

    @Test
    public void testGetInitialHP(){
        assertEquals(bulbasaur.getInitialHP(), 100);
        assertEquals(squirtle.getInitialHP(), 100);
        assertEquals(charmander.getInitialHP(), 100);
        assertEquals(machop.getInitialHP(), 100);
        assertEquals(abra.getInitialHP(), 100);
        assertEquals(pikachu.getInitialHP(), 100);
    }

    @Test
    public void testGetName(){
        assertEquals(bulbasaur.getName(), "Bulbasaur");
        assertEquals(squirtle.getName(), "Squirtle");
        assertEquals(charmander.getName(), "Charmander");
        assertEquals(machop.getName(), "Machop");
        assertEquals(abra.getName(), "Abra");
        assertEquals(pikachu.getName(), "Pikachu");
    }

    @Test
    public void testGetAbilities(){
        assertEquals(bulbasaur.getAbilities(), grassAbilities);
        assertEquals(squirtle.getAbilities(), waterAbilities);
        assertEquals(charmander.getAbilities(), fireAbilities);
        assertEquals(machop.getAbilities(), fightingAbilities);
        assertEquals(abra.getAbilities(), psychicAbilities);
        assertEquals(pikachu.getAbilities(), thunderAbilities);
    }

    @Test
    public void testGetSelectedAbility(){
        bulbasaur.selectAbility(0);

        assertEquals(bulbasaur.getSelectedAbility(), grassAttack);
    }

    @Test
    public void testAddAbility(){
        WaterAttack waterAttack2 = new WaterAttack("Water 2", "Another water attack", grassCost, 12);
        WaterAttack waterAttack3 = new WaterAttack("Water 3", "Another water attack", grassCost, 12);
        WaterAttack waterAttack4 = new WaterAttack("Water 4", "Another water attack", grassCost, 12);
        WaterAttack waterAttack5 = new WaterAttack("Water 5", "Another water attack", grassCost, 12);

        squirtle.addAbility(waterAttack2);
        squirtle.selectAbility(1);
        assertEquals(squirtle.getSelectedAbility(), waterAttack2);

        squirtle.addAbility(waterAttack3);
        squirtle.selectAbility(2);
        assertEquals(squirtle.getSelectedAbility(), waterAttack3);

        squirtle.addAbility(waterAttack4);
        squirtle.selectAbility(3);
        assertEquals(squirtle.getSelectedAbility(), waterAttack4);

        squirtle.addAbility(waterAttack5);
        assertTrue(squirtle.getAbilities().contains(waterAttack));
        assertTrue(squirtle.getAbilities().contains(waterAttack2));
        assertTrue(squirtle.getAbilities().contains(waterAttack3));
        assertTrue(squirtle.getAbilities().contains(waterAttack4));
        assertFalse(squirtle.getAbilities().contains(waterAttack5));
    }

    @Test
    public void testAddToEnergyList(){
        squirtle.addToEnergyList(waterEnergy);
        squirtle.addToEnergyList(waterEnergy);
        squirtle.addToEnergyList(waterEnergy);
        assertFalse(squirtle.getEnergyList().isEmpty());
        assertEquals((int) squirtle.getEnergyList().get("Water"), 3);
        squirtle.selectAbility(0);
        squirtle.useAbility(bulbasaur);
        assertEquals((Integer) 2, squirtle.getEnergyList().get("Water"));
    }

    @Test
    public void testAttack(){

        squirtle.addToEnergyList(waterEnergy);
        squirtle.selectAbility(0);
        squirtle.useAbility(abra);
        assertEquals(abra.getHP(), 100-6);

        abra.addToEnergyList(psychicEnergy);
        abra.selectAbility(0);
        abra.useAbility(abra);
        assertEquals(abra.getHP(), 100-6-6*2);

        machop.addToEnergyList(fightingEnergy);
        machop.selectAbility(0);
        machop.useAbility(abra);
        assertEquals(abra.getHP(), 100-6-6*2);

        abra.addToEnergyList(psychicEnergy);
        abra.selectAbility(0);
        abra.useAbility(machop);
        assertEquals(machop.getHP(), 100-6*2);

        bulbasaur.addToEnergyList(grassEnergy);
        bulbasaur.selectAbility(0);
        bulbasaur.useAbility(machop);
        assertEquals(machop.getHP(), 100-6*2-6*2);

        squirtle.addToEnergyList(waterEnergy);
        squirtle.selectAbility(0);
        squirtle.useAbility(charmander);
        assertEquals(charmander.getHP(), 100-6*2);

        machop.addToEnergyList(fightingEnergy);
        machop.selectAbility(0);
        machop.useAbility(pikachu);
        assertEquals(pikachu.getHP(), 100-6*2);

        bulbasaur.addToEnergyList(grassEnergy);
        bulbasaur.selectAbility(0);
        bulbasaur.useAbility(squirtle);
        assertEquals(squirtle.getHP(), 100-6*2);

        pikachu.addToEnergyList(thunderEnergy);
        pikachu.selectAbility(0);
        pikachu.useAbility(squirtle);
        assertEquals(squirtle.getHP(), 100-6*2-6*2);

        machop.addToEnergyList(fightingEnergy);
        machop.selectAbility(0);
        machop.useAbility(squirtle);
        assertEquals(squirtle.getHP(), 100-6*2-6*2);

        charmander.addToEnergyList(fireEnergy);
        charmander.selectAbility(0);
        charmander.useAbility(bulbasaur);
        assertEquals(bulbasaur.getHP(), 100-6*2);

        squirtle.addToEnergyList(waterEnergy);
        squirtle.selectAbility(0);
        squirtle.useAbility(bulbasaur);
        assertEquals(bulbasaur.getHP(), 100-6*2);

        squirtle.addToEnergyList(waterEnergy);
        squirtle.selectAbility(0);
        squirtle.getSelectedAbility().setTarget(bulbasaur);
        squirtle.attack();
        assertEquals(bulbasaur.getHP(), 100-6*2);

    }

    @Test
    public void testEquals(){
        assertTrue(bulbasaur.equals(bulbasaur2));
        assertTrue(squirtle.equals(squirtle2));
        assertTrue(charmander.equals(charmander2));
        assertTrue(machop.equals(machop2));
        assertTrue(abra.equals(abra2));
        assertTrue(pikachu.equals(pikachu2));
    }

    @Test
    public void testGetCardObject(){
        assertEquals(squirtle.getCardObject(), "Pokemon");
    }

    @Test
    public void TestGetAttacks(){
        Water water = new Water();
        P1WaterPokemon kingdra = water.generateP1Pokemon(230, "Kingdra", 100, psychicAbilities, 99);
        kingdra.receiveGrassAttack(grassAttack);
        kingdra.receiveWaterAttack(waterAttack);
        kingdra.receiveFireAttack(fireAttack);
        kingdra.receiveFightingAttack(fightingAttack);
        kingdra.receivePsychicAttack(psychicAttack);
        kingdra.receiveThunderAttack(thunderAttack);

        assertEquals(kingdra.getHP(), 58);

    }

    @Test
    public void testNewPokemon() {
        Trainer trainer = new Trainer();
        BasicGrassPokemon bulbasaur = new BasicGrassPokemon(1, "Bulbasaur", 100, grassAbilities, trainer);
        BasicFirePokemon charmander = new BasicFirePokemon(3, "Charmander", 100, grassAbilities, trainer);
        BasicWaterPokemon squirtle = new BasicWaterPokemon(2, "Squirtle", 100, grassAbilities, trainer);
        BasicFightingPokemon machop = new BasicFightingPokemon(378, "Machop", 100, grassAbilities, trainer);
        BasicThunderPokemon pikachu = new BasicThunderPokemon(1, "Pikachu", 100, grassAbilities, trainer);
        BasicPsychicPokemon abra = new BasicPsychicPokemon(1, "Abra", 100, grassAbilities, trainer);

        Visitor visitor = new PlayVisitor();

        bulbasaur.accept(visitor);
        charmander.accept(visitor);
        squirtle.accept(visitor);
        abra.accept(visitor);
        pikachu.accept(visitor);

        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals("Charmander", charmander.getName());
        assertEquals("Squirtle", squirtle.getName());
        assertEquals("Machop", machop.getName());
        assertEquals("Pikachu", pikachu.getName());
        assertEquals("Abra", abra.getName());

        P1GrassPokemon ivysaur = bulbasaur.evolve(2, "Ivysaur", 100, grassAbilities);
        P1WaterPokemon wartortle = squirtle.evolve(2, "Wartortle", 100, grassAbilities);
        P1FirePokemon charmeleon = charmander.evolve(2, "Charmeleon", 100, grassAbilities);
        P1FightingPokemon machoke = machop.evolve(2, "Machoke", 100, grassAbilities);
        P1ThunderPokemon raichu = pikachu.evolve(2, "Raichu", 100, grassAbilities);
        P1PsychicPokemon kadabra = abra.evolve(2, "Kadabra", 100, grassAbilities);

        Visitor visitor2 = new PlayVisitor();

        assertEquals(trainer, ivysaur.getTrainer());

        trainer.selectBenchPokemon(0);
        assertEquals("Bulbasaur", trainer.getSelectedPokemon().getName());
        ivysaur.accept(visitor2);
        assertEquals("Ivysaur", trainer.getSelectedPokemon().getName());
        assertEquals("Ivysaur", trainer.getPokeList().get(0).getName());
        trainer.selectBenchPokemon(1);
        charmeleon.accept(visitor2);
        trainer.selectBenchPokemon(2);
        wartortle.accept(visitor2);
        trainer.selectBenchPokemon(3);
        kadabra.accept(visitor2);
        trainer.selectBenchPokemon(4);
        raichu.accept(visitor2);

        assertEquals("Ivysaur", ivysaur.getName());
        assertEquals("Wartortle", wartortle.getName());
        assertEquals("Charmeleon", charmeleon.getName());
        assertEquals("Machoke", machoke.getName());
        assertEquals("Raichu", raichu.getName());
        assertEquals("Kadabra", kadabra.getName());

        P2GrassPokemon venusaur = ivysaur.evolve(2, "Venusaur", 100, grassAbilities);
        P2FirePokemon charizard = charmeleon.evolve(2, "Charizard", 100, grassAbilities);
        P2WaterPokemon blastoise = wartortle.evolve(2, "Blastoise", 100, grassAbilities);
        P2PsychicPokemon alakazam = kadabra.evolve(2, "Alakazam", 100, grassAbilities);
        P2ThunderPokemon birichu = raichu.evolve(2, "Birichu", 100, grassAbilities);

        Visitor visitor3 = new PlayVisitor();

        trainer.selectBenchPokemon(0);
        venusaur.accept(visitor3);
        trainer.selectBenchPokemon(1);
        charizard.accept(visitor3);
        trainer.selectBenchPokemon(2);
        blastoise.accept(visitor3);
        trainer.selectBenchPokemon(3);
        alakazam.accept(visitor3);
        trainer.selectBenchPokemon(4);
        birichu.accept(visitor3);

        assertEquals("Venusaur", venusaur.getName());
        assertEquals("Blastoise", blastoise.getName());
        assertEquals("Charizard", charizard.getName());
        assertEquals("Birichu", birichu.getName());
        assertEquals("Alakazam", alakazam.getName());
    }

    @Test
    public void testNewPokemonFighting() {
        Trainer trainer = new Trainer();
        BasicFightingPokemon machop = new BasicFightingPokemon(378, "Machop", 100, grassAbilities, trainer);

        Visitor visitor = new PlayVisitor();

        machop.accept(visitor);
        assertEquals("Machop", machop.getName());

        P1FightingPokemon machoke = machop.evolve(2, "Machoke", 100, grassAbilities);

        Visitor visitor2 = new PlayVisitor();


        trainer.selectBenchPokemon(0);
        machoke.accept(visitor2);

        assertEquals("Machoke", machoke.getName());

        P2FightingPokemon machamp = machoke.evolve(2, "Machamp", 100, grassAbilities);

        Visitor visitor3 = new PlayVisitor();

        trainer.selectBenchPokemon(0);
        machamp.accept(visitor3);

        assertEquals("Machamp", machamp.getName());
    }

    @Test
    public void testItem(){
        EquipItem item = new EquipItem("Item", "Test item. Does nothing.", new Trainer());
        bulbasaur.equip(item);
        assertEquals(bulbasaur.getTrainer(), item.getTrainer());
        assertEquals(bulbasaur, item.getPokemon());
    }



}
