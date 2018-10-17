package com.pro.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get().getA();
    }

}
