package pokemonTCG.pokemon.phase1;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.pokemon.AbstractPsychicPokemon;
import pokemonTCG.pokemon.phase2.P2PsychicPokemon;

import java.util.ArrayList;
import java.util.HashMap;

public class P1PsychicPokemon extends AbstractPsychicPokemon implements IP1Pokemon {

    /**
     * Constructor for a phase-one psychic-type pokemon.
     * @param id Pokemon's pokédex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     * @param evolvedID ID of the pre-evolution of this pokémon
     * @param energyList Energy list to be inherited if it needs to be
     * @param trainer Trainer.
     */
    public P1PsychicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer){
        super(id, name, hp, abilityList, evolvedID, energyList, trainer);
    }

    @Override
    public P2PsychicPokemon evolve(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new P2PsychicPokemon(id, name, hp, abilityList, this.getID(), this.getEnergyList(), this.getTrainer());
    }

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitP1Pokemon(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof P1PsychicPokemon && super.equals(obj);}

}
