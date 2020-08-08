package pokemonTCG.pokemon;

import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.FireAttack;
import pokemonTCG.abilities.attacks.WaterAttack;
import pokemonTCG.types.Fire;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractFirePokemon extends AbstractPokemon implements IFirePokemon{

    /**
     * Constructor of an abstract fire pokemon
     *
     * @param id          Pokemon's pokedex number
     * @param name        Name of the pokemon
     * @param hp          Initial HP of the pokemon
     * @param abilityList List of abilities of the pokemon
     */
    protected AbstractFirePokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer) {
        super(id, name, hp, abilityList, new Fire(), evolvedID, energyList, trainer);
    }

    @Override
    public void attack(){
        this.getSelectedAbility().getTarget().receiveFireAttack((FireAttack) this.getSelectedAbility());
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack){
        receiveWeaknessAttack(attack);
    }

}
