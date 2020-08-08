package pokemonTCG.pokemon.phase2;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.pokemon.AbstractThunderPokemon;

import java.util.ArrayList;
import java.util.HashMap;

public class P2ThunderPokemon extends AbstractThunderPokemon implements IP2Pokemon {

    /**
     * Constructor for a phase-two thunder-type pokemon.
     * @param id Pokemon's pokédex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     * @param evolvedID ID of the pre-evolution of this pokémon
     * @param energyList Energy list to be inherited if it needs to be
     * @param trainer Trainer.
     */
    public P2ThunderPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer){
        super(id, name, hp, abilityList, evolvedID, energyList, trainer);
    }

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitP2Pokemon(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof P2ThunderPokemon && super.equals(obj);}

}
