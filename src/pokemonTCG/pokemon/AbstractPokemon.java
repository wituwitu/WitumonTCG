package pokemonTCG.pokemon;

import pokemonTCG.*;
import pokemonTCG.abilities.IAbility;
import pokemonTCG.abilities.attacks.*;
import pokemonTCG.energies.*;
import pokemonTCG.trainercards.items.EquipItem;
import pokemonTCG.trainercards.items.IItem;
import pokemonTCG.trainercards.items.InstantItem;
import pokemonTCG.types.IType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Generic pokemon class. Contains the necessary methods to attack and get damaged and its properties.
 * @author Diego S. Wistuba La Torre
 */
public abstract class AbstractPokemon extends AbstractCard implements IPokemon {

    private int id;
    private int initialHP;
    private int hp;
    private ArrayList<IAbility> abilityList;
    private IAbility selectedAbility;
    private HashMap<String, Integer> energyList;
    private IType type;
    private int evolvesFrom;
    private EquipItem item;

    /**
     * Constructor of an abstract pokemon
     * @param id Pokemon's pokédex number
     * @param name Name of the pokemon
     * @param hp Initial HP of the pokemon
     * @param abilityList List of abilities of the pokemon
     * @param type Type of the pokémon
     * @param evolvedID ID of the pokémon from which this one evolves from.
     */
    protected AbstractPokemon(int id, String name, int hp, ArrayList<IAbility> abilityList, IType type, int evolvedID, HashMap<String, Integer> energyList, Trainer trainer){
        super(name);
        this.type = type;
        this.id = id;
        this.initialHP = hp;
        this.hp = hp;
        this.abilityList = abilityList;
        this.energyList = new HashMap<>(6);
        this.evolvesFrom = evolvedID;
        this.energyList = energyList;
        this.setTrainer(trainer);
    }

    //region Properties

    @Override
    public int getID(){return id;}

    @Override
    public int getInitialHP(){return initialHP;}

    @Override
    public int getHP(){return hp;}

    @Override
    public String getCardObject(){return "Pokemon";}

    @Override
    public ArrayList<IAbility> getAbilities(){return abilityList;}

    @Override
    public HashMap<String, Integer> getEnergyList(){return energyList;}

    @Override
    public IAbility getSelectedAbility(){return selectedAbility;}

    @Override
    public int getPreviousEvolution(){return evolvesFrom;}

    @Override
    public IType getType(){
        return this.type;
    }

    @Override
    public IItem getItem() { return item; }

    //endregion

    /**
     * Modifies the HP of our pokémon.
     * @param newHP The new HP of the pokémon.
     */
    @Override
    public void setHP(int newHP){
        this.hp = newHP;
    }

    /**
     * Sets the energy list of this pokémon.
     * @param newEnergies The energies to be setted.
     */
    public void setEnergyList(HashMap<String, Integer> newEnergies){
        this.energyList = newEnergies;
    }

    @Override
    public void addAbility(IAbility ability){
        if (abilityList.size() >= 4){
            return;
        }
        abilityList.add(ability);
    }

    @Override
    public void selectAbility(int index){
        selectedAbility = abilityList.get(index);
    }

    @Override
    public void useAbility(IPokemon target){
        selectedAbility.setPokemon(this);
        selectedAbility.setTarget(target);
        HashMap<String, Integer> available = this.getEnergyList();
        selectedAbility.setStatus(available);
        if (!selectedAbility.isBlocked()) {
            for (String energy : selectedAbility.getCosts().keySet()){
                int diff = available.get(energy) - selectedAbility.getCosts().get(energy);
                getEnergyList().replace(energy, diff);
            }
            selectedAbility.activate();
        }
    }

    /*
    public void attack(){
        this.selectedAbility.getTarget().receiveAttack(this.getSelectedAbility());
    }
    */

    @Override
    public void receiveGrassAttack(GrassAttack attack){
        receiveAttack(attack);
    }

    @Override
    public void receiveFireAttack(FireAttack attack){
        receiveAttack(attack);
    }

    @Override
    public void receiveWaterAttack(WaterAttack attack){
        receiveAttack(attack);
    }

    @Override
    public void receiveThunderAttack(ThunderAttack attack){
        receiveAttack(attack);
    }

    @Override
    public void receiveFightingAttack(FightingAttack attack){
        receiveAttack(attack);
    }


    @Override
    public void receivePsychicAttack(PsychicAttack attack){
        receiveAttack(attack);
    }

    @Override
    public void receiveAttack(IAttack attack){
        this.hp -= attack.getBaseDamage();
    }

    @Override
    public void receiveWeaknessAttack(IAttack attack){
        this.hp -= attack.getBaseDamage()*2;
    }

    @Override
    public void receiveResistantAttack(IAttack attack){
        int delta = attack.getBaseDamage() - 30;
        this.hp = (delta < 0) ? this.hp : this.hp - delta;
    }

    @Override
    public void addToEnergyList(IEnergy energy){
        String type = energy.getType().getTypeName();
        int currentNumber = energyList.get(type);
        energyList.replace(type, currentNumber + 1);
    }

    @Override
    public void addFightingEnergy(FightingEnergy energy){
        addToEnergyList(energy);
    }

    @Override
    public void addFireEnergy(FireEnergy energy){
        addToEnergyList(energy);
    }

    @Override
    public void addGrassEnergy(GrassEnergy energy){
        addToEnergyList(energy);
    }

    @Override
    public void addPsychicEnergy(PsychicEnergy energy){
        addToEnergyList(energy);
    }

    @Override
    public void addThunderEnergy(ThunderEnergy energy){
        addToEnergyList(energy);
    }

    @Override
    public void addWaterEnergy(WaterEnergy energy){
        addToEnergyList(energy);
    }

    @Override
    public boolean isDead(){
        return this.getHP() <= 0;
    }

    /*
    @Override
    public void accept(Visitor aVisitor){
        aVisitor.visitPokemon(this);
    }
    */

    @Override
    public boolean isActive(){
        return this.equals(getTrainer().getActivePokemon());
    }

    @Override
    public void equip(EquipItem item){
        if (this.item == null) {
            this.item = item;
            item.setPokemon(this);
            item.setTrainer(this.getTrainer());
        }
    }

    @Override
    public void useItem(InstantItem item){
        item.setPokemon(this);
        item.effect();
    }

    @Override
    public boolean isEvolved(){
        return getPreviousEvolution() != 0;
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof IPokemon
                && ((IPokemon) obj).getName().equals(this.getName())
                && ((IPokemon) obj).getType().getTypeName().equals(this.getType().getTypeName());
    }
}
