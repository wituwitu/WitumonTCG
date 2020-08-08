# Pokémon TCG (part 2)

This is an intermediate implementation for the game mechanics of the Pokémon TCG. It currently has no way of being played other than creating tests for the methods of each class.

There currently exsist 6 types for each Pokémon, energy card and attacks: Grass, Water, Fire, Fighting, Psychic and Thunder.

For the part 2, there have been added a lot of new features: More trainer abilities, pokémon evolutions, new pokémon abilities, trainer cards (items, stadiums, supports) and the new main class of the project: The Driver.

This main class, Driver (not to be confused with _main method_) controls the game mechanics: It is capable of simulating a turn between two trainers. An explicit simulation is yet to be created, but all of its methods can be used to do so.

There have been used various design patterns in this project, namely Double Dispatch, Observer and Visitor. In the first part the main code design pattern used was Double Dispatch, being applied to interactions between instances of pokémon (attacks), the use of energy cards by the trainer, being hurt by an attack of many types, etc. The Observer pattern was used for the Driver class, being in need of knowing when a trainer chooses to end a turn (or makes its pokémon attack, instantly ending the turn). The Visitor pattern was used for disambiguating the classes of the cards that are going to be played, so that the trainer may only care about playing a card without asking for its class, and the class of the ability that is executed, so that the pokémon may only care about executing an ability without asking for its class.

##Specific features

This project has implemented various specific features: Pokémon abilities, attacks, items, stadiums and support cards. The explanation of every feature and the tests that were made to try them are listed below.

* *Ability: Energy Burn*. All the energies of a pokémon are converted to the type of the pokémon. Tested in `tests\TestAbilities:testEnergyBurn()`.
* *Attack: Electric Shock*. Toss a coin. If it's tails, the target gets 25 damage. Tested in `tests\TestAbilities:testEnergyShock()`. This is a non-deterministic ability, so the tests ensure that the ability doesn't change parameters that it shouldn't.
* *Item: Potion*. Recover 10 HP. Tested in `tests\TestAbilities:testPotion()`.
* *Stadium: Training Center*. Every phase 1 or 2 pokémon gets +50 HP. Tested in `tests\TestStadium:testTrainingCenter`.
* *Support: Professor Juniper*. Discard your hand and draw 7 cards. Tested in `tests\TestSupport:testProfessorJuniper`

## Getting started

If you have access to this repository, you can download this version of the game simply by the `git clone` command:

```
git clone github.com/wituwitu/cc3002-tarea2.git
```

## Running the tests

This project makes use of JUnit to build tests that assure the correct functioning of the methods implemented. To run them (in IntelliJ IDEA) right-click the tests package in the explorer and select "Run 'All Tests' with Coverage".

The tests currently show to cover 100% of the classes and 95% of the lines.

## Built with

* IntelliJ IDEA for coding.

## Author

* Diego S. Wistuba La Torre

## Acknowledgements

* Fedora tip to Ignacio Slater, whose Pokémon Combat code was used as an inspiration to start this project. He also has been very helpful during the realization of the project with everyone. Thank you!