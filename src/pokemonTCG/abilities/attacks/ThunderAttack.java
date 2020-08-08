package pokemonTCG.abilities.attacks;

import pokemonTCG.pokemon.IPokemon;

import java.util.HashMap;

/**
 * This class defines the logic of a thunder type attack.
 *
 * @author Diego S. Wistuba La Torre
 */

public class ThunderAttack extends AbstractAttack {

    /**
     * Constructor of a thunder-type attack
     * @param name Name of the attack
     * @param text Descriptive text
     * @param costs Energy costs of the attack
     * @param baseDamage Base damage of the attack
     */
    public ThunderAttack(String name, String text, HashMap<String, Integer> costs, int baseDamage){
        super(name, text, costs, baseDamage);
    }

    @Override
    public void execute(IPokemon other){
        if (!super.blocked) {
            other.receiveThunderAttack(this);
        }
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof ThunderAttack && super.equals(obj);
    }
}
