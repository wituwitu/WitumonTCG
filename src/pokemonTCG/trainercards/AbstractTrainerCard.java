package pokemonTCG.trainercards;

import pokemonTCG.AbstractCard;
import pokemonTCG.Trainer;

public abstract class AbstractTrainerCard extends AbstractCard {
    private String text;

    public AbstractTrainerCard(String name, String text, Trainer trainer){
        super(name);
        this.text = text;
        this.setTrainer(trainer);
    }

}
