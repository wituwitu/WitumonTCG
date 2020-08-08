package pokemonTCG.energies;

import pokemonTCG.types.Fighting;

/**
 * This class defines the logic of a fighting-type energy card
 */
public class FightingEnergy extends AbstractEnergy {

    /**
     * Constructor for a fighting-type energy card
     */
    public FightingEnergy(){
        super("Fighting Energy", new Fighting());
    }

    @Override
    public void play(){
        getTrainer().getActivePokemon().addFightingEnergy(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof FightingEnergy && this.getName().equals(((FightingEnergy) obj).getName());}

}