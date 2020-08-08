package pokemonTCG.energies;

import pokemonTCG.ICard;
import pokemonTCG.types.IType;

/**
 * Common interface for energy cards.
 *
 * @author Diego S. Wistuba La Torre
 */

public interface IEnergy extends ICard {

    //region Properties

    /**
     * Returns the name of the energy card
     * @return Name of the energy card
     */
    String getName();

    /**
     * Returns the type of the energy card
     * @return Name of the energy card
     */
    IType getType();

    //endregion

    /**
     * Adds an energy card to the energy list of the pokémon.
     */
    void play();
}
