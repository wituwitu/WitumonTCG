package pokemonTCG.abilities.attacks;

import pokemonTCG.pokemon.IPokemon;

import java.util.HashMap;

/**
 * This class defines the logic of a psychic type attack.
 *
 * @author Diego S. Wistuba La Torre
 */

public class PsychicAttack extends AbstractAttack {

    /**
     * Constructor of a psychic-type attack
     * @param name Name of the attack
     * @param text Descriptive text
     * @param costs Energy costs of the attack
     * @param baseDamage Base damage of the attack
     */
    public PsychicAttack(String name, String text, HashMap<String, Integer> costs, int baseDamage){
        super(name, text, costs, baseDamage);
    }

    @Override
    public void execute(IPokemon other){
        if (!super.blocked) {
            other.receivePsychicAttack(this);
        }
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof PsychicAttack && super.equals(obj);
    }
}
