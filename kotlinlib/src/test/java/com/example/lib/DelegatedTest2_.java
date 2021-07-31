package com.example.lib;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

public class DelegatedTest2_ {
    @Test
    public final void main() {
        BaseImpl b = new BaseImpl(10);
        (new Derived(b)).printMessage();
    }

    public interface Base {
        void printMessage();

        void printMessageLine();
    }

    public static final class BaseImpl implements Base {
        private final int x;

        public BaseImpl(int x) {
            this.x = x;
        }

        @Override
        public void printMessage() {
            System.out.print(this.x);
        }

        @Override
        public void printMessageLine() {
            System.out.println(this.x);
        }

    }

    public static final class Derived implements Base {
        private final Base b;

        @Override
        public void printMessage() {
            String var1 = "abc";
            System.out.println(var1);
        }

        public Derived(@NotNull Base b) {
            this.b = b;
        }

        @Override
        public void printMessageLine() {
            this.b.printMessageLine();
        }
    }
}
