package pokemonTCG.pokemon;

import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.*;
import pokemonTCG.types.Grass;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractGrassPokemon extends AbstractPokemon implements IGrassPokemon{

    /**
     * Constructor for an abstract water-type pokemon.
     * @param id Pokemon's pokedex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     */

    public AbstractGrassPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer){
        super(id, name, hp, abilityList, new Grass(), evolvedID, energyList, trainer);
    }

    @Override
    public void attack(){
        this.getSelectedAbility().getTarget().receiveGrassAttack((GrassAttack) this.getSelectedAbility());
    }

    @Override
    public void receiveFireAttack(FireAttack attack){
        receiveWeaknessAttack(attack);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack){
        receiveResistantAttack(attack);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof AbstractGrassPokemon && super.equals(obj);}

}
