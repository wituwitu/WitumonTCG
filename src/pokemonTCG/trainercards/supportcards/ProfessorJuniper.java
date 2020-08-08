package pokemonTCG.trainercards.supportcards;

import pokemonTCG.Trainer;
public class ProfessorJuniper extends Support{
    public ProfessorJuniper(Trainer trainer){
        super("Professor Juniper", "Discard your hand and draw 7 cards.", trainer);
    }

    /**
     * Executes Professor Juniper. Discards the hand and makes you draw 7 cards.
     */
    public void effect(){
        Trainer trainer = getTrainer();
        trainer.getHand().clear();
        trainer.draw();
        trainer.draw();
        trainer.draw();
        trainer.draw();
        trainer.draw();
        trainer.draw();
        trainer.draw();
    }
}
