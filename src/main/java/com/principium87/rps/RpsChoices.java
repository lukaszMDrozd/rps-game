package com.principium87.rps;

import java.util.HashMap;
import java.util.Map;

public interface RpsChoices {

    default void setRpsChoices(){

        final Map<String, Integer> rpsChoices = new HashMap<>();
        rpsChoices.put("kamień", 1);
        rpsChoices.put("papier", 2);
        rpsChoices.put("nożyce", 3);
    }
}
