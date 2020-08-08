package pokemonTCG.types;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.WaterEnergy;
import pokemonTCG.pokemon.basic.BasicWaterPokemon;
import pokemonTCG.pokemon.phase1.P1WaterPokemon;
import pokemonTCG.pokemon.phase2.P2WaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for all water-type entities.
 */

public class Water extends AbstractType {

    /**
     * Constructs the water-type concept.
     */

    public Water(){
        super("Water");
    }

    @Override
    public String getTypeName(){return "Water";}

    @Override
    public WaterEnergy generateEnergy(){
        return new WaterEnergy();
    }

    @Override
    public BasicWaterPokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new BasicWaterPokemon(id, name, hp, abilityList, null);
    }

    @Override
    public P1WaterPokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P1WaterPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }

    @Override
    public P2WaterPokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P2WaterPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }
}
