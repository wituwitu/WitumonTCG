package pokemonTCG.abilities;

import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.Visitor;

import java.util.HashMap;

/**
 * Common interface for pokemon abilities.
 * By now, all of them are attacks.
 *
 * @author Diego S. Wistuba La Torre
 */

public interface IAbility {

    //region Properties

    /**
     * Name of the attack.
     * @return Name.
     */
    String getName();

    /**
     * Text describing the attack.
     * @return Describing text.
     */
    String getText();

    /**
     * Hashmap with the cost of the ability by energy type.
     * @return Costs by type
     */
    HashMap<String, Integer> getCosts();

    /**
     * The pokémon that has this ability.
     * @return A pokémon.
     */
    IPokemon getPokemon();

    /**
     * Gets the target, who is going to receive the ability.
     * @return A pokémon.
     */
    IPokemon getTarget();

    /**
     * Checks if the ability is blocked or not.
     * @return True or false.
     */
    boolean isBlocked();

    //endregion

    /**
     * Sets the status of the ability: Blocked or unblocked.
     * @param energyList List of available energies to be compared with the costs of the ability
     */
    void setStatus(HashMap<String, Integer> energyList);

    /**
     * Sets the costs of the ability.
     * @param costs List of costs.
     */
    void setCosts(HashMap<String, Integer> costs);

    /**
     * Sets the pokémon that has this ability.
     * @param pokemon A pokemon
     */
    void setPokemon(IPokemon pokemon);

    /**
     * Accepts a visitor.
     * @param aVisitor A visitor.
     */
    void accept(Visitor aVisitor);

    /**
     * Executes the ability.
     * @param target The pokémon that is going to receive this ability.
     */
    void execute(IPokemon target);

    /**
     * Sets the target for the ability.
     * @param pokemon A pokemon
     */
    void setTarget(IPokemon pokemon);

    /**
     * Triggers the execution of the ability via a visitor.
     */
    void activate();
}
