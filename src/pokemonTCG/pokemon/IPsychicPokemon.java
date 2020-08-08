package pokemonTCG.pokemon;

import pokemonTCG.abilities.attacks.FightingAttack;
import pokemonTCG.abilities.attacks.PsychicAttack;

public interface IPsychicPokemon extends IPokemon {

    /**
     * Receives a psychic-type attack.
     * @param attack Attack.
     */
    void receivePsychicAttack(PsychicAttack attack);

    /**
     * Receives a fighting-type attack.
     * @param attack Attack.
     */
    void receiveFightingAttack(FightingAttack attack);
}
