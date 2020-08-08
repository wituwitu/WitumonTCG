package pokemonTCG.pokemon.phase2;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.pokemon.AbstractWaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

public class P2WaterPokemon extends AbstractWaterPokemon implements IP2Pokemon {

    /**
     * Constructor for a phase-two water-type pokemon.
     * @param id Pokemon's pokédex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     * @param evolvedID ID of the pre-evolution of this pokémon
     * @param energyList Energy list to be inherited if it needs to be
     * @param trainer Trainer.
     */
    public P2WaterPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer){
        super(id, name, hp, abilityList, evolvedID, energyList, trainer);
    }

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitP2Pokemon(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof P2WaterPokemon && super.equals(obj);}

}
