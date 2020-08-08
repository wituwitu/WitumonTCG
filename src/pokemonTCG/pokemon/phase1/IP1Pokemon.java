package pokemonTCG.pokemon.phase1;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.pokemon.phase2.IP2Pokemon;

import java.util.ArrayList;

public interface IP1Pokemon extends IPokemon {

    /**
     * Creates the evolution of this pokémon, inheriting the energy list and the trainer.
     * @param id Pokémon's pokédex number
     * @param name Pokémon's name
     * @param hp Pokémon's initial HP
     * @param abilityList Pokémon's ability list
     * @return A phase-two pokémon
     */
    IP2Pokemon evolve(int id, String name, int hp, ArrayList<IAbility> abilityList);
}
