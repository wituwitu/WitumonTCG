package pokemonTCG;

import pokemonTCG.energies.IEnergy;
import pokemonTCG.pokemon.IPokemon;
import pokemonTCG.pokemon.basic.IBasicPokemon;
import pokemonTCG.pokemon.phase1.IP1Pokemon;
import pokemonTCG.pokemon.phase2.IP2Pokemon;
import pokemonTCG.trainercards.items.EquipItem;
import pokemonTCG.trainercards.items.InstantItem;
import pokemonTCG.trainercards.stadiums.Stadium;
import pokemonTCG.trainercards.supportcards.Support;

public class PlayVisitor extends Visitor {

    @Override
    public void visitBasicPokemon(IBasicPokemon pokemon) {
        Trainer trainer = pokemon.getTrainer();
        trainer.toBench(pokemon);
        pokemon.setPlayed();
    }

    @Override
    public void visitP1Pokemon(IP1Pokemon pokemon) {
        Trainer trainer = pokemon.getTrainer();
        IBasicPokemon current = (IBasicPokemon) trainer.getSelectedPokemon();
        if (current.getID() == pokemon.getPreviousEvolution()) {
            IP1Pokemon newPokemon = current.evolve(pokemon.getID(), pokemon.getName(), pokemon.getInitialHP(), pokemon.getAbilities());
            replace(current, newPokemon);
            pokemon.setPlayed();
        }
    }

    /**
     * Replaces the a pokémon with another one.
     * @param current The pokémon to be replaced.
     * @param newPokemon Its replacement.
     */
    private void replace(IPokemon current, IPokemon newPokemon) {
        Trainer trainer = newPokemon.getTrainer();
        if (current.isActive()) {
            trainer.replaceActivePokemon(newPokemon);
            trainer.selectActivePokemon();
        } else {
            trainer.replaceBenchPokemon(newPokemon);
            trainer.selectBenchPokemon(trainer.getPokeList().indexOf(newPokemon));
        }
    }

    @Override
    public void visitP2Pokemon(IP2Pokemon pokemon) {
        Trainer trainer = pokemon.getTrainer();
        IP1Pokemon current = (IP1Pokemon) trainer.getSelectedPokemon();
        if (current.getID() == pokemon.getPreviousEvolution()) {
            IP2Pokemon newPokemon = current.evolve(pokemon.getID(), pokemon.getName(), pokemon.getInitialHP(), pokemon.getAbilities());
            replace(current, newPokemon);
            pokemon.setPlayed();
        }
    }

    @Override
    public void visitEnergy(IEnergy energy) {
        Trainer trainer = energy.getTrainer();
        if (!energy.isPlayed()) {
            IPokemon pokemon = trainer.getSelectedPokemon();
            pokemon.addToEnergyList(energy);
            energy.setPlayed();
        }
    }

    @Override
    public void visitEquipItem(EquipItem item) {
        Trainer trainer = item.getTrainer();
        IPokemon pokemon = trainer.getSelectedPokemon();
        pokemon.equip(item);
    }

    @Override
    public void visitInstantItem(InstantItem item) {
        Trainer trainer = item.getTrainer();
        IPokemon pokemon = trainer.getSelectedPokemon();
        pokemon.useItem(item);
    }

    @Override
    public void visitStadium(Stadium stadium) {
        stadium.getDriver().setStadium(stadium);
    }

    @Override
    public void visitSupportCard(Support support) {
        if (!support.isPlayed()) {
            support.effect();
        }
    }
}
