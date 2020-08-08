package pokemonTCG.pokemon;

import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.FightingAttack;
import pokemonTCG.abilities.attacks.PsychicAttack;
import pokemonTCG.types.Water;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractPsychicPokemon extends AbstractPokemon implements IPsychicPokemon{

    /**
     * Constructor for an abstract water-type pokemon.
     * @param id Pokemon's pokedex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     */

    public AbstractPsychicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer){
        super(id, name, hp, abilityList, new Water(), evolvedID, energyList, trainer);
    }

    @Override
    public void attack(){
        this.getSelectedAbility().getTarget().receivePsychicAttack((PsychicAttack) this.getSelectedAbility());
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack){
        receiveWeaknessAttack(attack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack attack){
        receiveResistantAttack(attack);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof AbstractPsychicPokemon && super.equals(obj);}

}
