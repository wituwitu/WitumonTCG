import org.junit.*;
import static org.junit.Assert.*;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.PlayVisitor;
import pokemonTCG.Trainer;
import pokemonTCG.energies.*;
import pokemonTCG.types.Grass;

import java.util.ArrayList;

public class TestEnergy {
    private GrassEnergy grassEnergy;
    private WaterEnergy waterEnergy;
    private FireEnergy fireEnergy;
    private FightingEnergy fightingEnergy;
    private PsychicEnergy psychicEnergy;
    private ThunderEnergy thunderEnergy;
    private GrassEnergy grassEnergy1;

    @Before public void setUp() {
        grassEnergy = new GrassEnergy();
        waterEnergy = new WaterEnergy();
        fireEnergy = new FireEnergy();
        fightingEnergy = new FightingEnergy();
        psychicEnergy = new PsychicEnergy();
        thunderEnergy = new ThunderEnergy();
        grassEnergy1 = new GrassEnergy();
    }

    @Test
    public void testGetCardObject(){
        assertEquals(grassEnergy.getCardObject(), "Energy");
        assertEquals(waterEnergy.getCardObject(), "Energy");
        assertEquals(fireEnergy.getCardObject(), "Energy");
        assertEquals(fightingEnergy.getCardObject(), "Energy");
        assertEquals(psychicEnergy.getCardObject(), "Energy");
        assertEquals(thunderEnergy.getCardObject(), "Energy");
    }

    @Test
    public void testEnergyEquals() {

        assertTrue(grassEnergy.equals(grassEnergy1));
        assertFalse(waterEnergy.equals(fireEnergy));
        assertFalse(fireEnergy.equals(fightingEnergy));
        assertFalse(fightingEnergy.equals(psychicEnergy));
        assertFalse(psychicEnergy.equals(thunderEnergy));
        assertFalse(thunderEnergy.equals(grassEnergy));
        assertFalse(grassEnergy.equals(waterEnergy));

    }

    @Test
    public void testGetTrainer(){
        Trainer trainer = new Trainer();
        grassEnergy.setTrainer(trainer);
        fireEnergy.setTrainer(trainer);
        waterEnergy.setTrainer(trainer);
        fightingEnergy.setTrainer(trainer);
        thunderEnergy.setTrainer(trainer);
        psychicEnergy.setTrainer(trainer);

        assertEquals(trainer, grassEnergy.getTrainer());
        assertEquals(trainer, fireEnergy.getTrainer());
        assertEquals(trainer, waterEnergy.getTrainer());
        assertEquals(trainer, fightingEnergy.getTrainer());
        assertEquals(trainer, thunderEnergy.getTrainer());
        assertEquals(trainer, psychicEnergy.getTrainer());
    }

    @Test
    public void testPlay(){
        Trainer trainer = new Trainer();
        ArrayList<IAbility> abilityList = new ArrayList<>();
        Grass grass = new Grass();
        trainer.newBasicPokemon(grass,1, "Bulbasaur", 100, abilityList);
        trainer.draw();
        trainer.selectCard(0);
        trainer.play();
        trainer.activatePokemon();
        grassEnergy.setTrainer(trainer);
        fireEnergy.setTrainer(trainer);
        waterEnergy.setTrainer(trainer);
        fightingEnergy.setTrainer(trainer);
        psychicEnergy.setTrainer(trainer);
        thunderEnergy.setTrainer(trainer);

        grassEnergy.play();
        fireEnergy.play();
        waterEnergy.play();
        fightingEnergy.play();
        psychicEnergy.play();
        thunderEnergy.play();

        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Grass"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Fire"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Water"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Fighting"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Psychic"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Thunder"));

    }

    @Test
    public void testVisitor(){
        Trainer trainer = new Trainer();
        ArrayList<IAbility> abilityList = new ArrayList<>();
        Grass grass = new Grass();
        trainer.newBasicPokemon(grass,1, "Bulbasaur", 100, abilityList);
        trainer.draw();
        trainer.selectCard(0);
        trainer.play();
        trainer.activatePokemon();
        grassEnergy.setTrainer(trainer);
        fireEnergy.setTrainer(trainer);
        waterEnergy.setTrainer(trainer);
        fightingEnergy.setTrainer(trainer);
        psychicEnergy.setTrainer(trainer);
        thunderEnergy.setTrainer(trainer);

        PlayVisitor visitor = new PlayVisitor();
        ArrayList<IAbility> grassAbilities = new ArrayList<>();
        trainer.newBasicPokemon(grass, 1, "Bulbasasur", 100, grassAbilities);
        trainer.draw();
        trainer.selectCard(0);
        trainer.play();
        trainer.selectBenchPokemon(0);
        trainer.activatePokemon();
        grassEnergy.accept(visitor);
        fireEnergy.accept(visitor);
        waterEnergy.accept(visitor);
        fightingEnergy.accept(visitor);
        psychicEnergy.accept(visitor);
        thunderEnergy.accept(visitor);

        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Grass"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Fire"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Water"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Fighting"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Psychic"));
        assertEquals((Integer) 1, trainer.getActivePokemon().getEnergyList().get("Thunder"));

        assertTrue(grassEnergy.equals(grassEnergy1));
        assertFalse(waterEnergy.equals(grassEnergy));
        assertFalse(fireEnergy.equals(grassEnergy));
        assertFalse(psychicEnergy.equals(grassEnergy));
        assertFalse(thunderEnergy.equals(grassEnergy));
        assertFalse(fightingEnergy.equals(grassEnergy));


    }
}
