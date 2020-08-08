package pokemonTCG;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.energies.IEnergy;
import pokemonTCG.pokemon.basic.IBasicPokemon;
import pokemonTCG.pokemon.phase1.IP1Pokemon;
import pokemonTCG.pokemon.phase2.IP2Pokemon;
import pokemonTCG.trainercards.items.EquipItem;
import pokemonTCG.trainercards.items.InstantItem;
import pokemonTCG.trainercards.stadiums.Stadium;
import pokemonTCG.trainercards.supportcards.Support;

public abstract class Visitor {

    /**
     * Visits the basic pokemon that is going to be played, and plays it.
     *
     * @param pokemon The pokémon that is going to be played.
     */
    public void visitBasicPokemon(IBasicPokemon pokemon){}

    /**
     * Visits the phase-one pokemon that is going to be played, and plays it. The pre-evolution needs to be in the field.
     *
     * @param pokemon The pokémon that is going to be played.
     */
    public void visitP1Pokemon(IP1Pokemon pokemon){}

    /**
     * Visits the phase-two pokemon that is going to be played, and plays it. The pre-evolution needs to be in the field.
     *
     * @param pokemon The pokémon that is going to be played.
     */
    public void visitP2Pokemon(IP2Pokemon pokemon){}

    /**
     * Visits the energy card that is going to be played, and plays it.
     *
     * @param energy The energy card that is going to be played.
     */
    public void visitEnergy(IEnergy energy){}

    /**
     * Visits the equippable item card that is going to be played, and plays it.
     *
     * @param item The equippable item.
     */
    public void visitEquipItem(EquipItem item){}

    /**
     * Visits the instant item card that is going to be played, and plays it.
     *
     * @param instantItem The instant item.
     */
    public void visitInstantItem(InstantItem instantItem){}

    /**
     * Visits the stadium card that is going to be played, and plays it.
     *
     * @param stadium The stadium.
     */
    public void visitStadium(Stadium stadium){}

    /**
     * Visits the support card that is going to be played, and plays it.
     *
     * @param support The support card.
     */
    public void visitSupportCard(Support support){}

    /**
     * Visits the attack that is going to be executed, and executes it.
     *
     * @param attack The attack ability.
     */
    public void visitAttack(IAbility attack){}

    /**
     * Visits the attack that is going to be executed, and executes it.
     *
     * @param ability The attack ability.
     */
    public void visitSupport(IAbility ability){}
}
