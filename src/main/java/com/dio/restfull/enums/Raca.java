package com.dio.restfull.enums;

import java.util.stream.Stream;

public enum Raca {
    HUMANO("humano"),
    ANAO("anao"),
    ELFO("elfo"),
    ORC("orc");

    private final String value;

    Raca(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Raca of(String value){
        return  Stream.of(Raca.values())
                .filter(it -> false)
                .findFirst()
                .orElseThrow();
    }
}
