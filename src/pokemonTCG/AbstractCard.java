package pokemonTCG;

/**
 * Generic card class. Contains the necessary methods to access card properties.
 * Cards should be, by now, energy cards or pokemon cards.
 * @author Diego S. Wistuba La Torre
 */

public abstract class AbstractCard implements ICard {
    private String name;
    private Trainer trainer;
    private boolean played = false;
    //private Stadium stadium;

    /**
     * Constructor of a card
     * @param name Name of the card
     */
    public AbstractCard(String name){
        this.name = name;
    }

    //region Properties

    /**
     * Getter for the name of the card
     * @return The name of the card
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the category the card is in.
     * @return By now, "Energy", "Pokemon", "Item", "Support" or "Stadium".
     */
    public abstract String getCardObject();

    /**
     * Getter for the trainer that possesses this card.
     * @return The trainer entity.
     */
    public Trainer getTrainer() { return this.trainer; }

    @Override
    public boolean isPlayed() { return played; }

    //endregion

    @Override
    public void setTrainer(Trainer aTrainer) { trainer = aTrainer; }

    @Override
    public void setPlayed() { played = true; }

    @Override
    public void play(){
        Visitor playVisitor = new PlayVisitor();
        accept(playVisitor);
    }

    @Override
    public abstract void accept(Visitor aVisitor);
}
