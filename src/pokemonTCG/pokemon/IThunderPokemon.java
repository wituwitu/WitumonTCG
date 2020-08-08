package pokemonTCG.pokemon;

import pokemonTCG.abilities.attacks.FightingAttack;

public interface IThunderPokemon extends IPokemon {

    /**
     * Receives a fighting-type attack.
     * @param attack Attack.
     */
    void receiveFightingAttack(FightingAttack attack);
}
