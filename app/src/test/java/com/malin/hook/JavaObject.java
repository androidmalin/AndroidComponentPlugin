package com.malin.hook;

import org.jetbrains.annotations.NotNull;

public class JavaObject {

    @NotNull
    public Object get(@NotNull String s) {
        return s + "_get";
    }
}
