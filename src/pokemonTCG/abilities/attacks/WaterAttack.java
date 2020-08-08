package pokemonTCG.abilities.attacks;

import pokemonTCG.pokemon.IPokemon;

import java.util.HashMap;

/**
 * This class defines the logic of a water type attack.
 *
 * @author Diego S. Wistuba La Torre
 */

public class WaterAttack extends AbstractAttack {

    /**
     * Constructor of a water-type attack
     * @param name Name of the attack
     * @param text Descriptive text
     * @param costs Energy costs of the attack
     * @param baseDamage Base damage of the attack
     */
    public WaterAttack(String name, String text, HashMap<String, Integer> costs, int baseDamage){
        super(name, text, costs, baseDamage);
    }

    @Override
    public void execute(IPokemon other){
        if (!super.blocked) {
            other.receiveWaterAttack(this);
        }
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof WaterAttack && super.equals(obj);
    }
}