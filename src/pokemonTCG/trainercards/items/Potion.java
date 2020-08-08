package pokemonTCG.trainercards.items;

import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.Trainer;
import pokemonTCG.trainercards.items.InstantItem;

public class Potion extends InstantItem {

    public Potion(Trainer trainer){
        super("Potion", "Cures 10 HP", trainer);
    }

    /**
     * Executes a potion.
     * The pokémon regenerates 10 HP.
     **/
    @Override
    public void effect(){
        int healing = 10;
        IPokemon pokemon = this.getPokemon();
        pokemon.setHP(pokemon.getHP() + healing);
    }
}
