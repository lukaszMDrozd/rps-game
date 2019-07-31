package com.principium87.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RpsUser implements RpsChoices{

    private String userName;
    private Integer userScore = 0;

    public RpsUser(){
        this.userName = userNameInput();
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore += userScore;
    }

    public String userNameInput(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Witaj w grze - podaj swoje Imię:");
            try{
                return sc.nextLine();
            }catch (InputMismatchException e){
                sc.nextLine();
            }
        }
    }

    public Integer doUserChoice(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wykonałeś nieprawidłowy ruch");
                sc.nextLine();
            }
        }
    }
}
