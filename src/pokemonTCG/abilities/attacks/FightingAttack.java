package pokemonTCG.abilities.attacks;

import pokemonTCG.pokemon.IPokemon;

import java.util.HashMap;

/**
 * This class defines the logic of a fighting type attack.
 *
 * @author Diego S. Wistuba La Torre
 */

public class FightingAttack extends AbstractAttack {

    /**
     * Constructor of a fighting-type attack
     * @param name Name of the attack
     * @param text Descriptive text
     * @param costs Energy costs of the attack
     * @param baseDamage Base damage of the attack
     */
    public FightingAttack(String name, String text, HashMap<String, Integer> costs, int baseDamage){
        super(name, text, costs, baseDamage);
    }

    @Override
    public void execute(IPokemon other) {
        if (!super.blocked) {
            other.receiveFightingAttack(this);
        }
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof FightingAttack && super.equals(obj);
    }
}
