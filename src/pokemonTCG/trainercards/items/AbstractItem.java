package pokemonTCG.trainercards.items;

import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.PlayVisitor;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;
import pokemonTCG.trainercards.AbstractTrainerCard;

public abstract class AbstractItem extends AbstractTrainerCard implements IItem {
    private IPokemon pokemon;

    public AbstractItem(String name, String text, Trainer trainer){
        super(name, text, trainer);
    }

    //region Properties

    @Override
    public String getCardObject() { return "Item"; }

    @Override
    public IPokemon getPokemon() { return pokemon; }

    //endregion

    /**
     * Sets the pokemon that possesses this item.
     * @param pokemon The pokemon.
     */
    public void setPokemon(IPokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void play(){
        Visitor playVisitor = new PlayVisitor();
        accept(playVisitor);
    }


}
