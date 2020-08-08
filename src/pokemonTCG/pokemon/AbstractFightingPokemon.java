package pokemonTCG.pokemon;

import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.FightingAttack;
import pokemonTCG.abilities.attacks.GrassAttack;
import pokemonTCG.abilities.attacks.PsychicAttack;
import pokemonTCG.types.Fighting;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractFightingPokemon extends AbstractPokemon implements IFightingPokemon{

    /**
     * Constructor of an abstract fighting pokemon
     *
     * @param id          Pokemon's pokedex number
     * @param name        Name of the pokemon
     * @param hp          Initial HP of the pokemon
     * @param abilityList List of abilities of the pokemon
     */
    protected AbstractFightingPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer) {
        super(id, name, hp, abilityList, new Fighting(), evolvedID, energyList, trainer);
    }

    @Override
    public void attack(){
        this.getSelectedAbility().getTarget().receiveFightingAttack((FightingAttack) this.getSelectedAbility());
    }

    @Override
    public void receivePsychicAttack(PsychicAttack attack){
        receiveWeaknessAttack(attack);
    }

    @Override
    public void receiveGrassAttack(GrassAttack attack){
        receiveWeaknessAttack(attack);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof AbstractFightingPokemon && super.equals(obj);}

}
