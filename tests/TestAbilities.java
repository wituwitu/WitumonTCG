import org.junit.*;
import static org.junit.Assert.*;

import pokemonTCG.Trainer;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.*;
import pokemonTCG.abilities.support.EnergyBurn;
import pokemonTCG.energies.*;
import pokemonTCG.pokemon.basic.BasicGrassPokemon;
import pokemonTCG.pokemon.basic.BasicWaterPokemon;
import pokemonTCG.trainercards.items.Potion;
import pokemonTCG.types.Grass;

import java.util.ArrayList;
import java.util.HashMap;

public class TestAbilities{
    private GrassAttack grassAttack;
    private WaterAttack waterAttack;
    private FireAttack fireAttack;
    private FightingAttack fightingAttack;
    private PsychicAttack psychicAttack;
    private ThunderAttack thunderAttack;
    private GrassAttack grassAttack1;

    private HashMap<String, Integer> grassCost = new HashMap<>();
    private HashMap<String, Integer> waterCost = new HashMap<>();
    private HashMap<String, Integer> fireCost = new HashMap<>();
    private HashMap<String, Integer> fightingCost = new HashMap<>();
    private HashMap<String, Integer> psychicCost = new HashMap<>();
    private HashMap<String, Integer> thunderCost = new HashMap<>();

    @Before
    public void setUp() {
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

        grassAttack1 = new GrassAttack("Grass", "Performs a Grass-type attack", grassCost, 6);
    }

    @Test
    public void testGetBaseDamage(){
        assertEquals(grassAttack.getBaseDamage(), 6);
        assertEquals(waterAttack.getBaseDamage(), 6);
        assertEquals(fireAttack.getBaseDamage(), 6);
        assertEquals(fightingAttack.getBaseDamage(), 6);
        assertEquals(psychicAttack.getBaseDamage(), 6);
        assertEquals(thunderAttack.getBaseDamage(), 6);
    }

    @Test
    public void testGetName(){
        assertEquals(grassAttack.getName(), "Grass");
        assertEquals(waterAttack.getName(), "Water");
        assertEquals(fireAttack.getName(), "Fire");
        assertEquals(fightingAttack.getName(), "Fighting");
        assertEquals(psychicAttack.getName(), "Psychic");
        assertEquals(thunderAttack.getName(), "Thunder");
    }

    @Test
    public void testGetText(){
        assertEquals(grassAttack.getText(), "Performs a Grass-type attack");
        assertEquals(waterAttack.getText(), "Performs a Water-type attack");
        assertEquals(fireAttack.getText(), "Performs a Fire-type attack");
        assertEquals(fightingAttack.getText(), "Performs a Fighting-type attack");
        assertEquals(psychicAttack.getText(), "Performs a Psychic-type attack");
        assertEquals(thunderAttack.getText(), "Performs a Thunder-type attack");
    }

    @Test
    public void testGetCosts(){
        assertEquals(grassAttack.getCosts(), grassCost);
        assertEquals(waterAttack.getCosts(), waterCost);
        assertEquals(fireAttack.getCosts(), fireCost);
        assertEquals(fightingAttack.getCosts(), fightingCost);
        assertEquals(psychicAttack.getCosts(), psychicCost);
        assertEquals(thunderAttack.getCosts(), thunderCost);
    }

    @Test
    public void testEquals(){
        assertTrue(grassAttack.equals(grassAttack1));
        assertFalse(grassAttack.equals(waterAttack));
        assertFalse(waterAttack.equals(fireAttack));
        assertFalse(fireAttack.equals(psychicAttack));
        assertFalse(psychicAttack.equals(thunderAttack));
        assertFalse(thunderAttack.equals(fightingAttack));
        assertFalse(fightingAttack.equals(grassAttack1));
    }

    @Test
    public void testSetStatus(){
        HashMap<String, Integer> energyList = new HashMap<>();
        energyList.put("Grass", 0);
        grassAttack.setStatus(energyList);
        assertTrue(grassAttack.isBlocked());
        energyList.replace("Grass", 2);
        grassAttack.setStatus(energyList);
        assertFalse(grassAttack.isBlocked());
    }

