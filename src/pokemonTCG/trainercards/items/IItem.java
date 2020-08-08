package pokemonTCG.trainercards.items;

import pokemonTCG.ICard;
import pokemonTCG.pokemon.IPokemon;

public interface IItem extends ICard {
    IPokemon getPokemon();
}
