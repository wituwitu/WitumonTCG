package pokemonTCG.energies;

import pokemonTCG.types.Grass;

/**
 * This class defines the logic of a grass-type energy card
 */
public class GrassEnergy extends AbstractEnergy {

    /**
     * Constructor for a grass-type energy card
     */
    public GrassEnergy(){
        super("Grass Energy", new Grass());
    }

    @Override
    public void play(){
        getTrainer().getActivePokemon().addGrassEnergy(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof GrassEnergy && this.getName().equals(((GrassEnergy) obj).getName());}
}