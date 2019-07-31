package com.principium87.rps;

import java.util.HashMap;
import java.util.Map;

public interface RpsChoices {

    Map<Integer, String> rpsChoices = new HashMap<>();

    default Map<Integer, String> getRpsChoices(){
        rpsChoices.put(1, "kamień");
        rpsChoices.put(2, "papier");
        rpsChoices.put(3, "nożyce");
        return rpsChoices;
    }
}
