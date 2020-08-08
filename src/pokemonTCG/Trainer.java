package pokemonTCG;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.trainercards.items.IItem;
import pokemonTCG.trainercards.stadiums.Stadium;
import pokemonTCG.trainercards.stadiums.TrainingCenter;
import pokemonTCG.trainercards.supportcards.Support;
import pokemonTCG.types.IType;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Class for the trainer.
 * Contains the necessary methods to perform the basic actions a pokemon trainer should do.
 */
public class Trainer extends Observable {
    private ArrayList<ICard> deck;
    private ArrayList<ICard> hand;
    private ArrayList<ICard> cemetery;
    private ArrayList<ICard> prizeCards;
    private ArrayList<IPokemon> pokeList;
    private IPokemon activePokemon;
    private ICard selectedCard;
    private IPokemon selectedPokemon;
    private Stadium stadium;

    /**
     * Constructor of a new pokemon trainer
     */
    public Trainer() {
        deck = new ArrayList<>(60);
        hand = new ArrayList<>();
        cemetery = new ArrayList<>();
        pokeList = new ArrayList<>(5);
        prizeCards = new ArrayList<>(6);
    }

    //region Properties

    /**
     * Getter for the card deck.
     *
     * @return The card deck
     */
    public ArrayList<ICard> getDeck() {
        return deck;
    }

    /**
     * Getter for the hand.
     *
     * @return The card deck
     */
    public ArrayList<ICard> getHand() {
        return hand;
    }

    /**
     * Getter for the stadium card.
     *
     * @return The stadium card
     */
    public Stadium getStadium() {
        return stadium;
    }

    /**
     * Getter for the list of pokemon in the bench
     *
     * @return List of pokemon in the bench
     */
    public ArrayList<IPokemon> getPokeList() {
        return pokeList;
    }

    /**
     * Getter for the active pokemon.
     *
     * @return Active pokemon
     */
    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    /**
     * Getter for the information of the i-th card of the deck.
     *
     * @param i The index of the card
     * @return String containing the information of the card
     */
    public String getCard(int i) {
        ICard card = deck.get(i);
        return i + ". Name: " + card.getName() + "; Object: " + card.getCardObject();
    }

    /**
     * Getter for the cemetery array of cards.
     *
     * @return The cemetery.
     */
    public ArrayList<ICard> getCemetery() {
        return cemetery;
    }

    /**
     * Getter for the selected pokémon.
     *
     * @return The selected pokémon.
     */
    public IPokemon getSelectedPokemon() {
        return selectedPokemon;
    }

    /**
     * Getter for the list of prize cards.
     *
     * @return Prize cards.
     */

    public ArrayList<ICard> getPrizeCards() {
        return prizeCards;
    }

    //endregion

    /**
     * Setter for the stadium card.
     */
    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    /**
     * Add (create) a new energy card to the deck
     *
     * @param type
     */
    public void newEnergy(IType type) {
        deck.add(type.generateEnergy());
    }

    /**
     * Add (create) a new item card to the deck
     */
    public void newItem(IItem item) {
        deck.add(item);
    }

    /**
     * Add (create) a new support card to the deck
     */
    public void newSupport(Support support){
        deck.add(support);
    }

    /**
     * Add (create) a new pokemon card to the deck
     * @param type Type of the pokemon
     * @param id Pokemon's pokedex number
     * @param name Pokemon's name
     * @param hp Pokemon's initial HP
     * @param abilityList Pokemon's list of abilities
     */
    public void newBasicPokemon(IType type, int id, String name, int hp, ArrayList<IAbility> abilityList){
        deck.add(type.generateBasicPokemon(id, name, hp, abilityList));
    }

    /**
     * Add (create) a new phase-one pokémon to the deck.
     * @param type Type of the pokémon
     * @param id Pokémon's pokédex number
     * @param name Pokémon's name
     * @param hp Pokémon's initial HP
     * @param abilityList Pokémon's list of abilities
     * @param evolvedID ID of the pre-evolution of this pokémon
     */
    public void newP1Pokemon(IType type, int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        deck.add(type.generateP1Pokemon(id, name, hp, abilityList, evolvedID));
    }

