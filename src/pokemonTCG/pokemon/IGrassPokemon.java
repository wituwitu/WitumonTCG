package pokemonTCG.pokemon;

import pokemonTCG.abilities.attacks.FireAttack;
import pokemonTCG.abilities.attacks.WaterAttack;

public interface IGrassPokemon extends IPokemon {

    /**
     * Receives a fire-type attack.
     * @param attack Attack.
     */
    void receiveFireAttack(FireAttack attack);

    /**
     * Receives a water-type attack.
     * @param attack Attack.
     */
    void receiveWaterAttack(WaterAttack attack);
}
