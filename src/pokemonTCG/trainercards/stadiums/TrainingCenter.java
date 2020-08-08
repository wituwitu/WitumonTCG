package pokemonTCG.trainercards.stadiums;

import pokemonTCG.Driver;
import pokemonTCG.Trainer;
import pokemonTCG.pokemon.IPokemon;

import java.util.ArrayList;

public class TrainingCenter extends Stadium {
    public TrainingCenter(Driver driver){
        super("Training Center", "Every phase 1 or phase 2 pokémon gets +50 HP.", null, driver);
    }

    /**
     * Every phase 1 or 2 pokémon gets +50 HP.
     */
    public void effect(){
        Driver driver = getDriver();
        Trainer activeTrainer = driver.getActiveTrainer();
        Trainer passiveTrainer = driver.getPassiveTrainer();
        ArrayList<IPokemon> pokemonList = new ArrayList<>();
        pokemonList.add(activeTrainer.getActivePokemon());
        pokemonList.add(passiveTrainer.getActivePokemon());
        pokemonList.addAll(activeTrainer.getPokeList());
        pokemonList.addAll(passiveTrainer.getPokeList());

        for (IPokemon pokemon : pokemonList){
            if (pokemon.isEvolved()){
                pokemon.setHP(pokemon.getHP() + 50);
            }
        }
    }
}
