package pokemonTCG.abilities.support;

import pokemonTCG.*;
import pokemonTCG.pokemon.IPokemon;

import java.util.HashMap;

public class EnergyBurn extends AbstractSupport {

    public EnergyBurn(){
        super("Energy Burn", "Every energy of the pokémon is converted to its type.", null);

        HashMap<String, Integer> actualCosts = new HashMap<>();
        actualCosts.put("Grass", 1);
        actualCosts.put("Fire", 3);
        actualCosts.put("Water", 1);
        actualCosts.put("Fighting", 1);
        actualCosts.put("Thunder", 1);
        actualCosts.put("Psychic", 1);

        setCosts(actualCosts);

    }

    /**
     * Executes Energy Burn.
     * All the energies of the pokémon are converted to the type of the pokémon.
     */
    @Override
    public void execute(IPokemon pokemon){
        String type = pokemon.getType().getTypeName();
        HashMap<String, Integer> energyList = pokemon.getEnergyList();
        int energyCount = 0;
        for (String energy : energyList.keySet()){
            energyCount += energyList.get(energy);
            energyList.replace(energy, 0);
        }
        energyList.put(type, energyCount);
    }


    public void accept(Visitor aVisitor){
        aVisitor.visitSupport(this);
    }
}
