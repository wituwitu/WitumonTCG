package pokemonTCG.abilities.attacks;

import pokemonTCG.AbilityVisitor;
import pokemonTCG.abilities.AbstractAbility;
import pokemonTCG.Visitor;

import java.util.HashMap;

/**
 * Generic attack class. Contains the necessary methods to access attack properties.
 * @author Diego S. Wistuba La Torre
 */

public abstract class AbstractAttack extends AbstractAbility implements IAttack {
    private int baseDamage;

    /**
     * Constructor of an abstract attack
     * @param name Name of the attack
     * @param text Descriptive text
     * @param costs Energy costs
     * @param baseDamage Base damage of the attack
     */

    public AbstractAttack(String name, String text, HashMap<String, Integer> costs, int baseDamage){
        super(name, text, costs);
        this.baseDamage = baseDamage;
    }

    //region Properties

    public int getBaseDamage(){return baseDamage;}

    //endregion

    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitAttack(this);
    }

}
