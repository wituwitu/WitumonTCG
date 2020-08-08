package pokemonTCG.abilities.support;

import pokemonTCG.abilities.AbstractAbility;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.Visitor;

import java.util.HashMap;

public abstract class AbstractSupport extends AbstractAbility implements ISupport {
    public AbstractSupport(String name, String text, HashMap<String, Integer> costs){
        super(name, text, costs);
    }

    //region Properties

    //endregion

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitAttack(this);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof IAbility
                && super.equals(obj)
                && ((IAbility)obj).getCosts().equals(((IAbility) obj).getCosts());
    }
}
