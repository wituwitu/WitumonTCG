package pokemonTCG.pokemon;

import pokemonTCG.ICard;
import pokemonTCG.types.IType;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.*;
import pokemonTCG.energies.*;
import pokemonTCG.trainercards.items.EquipItem;
import pokemonTCG.trainercards.items.IItem;
import pokemonTCG.trainercards.items.InstantItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Common interface for pokemon.
 *
 * @author Diego S. Wistuba La Torre
 */

public interface IPokemon extends ICard {

    //region Properties

    /**
     * @return Pokemon's pokedex number.
     */
    int getID();

    /**
     * @return Pokemon's name.
     */
    String getName();

    /**
     * @return Pokemon's initial (maximum) health points
     */
    int getInitialHP();

    /**
     * @return Pokemon's actual health points
     */
    int getHP();

    /**
     * @return List of the pokemon's abilities
     */
    ArrayList<IAbility> getAbilities();

    /**
     * @return Currently selected ability
     */
    IAbility getSelectedAbility();

    /**
     * @return Energy list of the pokemon
     */
    HashMap<String, Integer> getEnergyList();

    /**
     * @return Type of pokemon
     */
    IType getType();

    /**
     * @return ID of the evolution of this pokémon
     */
    int getPreviousEvolution();

    //endregion

    IItem getItem();

    void setHP(int newHP);

    /**
     * Adds an ability to the ability pool of the pokemon
      * @param ability Ability to be added
     */
    void addAbility(IAbility ability);

    /**
     * Adds an energy card to the energy card pool of the pokemon
     * @param energy Energy card to be added
     */
    void addToEnergyList(IEnergy energy);

    /**
     * Checks whether the pokemon's HP is 0 or less.
     * @return True if the pokemon's HP is 0 or less, False if else
     */
    boolean isDead();

    /**
     * Selects an ability.
     * @param index Index of the ability to be selected.
     */
    void selectAbility(int index);

    /**
     * Gets damaged by an attack.
     * @param attack The attack.
     */
    void receiveAttack(IAttack attack);

    /**
     * Doubles the damage received.
     * @param attack The attack that our pokémon is weak to.
     */
    void receiveWeaknessAttack(IAttack attack);

    /**
     * Substracts 20 from the damage received.
     * @param attack The attack our pokemon is resistant to.
     */
    void receiveResistantAttack(IAttack attack);

    void useAbility(IPokemon target);

    /**
     * Receives damage from a grass attack
     * @param attack Attack
     */
    void receiveGrassAttack(GrassAttack attack);

    /**
     * Receives damage from a fire attack
     * @param attack Attack
     */
    void receiveFireAttack(FireAttack attack);

    /**
     * Receives damage from a water attack
     * @param attack Attack
     */
    void receiveWaterAttack(WaterAttack attack);

    /**
     * Receives damage from a thunder attack
     * @param attack Attack
     */
    void receiveThunderAttack(ThunderAttack attack);

    /**
     * Receives damage from a fighting attack
     * @param attack Attack
     */
    void receiveFightingAttack(FightingAttack attack);

    /**
     * Receives damage from a psychic attack
     * @param attack Attack
     */
    void receivePsychicAttack(PsychicAttack attack);

    /**
     * Adds a fighting energy card to the pokemon's energy list.
     * @param energy Attack
     */
    void addFightingEnergy(FightingEnergy energy);

    /**
     * Adds a fire energy card to the pokemon's energy list.
     * @param energy Attack
     */
    void addFireEnergy(FireEnergy energy);

    /**
     * Adds a grass energy card to the pokemon's energy list.
     * @param energy Attack
     */
    void addGrassEnergy(GrassEnergy energy);

    /**
     * Adds a psychic energy card to the pokemon's energy list.
     * @param energy Attack
     */
    void addPsychicEnergy(PsychicEnergy energy);

    /**
     * Adds a thunder energy card to the pokemon's energy list.
     * @param energy Attack
     */
    void addThunderEnergy(ThunderEnergy energy);

    /**
     * Adds a water energy card to the pokemon's energy list.
     * @param energy Attack
     */
    void addWaterEnergy(WaterEnergy energy);

    /**
     * Checks if this pokémon is active.
     * @return True or False.
     */
    boolean isActive();

    /**
     * Equips an item.
     * @param item Item to be equipped.
     */
    void equip(EquipItem item);

    /**
     * Uses an instant item.
     * @param item Item to be used.
     */
    void useItem(InstantItem item);

    void attack();

    boolean isEvolved();

    /**
     * Check if two pokémon are the same.
     * @param obj Another pokémon.
     * @return True or False.
     */
    boolean equals(Object obj);
}

