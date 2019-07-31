package com.principium87.rps;

import java.util.Random;

public class RpsComputer {
    private Integer computerScore = 0;

    public Integer getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(Integer computerScore) {
        this.computerScore += computerScore;
    }

    public Integer doComputerChoice(){
        return new Random().nextInt(3) + 1;
    }

    public void resetComputerScore(){
        this.computerScore = 0;
    }
}
