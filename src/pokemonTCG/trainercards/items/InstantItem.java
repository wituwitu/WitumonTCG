package pokemonTCG.trainercards.items;

import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.trainercards.items.AbstractItem;

public class InstantItem extends AbstractItem {

    public InstantItem(String name, String text, Trainer trainer){
        super(name, text, trainer);
    }

    public void accept(Visitor aVisitor){
        aVisitor.visitInstantItem(this);
    }

    /**
     * The effect of the card.
     */
    public void effect(){}
}
