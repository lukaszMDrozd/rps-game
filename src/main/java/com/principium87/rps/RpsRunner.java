package com.principium87.rps;

public class RpsRunner {

    public static void main(String[] args) {

    RpsUser rpsUser = new RpsUser();

    Integer numberOfWinRounds = RpsGame.numberOfWinRoundsInput();
    RpsGame rpsGame = new RpsGame(numberOfWinRounds);
    RpsComputer rpsComputer = new RpsComputer();

    rpsGame.showMenu();

    while(!rpsGame.isEnd()) {

            rpsGame.rpsRound(rpsComputer, rpsUser);
            rpsGame.setEnd(rpsGame.roundStatus(rpsComputer, rpsUser));
            if(rpsGame.isEnd()){
                rpsGame.setEnd(rpsGame.isRpsRoundSummary(rpsComputer, rpsUser));
            }
        }
    }
}
