package pokemonTCG.abilities;

import pokemonTCG.AbilityVisitor;
import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.Visitor;

import java.util.HashMap;

/**
 * Generic ability class. Contains the necessary methods to access ability properties.
 * @author Diego S. Wistuba La Torre
 */

public abstract class AbstractAbility implements IAbility {

    private String name;
    private String text;
    private HashMap<String, Integer> costs;
    private IPokemon pokemon;
    private IPokemon target;
    protected boolean blocked = false;

    /**
     * Constructor of an abstract ability
     * @param name Name of the ability
     * @param text Descriptive text
     * @param costs Energy cost of the ability
     */
    public AbstractAbility(String name, String text, HashMap<String, Integer> costs){
        this.name = name;
        this.text = text;
        this.costs = costs;
    }

    //region Properties

    @Override
    public String getName(){return name;}

    @Override
    public String getText(){return text;}

    @Override
    public HashMap<String, Integer> getCosts() {
        return costs;
    }

    @Override
    public IPokemon getPokemon() { return pokemon; }

    @Override
    public IPokemon getTarget() { return target; }

    @Override
    public boolean isBlocked() { return blocked; }

    //endregion

    @Override
    public void setStatus(HashMap<String, Integer> energyList){
        for (String key: costs.keySet()) {
            int cost = costs.get(key);
            Integer actualNumber = energyList.get(key);
            int delta = actualNumber - cost;
            if (delta < 0) {
                this.blocked = true;
                break;
            } else {
                this.blocked = false;
            }
        }
    }

    @Override
    public void setCosts(HashMap<String, Integer> costs){
        this.costs = costs;
    }

    @Override
    public void setPokemon(IPokemon pokemon){
        this.pokemon = pokemon;
    }

    @Override
    public void setTarget(IPokemon pokemon){
        this.target = pokemon;
    }

    @Override
    public void activate(){
        Visitor abilityVisitor = new AbilityVisitor();
        accept(abilityVisitor);
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof IAbility
                && ((IAbility)obj).getName().equals(name)
                && ((IAbility)obj).getText().equals(text)
                && ((IAbility)obj).getCosts().equals(costs);
    }
}
