package pokemonTCG.pokemon.basic;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.pokemon.phase1.IP1Pokemon;

import java.util.ArrayList;

public interface IBasicPokemon extends IPokemon {

    /**
     * Creates the evolution of this pokémon, inheriting the energy list and the trainer.
     * @param id Pokémon's pokédex number
     * @param name Pokémon's name
     * @param hp Pokémon's initial HP
     * @param abilityList Pokémon's ability list
     * @return A phase-one pokémon
     */
    IP1Pokemon evolve(int id, String name, int hp, ArrayList<IAbility> abilityList);
}
