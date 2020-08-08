package pokemonTCG.types;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.FireEnergy;
import pokemonTCG.pokemon.basic.BasicFirePokemon;
import pokemonTCG.pokemon.phase1.P1FirePokemon;
import pokemonTCG.pokemon.phase2.P2FirePokemon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for all fire-type entities.
 */

public class Fire extends AbstractType {

    /**
     * Constructor for the fire-type concept.
     */

    public Fire(){
        super("Fire");
    }

    //region Properties

    @Override
    public String getTypeName(){return "Fire";}

    //endregion

    @Override
    public FireEnergy generateEnergy(){
        return new FireEnergy();
    }

    @Override
    public BasicFirePokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new BasicFirePokemon(id, name, hp, abilityList, null);
    }

    @Override
    public P1FirePokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P1FirePokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }

    @Override
    public P2FirePokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P2FirePokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }
}
