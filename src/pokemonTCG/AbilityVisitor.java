package pokemonTCG;

import pokemonTCG.abilities.IAbility;
import pokemonTCG.pokemon.IPokemon;

public class AbilityVisitor extends Visitor {

    @Override
    public void visitAttack(IAbility attack) {
        IPokemon pokemon = attack.getPokemon();
        pokemon.attack();
        pokemon.getTrainer().attacks();
    }

    @Override
    public void visitSupport(IAbility support){
        IPokemon pokemon = support.getPokemon();
        support.execute(pokemon);
    }

}
