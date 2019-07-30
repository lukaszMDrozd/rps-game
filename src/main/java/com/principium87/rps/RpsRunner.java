package com.principium87.rps;

public class RpsRunner {

    public static void main(String[] args) {

    String userName = RpsUser.userNameInput();
    Integer numberOfRounds = RpsGame.numberOfRoundsInput();


    RpsGame rpsGame = new RpsGame(numberOfRounds);
    RpsUser rpsUser = new RpsUser(userName);

    rpsGame.showMenu();

    System.out.println(rpsGame.getNumberOfRounds());
    System.out.println(rpsUser.getUserName());

    while(!rpsGame.isEnd()){
            if(rpsGame.rpsRound() == rpsGame.getNumberOfRounds()){
                rpsGame.setEnd(true);
            }
        }
    }
}
