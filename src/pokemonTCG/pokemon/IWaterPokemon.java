package pokemonTCG.pokemon;

import pokemonTCG.abilities.attacks.FightingAttack;
import pokemonTCG.abilities.attacks.GrassAttack;
import pokemonTCG.abilities.attacks.ThunderAttack;

public interface IWaterPokemon extends IPokemon {

    /**
     * Receives a grass-type attack.
     * @param attack Attack.
     */
    void receiveGrassAttack(GrassAttack attack);

    /**
     * Receives a thunder-type attack.
     * @param attack Attack.
     */
    void receiveThunderAttack(ThunderAttack attack);

    /**
     * Receives a fighting-type attack.
     * @param attack Attack.
     */
    void receiveFightingAttack(FightingAttack attack);
}
