package pokemonTCG.pokemon.basic;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.pokemon.AbstractWaterPokemon;
import pokemonTCG.pokemon.phase1.P1WaterPokemon;

import java.util.ArrayList;
import java.util.HashMap;

public class BasicWaterPokemon extends AbstractWaterPokemon implements IBasicPokemon {

    /**
     * Constructor for a fire-type pokemon.
     * @param id Pokemon's pokédex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     * @param trainer Trainer.
     */
    public BasicWaterPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, Trainer trainer){
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
    public P1WaterPokemon evolve(int id, String name, int hp, ArrayList<IAbility> abilityList){
        return new P1WaterPokemon(id, name, hp, abilityList, this.getID(), this.getEnergyList(), this.getTrainer());
    }

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitBasicPokemon(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof BasicWaterPokemon && super.equals(obj);}

}
