package pokemonTCG.pokemon;

import pokemonTCG.abilities.attacks.GrassAttack;
import pokemonTCG.abilities.attacks.PsychicAttack;

public interface IFightingPokemon extends IPokemon {

    /**
     * Receives a psychic-type attack.
     * @param attack Attack.
     */
    void receivePsychicAttack(PsychicAttack attack);

    /**
     * Receives a grass-type attack.
     * @param attack Attack.
     */
    void receiveGrassAttack(GrassAttack attack);
}
