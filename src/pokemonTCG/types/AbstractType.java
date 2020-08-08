package pokemonTCG.types;

import pokemonTCG.energies.IEnergy;
import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.abilities.IAbility;

import java.util.ArrayList;

/**
 * Generic type class. Contains the necessary methods to access type properties.
 * @author Diego S. Wistuba La Torre
 */

public abstract class AbstractType implements IType {
    private String type;

    /**
     * Constructor of a type.
     * @param name Name of the type
     */
    public AbstractType(String name) {
        this.type = name;
    }

    //region Properties

    @Override
    public String getTypeName() {return type;}

    //endregion

    @Override
    public abstract IEnergy generateEnergy();

    @Override
    public abstract IPokemon generateBasicPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList);

    @Override
    public abstract IPokemon generateP1Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID);

    @Override
    public abstract IPokemon generateP2Pokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID);


}
