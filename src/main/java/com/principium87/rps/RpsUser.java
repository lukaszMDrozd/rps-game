package com.principium87.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RpsUser implements RpsChoices{

    private String userName;

    public RpsUser(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public static String userNameInput(){
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
}
