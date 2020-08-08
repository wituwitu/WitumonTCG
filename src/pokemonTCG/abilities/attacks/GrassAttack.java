package pokemonTCG.abilities.attacks;

import pokemonTCG.pokemon.IPokemon;

import java.util.HashMap;

/**
 * This class defines the logic of a grass type attack.
 *
 * @author Diego S. Wistuba La Torre
 */

public class GrassAttack extends AbstractAttack {

    /**
     * Constructor of a grass-type attack
     * @param name Name of the attack
     * @param text Descriptive text
     * @param costs Energy costs of the attack
     * @param baseDamage Base damage of the attack
     */
    public GrassAttack(String name, String text, HashMap<String, Integer> costs, int baseDamage){
        super(name, text, costs, baseDamage);
    }

    @Override
    public void execute(IPokemon other){
        if (!super.blocked) {
            other.receiveGrassAttack(this);
        }
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof GrassAttack && super.equals(obj);
    }
}
