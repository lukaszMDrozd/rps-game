package com.principium87.rps;

public class RpsComputer {
    private Integer computerScore = 0;

    public Integer getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(Integer computerScore) {
        this.computerScore += computerScore;
    }
}
