package pokemonTCG.types;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.PsychicEnergy;
import pokemonTCG.pokemon.basic.BasicPsychicPokemon;
import pokemonTCG.pokemon.phase1.P1PsychicPokemon;
import pokemonTCG.pokemon.phase2.P2PsychicPokemon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for all psychic-type entities.
 */

public class Psychic extends AbstractType {

    /**
     * Constructor for the psychic-type concept.
     */
    public Psychic(){
        super("Psychic");
    }

    //region Properties

    @Override
    public String getTypeName(){return "Psychic";}

    //endregion

    @Override
    public PsychicEnergy generateEnergy(){
        return new PsychicEnergy();
    }

    @Override
    public BasicPsychicPokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new BasicPsychicPokemon(id, name, hp, abilityList, null);
    }

    @Override
    public P1PsychicPokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P1PsychicPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }

    @Override
    public P2PsychicPokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        return new P2PsychicPokemon(id, name, hp, abilityList, evolvedID, new HashMap<>(), null);
    }
}
