package pokemonTCG.energies;

import pokemonTCG.types.Psychic;

/**
 * This class defines the logic of a psychic-type energy card
 */
public class PsychicEnergy extends AbstractEnergy {

    /**
     * Constructor for a psychic-type energy card
     */
    public PsychicEnergy(){
        super("Psychic Energy", new Psychic());
    }

    @Override
    public void play(){
        getTrainer().getActivePokemon().addPsychicEnergy(this);
    }

    @Override
    public boolean equals(Object obj) {return obj instanceof PsychicEnergy && this.getName().equals(((PsychicEnergy) obj).getName());}
}