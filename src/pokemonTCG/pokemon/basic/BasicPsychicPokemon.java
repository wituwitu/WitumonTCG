package pokemonTCG.pokemon.basic;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.pokemon.AbstractPsychicPokemon;
import pokemonTCG.pokemon.phase1.P1PsychicPokemon;

import java.util.ArrayList;
import java.util.HashMap;

public class BasicPsychicPokemon extends AbstractPsychicPokemon implements IBasicPokemon {

    /**
     * Constructor for a fire-type pokemon.
     * @param id Pokemon's pokédex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     * @param trainer Trainer.
     */
    public BasicPsychicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, Trainer trainer){
        super(id, name, hp, abilityList, 0, new HashMap<>(), trainer);

        HashMap<String, Integer> energyList = new HashMap<>();

        energyList.put("Grass", 0);
        energyList.put("Water", 0);
        energyList.put("Fire", 0);
        energyList.put("Fighting", 0);
        energyList.put("Thunder", 0);
        energyList.put("Psychic", 0);

        this.setEnergyList(energyList);
    }

    @Override
    public P1PsychicPokemon evolve(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new P1PsychicPokemon(id, name, hp, abilityList, this.getID(), this.getEnergyList(), this.getTrainer());
    }

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitBasicPokemon(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof BasicPsychicPokemon && super.equals(obj);}

}
