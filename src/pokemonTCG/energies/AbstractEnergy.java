package pokemonTCG.energies;

import pokemonTCG.AbstractCard;
import pokemonTCG.types.IType;
import pokemonTCG.Visitor;

/**
 * Generic energy class. Contains the necessary methods to access energy properties.
 * @author Diego S. Wistuba La Torre
 */

public abstract class AbstractEnergy extends AbstractCard implements IEnergy {

    private IType type;

    /**
     * Constructor of an energy card.
     * @param name Name of the energy card
     * @param type Type of the energy card
     */
    public AbstractEnergy(String name, IType type){
        super(name);
        this.type = type;
    }

    //region Properties

    @Override
    public String getCardObject(){return "Energy";}

    @Override
    public IType getType(){
        return this.type;
    }

    //endregion


    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitEnergy(this);
    }

}