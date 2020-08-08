package pokemonTCG.energies;

import pokemonTCG.types.Fire;

/**
 * This class defines the logic of a fire-type energy card
 */
public class FireEnergy extends AbstractEnergy {

    /**
     * Constructor for a fire-type energy card
     */
    public FireEnergy(){
        super("Fire Energy", new Fire());
    }

    @Override
    public void play(){
        getTrainer().getActivePokemon().addFireEnergy(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof FireEnergy && this.getName().equals(((FireEnergy) obj).getName());}

}