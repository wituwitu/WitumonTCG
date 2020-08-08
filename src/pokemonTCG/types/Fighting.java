package pokemonTCG.types;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.FightingEnergy;
import pokemonTCG.pokemon.basic.BasicFightingPokemon;
import pokemonTCG.pokemon.phase1.P1FightingPokemon;
import pokemonTCG.pokemon.phase2.P2FightingPokemon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for all fighting-type entities.
 */

public class Fighting extends AbstractType {

    /**
     * Constructor for the fire-type concept.
     */
    public Fighting(){
        super("Fighting");
    }

    //region Properties

    @Override
    public String getTypeName(){return "Fighting";}

    //endregion

    @Override
    public FightingEnergy generateEnergy(){
        return new FightingEnergy();
    }

    @Override
    public BasicFightingPokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new BasicFightingPokemon(id, name, hp, abilityList, null);
    }

    @Override
    public P1FightingPokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P1FightingPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }

    @Override
    public P2FightingPokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P2FightingPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }
}
