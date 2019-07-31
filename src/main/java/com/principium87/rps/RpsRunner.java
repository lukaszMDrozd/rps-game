package com.principium87.rps;

public class RpsRunner {

    public static void main(String[] args) {

    RpsUser rpsUser = new RpsUser();

    Integer numberOfRounds = RpsGame.numberOfRoundsInput();
    RpsGame rpsGame = new RpsGame(numberOfRounds);

    RpsComputer rpsComputer = new RpsComputer();

    rpsGame.showMenu();

    System.out.println(rpsGame.getNumberOfRounds());
    System.out.println(rpsUser.getUserName());


    while(!rpsGame.isEnd()) {

            rpsGame.rpsRound(rpsUser, rpsComputer);
            System.out.println(rpsUser.getUserScore());
            System.out.println(rpsComputer.getComputerScore());

        if (rpsUser.getUserScore() == rpsGame.getNumberOfRounds() || (rpsComputer.getComputerScore() == rpsGame.getNumberOfRounds())) {
            rpsGame.setEnd(true);
            System.out.print("Gra zakończona, ");
            }
        }
    }
}