    @Test
    public void testExecute(){
        ArrayList<IAbility> grassAbilities = new ArrayList<>();
        GrassAttack grassAttack = new GrassAttack("Grass", "Performs a grass-type attack", grassCost, 10);
        FireAttack fireAttack = new FireAttack("Fire", "Performs a fire-type attack", grassCost, 10);
        WaterAttack waterAttack = new WaterAttack("Water", "Performs a water-type attack", grassCost, 10);
        PsychicAttack psychicAttack = new PsychicAttack("Psychic", "Performs a Psychic-type attack", grassCost, 10);
        ThunderAttack thunderAttack = new ThunderAttack("Thunder", "Performs a thunder-type attack", grassCost, 10);
        FightingAttack fightingAttack = new FightingAttack("Fighting", "Performs a fighting-type attack", grassCost, 10);
        grassAbilities.add(grassAttack);
        BasicGrassPokemon bulbasaur = new BasicGrassPokemon(1, "Bulbasaur", 100, grassAbilities, null);
        grassAttack.execute(bulbasaur);
        fireAttack.execute(bulbasaur);
        waterAttack.execute(bulbasaur);
        psychicAttack.execute(bulbasaur);
        thunderAttack.execute(bulbasaur);
        fightingAttack.execute(bulbasaur);

        assertEquals(40, bulbasaur.getHP());

    }

    @Test
    public void testEnergyBurn(){
        EnergyBurn energyBurn = new EnergyBurn();
        ArrayList<IAbility> grassAbilities = new ArrayList<>();
        grassAbilities.add(energyBurn);
        BasicGrassPokemon bulbasaur = new BasicGrassPokemon(1, "Bulbasaur", 100, grassAbilities, null);
        bulbasaur.addToEnergyList(new GrassEnergy());
        bulbasaur.addToEnergyList(new FireEnergy());
        bulbasaur.addToEnergyList(new FireEnergy());
        bulbasaur.addToEnergyList(new FireEnergy());
        bulbasaur.addToEnergyList(new WaterEnergy());
        bulbasaur.addToEnergyList(new WaterEnergy());
        bulbasaur.addToEnergyList(new WaterEnergy());
        bulbasaur.addToEnergyList(new WaterEnergy());
        bulbasaur.addToEnergyList(new WaterEnergy());
        bulbasaur.addToEnergyList(new FightingEnergy());
        bulbasaur.addToEnergyList(new ThunderEnergy());
        bulbasaur.addToEnergyList(new PsychicEnergy());
        bulbasaur.selectAbility(0);
        bulbasaur.getSelectedAbility().setTarget(bulbasaur);
        bulbasaur.useAbility(bulbasaur);

        assertEquals((Integer) 4, bulbasaur.getEnergyList().get("Grass"));
        assertEquals((Integer) 0, bulbasaur.getEnergyList().get("Thunder"));

    }

    @Test
    public void testElectricShock(){

        ElectricShock electricShock = new ElectricShock();
        ArrayList<IAbility> grassAbilities = new ArrayList<>();
        grassAbilities.add(electricShock);
        BasicGrassPokemon bulbasaur = new BasicGrassPokemon(1, "Bulbasaur", 100, grassAbilities, null);
        BasicWaterPokemon squirtle = new BasicWaterPokemon(1, "Squirtle", 100, grassAbilities, null);
        bulbasaur.addToEnergyList(new ThunderEnergy());
        bulbasaur.addToEnergyList(new ThunderEnergy());
        bulbasaur.addToEnergyList(new ThunderEnergy());
        bulbasaur.addToEnergyList(new ThunderEnergy());
        bulbasaur.selectAbility(0);
        bulbasaur.useAbility(squirtle);

        assertEquals(100, bulbasaur.getHP());
        assertTrue(squirtle.getHP() == 100 || squirtle.getHP() == 75);
        assertEquals((Integer) 0, bulbasaur.getEnergyList().get("Thunder"));

    }

    @Test
    public void testPotion() {
        Trainer trainer = new Trainer();
        ArrayList<IAbility> grassAbilities = new ArrayList<>();
        Grass grass = new Grass();
        trainer.newBasicPokemon(grass, 1, "Bulbasaur", 100, grassAbilities);
        trainer.draw();
        trainer.selectCard(0);
        trainer.play();
        trainer.selectBenchPokemon(0);
        trainer.getSelectedPokemon().setHP(50);
        Potion potion = new Potion(trainer);
        trainer.newItem(potion);
        trainer.draw();
        trainer.selectCard(0);
        trainer.play();

        assertEquals(60, trainer.getSelectedPokemon().getHP());

    }




}