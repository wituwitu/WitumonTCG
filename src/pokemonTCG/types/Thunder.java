package pokemonTCG.types;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.ThunderEnergy;
import pokemonTCG.pokemon.basic.BasicThunderPokemon;
import pokemonTCG.pokemon.phase1.P1ThunderPokemon;
import pokemonTCG.pokemon.phase2.P2ThunderPokemon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for all thunder-type entities.
 */

public class Thunder extends AbstractType {

    /**
     * Constructor for the thunder-type concept.
     */
    public Thunder(){
        super("Thunder");
    }

    //region Properties

    @Override
    public String getTypeName(){return "Thunder";}

    //endregion

    @Override
    public ThunderEnergy generateEnergy(){
        return new ThunderEnergy();
    }

    @Override
    public BasicThunderPokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new BasicThunderPokemon(id, name, hp, abilityList, null);
    }

    @Override
    public P1ThunderPokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P1ThunderPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }

    @Override
    public P2ThunderPokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P2ThunderPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }
}
