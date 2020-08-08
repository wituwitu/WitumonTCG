package pokemonTCG;

import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.trainercards.stadiums.Stadium;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Driver implements Observer {
    private Trainer activeTrainer;
    private Trainer passiveTrainer;
    private Stadium stadium;

    @Override
    public void update(Observable o, Object trigger){
        boolean trigger1 = (boolean) trigger;
        if (trigger1) {
            Trainer aux = activeTrainer;
            activeTrainer = passiveTrainer;
            passiveTrainer = aux;
        }
    }

    //region Properties

    /**
     * Getter for the active trainer.
     * @return The active trainer.
     */
    public Trainer getActiveTrainer(){return activeTrainer;}

    /**
     * Getter for the passive trainer.
     * @return The passive trainer.
     */
    public Trainer getPassiveTrainer(){return passiveTrainer;}


    //endregion

    /**
     * Sets the active trainer.
     * @param active The trainer.
     */
    public void setActiveTrainer(Trainer active) { activeTrainer = active; }

    /**
     * Sets the passive trainer.
     * @param passive The trainer.
     */
    public void setPassiveTrainer(Trainer passive) { passiveTrainer = passive; }

    /**
     * Sets the stadium of the game.
     * @param stadium The stadium
     */
    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
        stadium.effect();
    }

    /**
     * Makes the active trainer draw a card from the deck.
     */
    public void draw(){
        activeTrainer.draw();
    }

    /**
     * Displays the hand of the active player.
     */
    public void showHand(){
        ArrayList<ICard> hand = activeTrainer.getHand();
        System.out.println("Hand:");
        for (ICard card : hand) {
            System.out.println(card.getName());
        }
    }

    /**
     * Displays all the pokémon in game.
     */
    public void showPokemon(){
        IPokemon activeActivePokemon = activeTrainer.getActivePokemon();
        IPokemon passiveActivePokemon = passiveTrainer.getActivePokemon();
        ArrayList<IPokemon> activeBench = activeTrainer.getPokeList();
        ArrayList<IPokemon> passiveBench = passiveTrainer.getPokeList();

        System.out.println("Active pokémon: " + activeActivePokemon.getName() + " VS " + passiveActivePokemon.getName());

        System.out.println("Active player's bench: ");
        for (IPokemon pokemon : activeBench) {
            System.out.println(pokemon.getName());
        }

        System.out.println("Enemy's bench: ");
        for (IPokemon pokemon : passiveBench) {
            System.out.println(pokemon.getName());
        }
    }

    /**
     * Makes the active player use their selected ability.
     */
    public void useAbility(){
        activeTrainer.getActivePokemon().getSelectedAbility().activate();
    }

}
