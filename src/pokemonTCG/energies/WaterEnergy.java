package pokemonTCG.energies;

import pokemonTCG.types.Water;

/**
 * This class defines the logic of a water-type energy card
 */
public class WaterEnergy extends AbstractEnergy {

    /**
     * Constructor for a water-type energy card
     */
    public WaterEnergy(){super("Water Energy", new Water());}

    @Override
    public void play(){
        getTrainer().getActivePokemon().addWaterEnergy(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof WaterEnergy && this.getName().equals(((WaterEnergy) obj).getName());}
}