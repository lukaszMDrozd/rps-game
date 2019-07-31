package com.principium87.rps;

import java.util.*;

public class RpsGame implements RpsChoices{

    private List<String> menu = new ArrayList<>();
    private Integer numberOfWinRounds;
    private Integer actualRound = 0;
    private boolean end = false;

    public RpsGame(int numberOfWinRounds){
        setMenu();
        this.numberOfWinRounds = numberOfWinRounds;
    }

    public int getNumberOfWinRounds() {
        return numberOfWinRounds;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isEnd() {
        return end;
    }

    public void resetActualRound(){
        this.actualRound = 0;
    }

    public void showMenu(){
        System.out.println("**********");
        System.out.println("Menu:");
        System.out.println();
        getMenu().forEach(System.out::println);
        System.out.println("**********");
        System.out.println();
    }

    public List<String> getMenu() {
        return menu;
    }

    public static Integer numberOfWinRoundsInput(){
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
        this.menu.add("klawisz x - zakończenie gry \"Czy na pewno zakończyć grę ?\"");
        this.menu.add("klawisz n - uruchomienie gry od nowa \"Czy na pewno zakończyć aktualną grę ?\"");
    }

    public void rpsRound(RpsComputer rpsComputer, RpsUser rpsUser){

        System.out.println("Rozpoczynamy rundę: " + ++actualRound);
        System.out.println("Wykonaj ruch");
        String userChoice = getRpsChoices().get(rpsUser.doUserChoice());
        String computerChoice = getRpsChoices().get(rpsComputer.doComputerChoice());

        switch(userChoice + " " + computerChoice){
            case "kamień kamień":
            case "papier papier":
            case "nożyce nożyce":
                System.out.println("Runda zakończona remisem");
                break;
            case "papier kamień ":
            case "kamień nożyce":
            case "nożyce papier":
                {
                rpsUser.setUserScore(1);
                break;
            }
            default :
                {
                rpsComputer.setComputerScore(1);
                break;
            }
        }
    }

    public boolean isRpsRoundSummary(RpsComputer rpsComputer, RpsUser rpsUser){
        System.out.println(getMenu().get(3));
        System.out.println(getMenu().get(4));
        String userFinalChoice = rpsUser.doUserFinalChoice();
        if(userFinalChoice.equals("n")){
            System.out.println("Czy na pewno chcesz zacząć jeszce raz ?");
            doRpsGameReset(rpsComputer, rpsUser);
            return !rpsUser.doUserFinalChoiceConfirmation();
        } else {
            System.out.println("Czy na pewno chcesz zakończyć grę");
            return rpsUser.doUserFinalChoiceConfirmation();
        }
    }

    public void doRpsGameReset(RpsComputer rpsComputer, RpsUser rpsUser){
        rpsComputer.resetComputerScore();
        rpsUser.resetUserScores();
        resetActualRound();
    }

    public boolean roundStatus(RpsComputer rpsComputer, RpsUser rpsUser) {
        if (rpsUser.getUserScore() == getNumberOfWinRounds() || (rpsComputer.getComputerScore() == getNumberOfWinRounds())) {
            System.out.print("Gra zakończona, ");
            if (rpsUser.getUserScore() == getNumberOfWinRounds()) {
                System.out.println("Gratulacje, wygrałeś");
                System.out.println("Twój wynik: " + rpsUser.getUserScore());
                System.out.println("Wynik komputera: " + rpsComputer.getComputerScore());
            } else if (rpsComputer.getComputerScore() == getNumberOfWinRounds()) {
                System.out.println("Wygrał komputer");
                System.out.println("Twój wynik: " + rpsUser.getUserScore());
                System.out.println("Wynik komputera: " + rpsComputer.getComputerScore());
            } return true;
        } else {
            return false;
        }
    }
}
