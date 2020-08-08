package pokemonTCG.pokemon;

import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.*;
import pokemonTCG.types.Water;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWaterPokemon extends AbstractPokemon implements IWaterPokemon{

    /**
     * Constructor for an abstract water-type pokemon.
     * @param id Pokemon's pokedex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     */
    public AbstractWaterPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer){
        super(id, name, hp, abilityList, new Water(), evolvedID, energyList, trainer);
    }

    @Override
    public void attack(){
        this.getSelectedAbility().getTarget().receiveWaterAttack((WaterAttack) this.getSelectedAbility());
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack){
        receiveWeaknessAttack(attack);
    }

    @Override
    public void receiveThunderAttack(ThunderAttack attack){
        receiveWeaknessAttack(attack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack attack){
        receiveResistantAttack(attack);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof AbstractWaterPokemon && super.equals(obj);}

}
