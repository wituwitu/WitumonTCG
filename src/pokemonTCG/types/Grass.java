package pokemonTCG.types;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.GrassEnergy;
import pokemonTCG.pokemon.basic.BasicGrassPokemon;
import pokemonTCG.pokemon.phase1.P1GrassPokemon;
import pokemonTCG.pokemon.phase2.P2GrassPokemon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for all grass-type entities.
 */

public class Grass extends AbstractType {

    /**
     * Constructor for the grass-type concept.
     */
    public Grass(){
        super("Grass");
    }

    //region Properties

    @Override
    public String getTypeName(){return "Grass";}

    //endregion

    @Override
    public GrassEnergy generateEnergy(){
        return new GrassEnergy();
    }

    @Override
    public BasicGrassPokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new BasicGrassPokemon(id, name, hp, abilityList, null);
    }

    @Override
    public P1GrassPokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P1GrassPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }

    @Override
    public P2GrassPokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P2GrassPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }
}
