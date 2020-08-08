package pokemonTCG.trainercards.items;

import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.Trainer;
import pokemonTCG.Visitor;

public class EquipItem extends AbstractItem {

    public EquipItem(String name, String text, Trainer trainer){
        super(name, text, trainer);
    }

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitEquipItem(this);
    }

}
