package pokemonTCG;

public interface ICard {

    //region Properties

    /**
     * Getter for the name of the card
     * @return The name of the card
     */
    String getName();

    /**
     * Getter for the category the card is in.
     * @return By now, "Energy" or "Pokemon".
     */
    String getCardObject();


    /**
     * Getter for the trainer that possesses this card.
     * @return The trainer entity.
     */
    Trainer getTrainer();

    /**
     * Checks if the card has been played.
     * @return True or false.
     */
    boolean isPlayed();
    //endregion

    /**
     * Setter for the trainer tha possesses this card.
     * @param aTrainer Our trainer.
     */
    void setTrainer(Trainer aTrainer);

    /**
     * Sets a card as "played".
     */
    void setPlayed();

    /**
     * Plays this card.
     */
    void play();

    /**
     * Accepts a visitor.
     */
    void accept(Visitor aVisitor);

}
