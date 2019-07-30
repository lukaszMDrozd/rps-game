package com.principium87.rps;

import java.util.*;

public class RpsGame implements RpsChoices{

    private List<String> menu = new ArrayList<>();
    private Integer numberOfRounds;
    private Integer actualRound = 0;

    private boolean end = false;

    public RpsGame(int numberOfRounds){
        setMenu();
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isEnd() {
        return end;
    }

    public void showMenu(){
        System.out.println("**********");
        System.out.println("Menu:");
        System.out.println();
        menu.forEach(System.out::println);
        System.out.println("**********");
        System.out.println();
    }

    public static Integer numberOfRoundsInput(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Zdecyduj do ilu wygranych rund gramy ?:");
            try{
                return sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Nie podałeś liczby wygranych rund");
                sc.nextLine();
            }
        }
    }

    private void setMenu() {
        this.menu.add("klawisz 1 - zagranie \"kamień\"");
        this.menu.add("klawisz 2 - zagranie \"papier\"");
        this.menu.add("klawisz 3 - zagranie \"nożyce\"");
        this.menu.add("klawisz x - zakończenie gry, poprzedzone pytaniem \"Czy na pewno zakończyć grę ?\"");
        this.menu.add("klawisz n - uruchomienie gry od nowa, poprzedzone pytaniem \"Czy na pewno zakończyć aktualną grę ?\"");
    }

    public Integer rpsRound(){

        System.out.println("Rozpoczynamy rundę: " + ++actualRound);
        return actualRound;
    }
}