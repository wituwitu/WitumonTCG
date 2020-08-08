package pokemonTCG.pokemon;

import pokemonTCG.abilities.attacks.WaterAttack;

public interface IFirePokemon extends IPokemon {

    /**
     * Receives a water-type attack.
     * @param attack Attack.
     */
    void receiveWaterAttack(WaterAttack attack);
}
