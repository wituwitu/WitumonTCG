package pokemonTCG.trainercards.supportcards;

import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.PlayVisitor;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.trainercards.AbstractTrainerCard;

public class Support extends AbstractTrainerCard {

    public Support(String name, String text, Trainer trainer){
        super(name, text, trainer);
    }

    //region Properties

    @Override
    public String getCardObject() { return "Support"; }

    //endregion

    @Override
    public void play(){
        Visitor playVisitor = new PlayVisitor();
        accept(playVisitor);
    }

    /**
     * The effect of the card.
     */
    public void effect(){}

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitSupportCard(this);
    }

}
