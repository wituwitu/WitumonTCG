package pokemonTCG.trainercards.stadiums;

import pokemonTCG.*;
import pokemonTCG.trainercards.AbstractTrainerCard;

public class Stadium extends AbstractTrainerCard {

    private Driver driver;

    public Stadium(String name, String text, Trainer trainer, Driver driver){
        super(name, text, trainer);
        this.driver = driver;
    }

    //region Properties

    @Override
    public String getCardObject() { return "Stadium"; }

    /**
     * Gets the driver of the game.
     * @return The driver of the game.
     */
    public Driver getDriver() { return driver; }

    //endregion

    /**
     * Sets the driver for this card.
     * @param driver The driver of the game.
     */
    public void setDriver(Driver driver) { this.driver = driver; }

    @Override
    public void play(){
        Visitor playVisitor = new PlayVisitor();
        accept(playVisitor);
    }

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitStadium(this);
    }

    /**
     * The effect of the card.
     */
    public void effect(){}

}
