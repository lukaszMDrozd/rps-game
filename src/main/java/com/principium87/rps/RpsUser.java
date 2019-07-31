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

    public void setUserScore(Integer score) {
        this.userScore += score;
    }

    private String userNameInput(){
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

    public void resetUserScores(){
        this.userScore = 0;
    }

    public Integer doUserChoice() throws InputMismatchException, ClassCastException{
        Scanner sc = new Scanner(System.in);
        int userInput;
        while (true) {
            try {
                userInput = sc.nextInt();
                try{
                    if(userInput == 1 || userInput == 2 || userInput == 3){
                        return userInput;
                    } else {
                        throw new InputMismatchException("Ruch niezdozwolony!!!, spróbuj raz jeszcze");
                    }
                } catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                }

            } catch (InputMismatchException e) {
                System.out.println("Podaj prawidłowy ruch");
                sc.nextLine();
            }
        }
    }

    public String doUserFinalChoice(){
        Scanner sc = new Scanner(System.in);
        String userInput;
        while(true){
            try {
                userInput = sc.next();
                try{
                    if(userInput.equals("n") || userInput.equals("x")){
                        return userInput;
                    } else {
                        throw new InputMismatchException("Niewłaściwy wybór");
                    }
                } catch(InputMismatchException e){
                    System.out.println(e.getMessage());
                }
            } catch (InputMismatchException e){
                System.out.println("Znak niedozwolony");
                sc.nextLine();
            }
        }
    }

    public boolean doUserFinalChoiceConfirmation(){
        Scanner sc = new Scanner(System.in);
        String userInput;
        while(true){
            try {
                userInput = sc.nextLine();
                try{
                    if(userInput.equals("")){
                        return true;
                    } else {
                        throw new InputMismatchException("Niewłaściwy wybór");
                    }
                } catch(InputMismatchException e){
                    System.out.println(e.getMessage());
                }
            } catch (InputMismatchException e){
                System.out.println("Znak niedozwolony");
                sc.nextLine();
            }
        }
    }
}
