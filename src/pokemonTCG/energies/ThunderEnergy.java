package pokemonTCG.energies;

import pokemonTCG.types.Thunder;

/**
 * This class defines the logic of a thunder-type energy card
 */
public class ThunderEnergy extends AbstractEnergy {

    /**
     * Constructor for a thunder-type energy card
     */
    public ThunderEnergy(){
        super("Thunder Energy", new Thunder());
    }

    @Override
    public void play(){
        getTrainer().getActivePokemon().addThunderEnergy(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof ThunderEnergy && this.getName().equals(((ThunderEnergy) obj).getName());}
}