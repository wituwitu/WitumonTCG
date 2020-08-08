package pokemonTCG.types;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.IEnergy;
import pokemonTCG.pokemon.IPokemon;

import java.util.ArrayList;

public interface IType {

    //region Properties

    /**
     * Gets the name of the type.
     * @return The name of the type.
     */
    String getTypeName();

    //endregion

    /**
     * Generates an energy card of this type.
     * @return Energy card
     */
    IEnergy generateEnergy();

    /**
     * Generates a basic pokemon of this type.
     * @param id Pokemon's pokedex number
     * @param name Name of the pokemon
     * @param hp Initial HP of the pokemon
     * @param abilityList List of the pokemon's abilities
     * @return Pokemon card
     */
    IPokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList);

    /**
     * Generates a phase-one pokemon of this type.
     * @param id Pokemon's pokedex number
     * @param name Name of the pokemon
     * @param hp Initial HP of the pokemon
     * @param abilityList List of the pokemon's abilities
     * @param evolvedID ID of the pre-evolution of this pokémon.
     * @return Pokemon card
     */
    IPokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID);

    /**
     * Generates a phase-two pokemon of this type.
     * @param id Pokemon's pokedex number
     * @param name Name of the pokemon
     * @param hp Initial HP of the pokemon
     * @param abilityList List of the pokemon's abilities
     * @param evolvedID ID of the pre-evolution of this pokémon.
     * @return Pokemon card
     */
    IPokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID);
}