    /**
     * Add (create) a new phase-two pokémon to the deck.
     * @param type Type of the pokémon
     * @param id Pokémon's pokédex number
     * @param name Pokémon's name
     * @param hp Pokémon's initial HP
     * @param abilityList Pokémon's list of abilities
     * @param evolvedID ID of the pre-evolution of this pokémon
     */
    public void newP2Pokemon(IType type, int id, String name, int hp, ArrayList<IAbility> abilityList, int evolvedID){
        deck.add(type.generateP2Pokemon(id, name, hp, abilityList, evolvedID));
    }

    /**
     * Draws a card from the deck to the hand.
     */
    public void draw(){
        hand.add(deck.get(0));
        deck.remove(0);
    }

    /**
     * Sends a pokemon to the bench. The bench can only contain 5 pokemon.
     * @param pokemon The pokemon to be added to the bench
     */
    public void toBench(ICard pokemon){
        if (pokeList.size() < 5) {
            pokeList.add((IPokemon) pokemon);
            hand.remove(pokemon);
        }
    }

    /**
     * Activates a pokemon and puts them ready to fight.
     */
    public void activatePokemon(){
        activePokemon = pokeList.get(0);
        pokeList.remove(0);
    }

    /**
     * Selects a pokémon from the bench.
     * @param index Index of the pokémon to be selected.
     */
    public void selectBenchPokemon(int index){
        selectedPokemon = pokeList.get(index);
    }

    /**
     * Selects the active pokémon.
     */
    public void selectActivePokemon(){
        selectedPokemon = getActivePokemon();
    }

    /**
     * Selects a card from the hand of the trainer.
     * @param index Index of the card to be selected.
     */
    public void selectCard(int index) { selectedCard = hand.get(index); }

    /**
     * Activates a pokemon that is not the first one in the bench.
     * Note that activateBenchPokemon(0) equals activatePokemon().
     * This method has been used only for testing so far.
     * @param index Index of the pokemon to be activated
     */

    public void activateBenchPokemon(int index){
        selectBenchPokemon(index);
        activePokemon = selectedPokemon;
        pokeList.remove(selectedPokemon);
    }


    /**
     * Check whether the active pokemon is still fighting or defeated.
     */
    public void checkActivePokemon(){
        if (activePokemon.isDead()){
            toCemetery(activePokemon);
            activePokemon = null;
            activatePokemon();
        }
    }

    /**
     * Play a card.
     */
    public void play(){
        selectedCard.setTrainer(this);
        selectedCard.play();
        hand.remove(selectedCard);
    }

    /**
     * Selects an ability from the ability list of the active pokémon.
     * @param index Index of the ability in the ability list.
     */
    public void selectAbility(int index){
        activePokemon.selectAbility(index);
        activePokemon.getSelectedAbility().setPokemon(getActivePokemon());
    }

    /**
     * Throws a card into the cemetery.
     * @param card The card that will no longer be used.
     */
    public void toCemetery(ICard card) {
        cemetery.add(card);
    }

    /**
     * Replaces a bench pokemon with another one.
     * @param anotherPokemon The new pokémon.
     */
    public void replaceBenchPokemon(IPokemon anotherPokemon) {
        int index = pokeList.indexOf(selectedPokemon);
        pokeList.remove(selectedPokemon);
        pokeList.add(index, anotherPokemon);
    }

    /**
     * Replaces the active pokémon with another one.
     * @param anotherPokemon The new pokémon.
     */
    public void replaceActivePokemon(IPokemon anotherPokemon) {
        activePokemon = anotherPokemon;
    }

    /**
     * Notifies the observer that an attack has been executed, ending the turn.
     */
    public void attacks(){
        setChanged();
        notifyObservers(true);
    }

    /**
     * Ends the turn notifying the observer.
     */
    public void endTurn(){
        setChanged();
        notifyObservers(true);
    }

    /**
     * Adds (creates) a new stadium card to the deck.
     * @param stadium The stadium.
     */
    public void newStadium(Stadium stadium) {
        deck.add(stadium);
    }
}
