package pokemonTCG.abilities.attacks;

import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.Visitor;

import java.util.HashMap;

public class ElectricShock extends AbstractAttack{


    public ElectricShock(){
        super("Electric Shock", "Toss a coin. If it's tails, the target gets 25 damage.", null, 25);
        HashMap<String, Integer> actualCosts = new HashMap<>();
        actualCosts.put("Thunder", 4);
        setCosts(actualCosts);

    }

    /**
     * Executes Electric Shock
     * Toss a coin. If it's tails, the target gets 25 damage.
     * @param pokemon Target of the attack.
     */
    @Override
    public void execute(IPokemon pokemon){

        boolean tails;

        if (!this.isBlocked()) {
            System.out.println("Toss a coin!");
            tails = !(Math.random() < 0.5);
            if (tails) {
                System.out.println("It's tails!");
                pokemon.receiveAttack(this);
            } else {
                System.out.println("It's heads.");
            }
        }
    }

    @Override
    public void activate(){
        execute(this.getTarget());
    }


    public void accept(Visitor aVisitor){
        aVisitor.visitAttack(this);
    }
}
