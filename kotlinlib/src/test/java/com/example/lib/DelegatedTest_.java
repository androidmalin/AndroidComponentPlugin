package com.example.lib;

import org.junit.jupiter.api.Test;

public class DelegatedTest_ {
    @Test
    public final void main() {
        Base b = new BaseImpl(10);
        Derived derived = new Derived(b);
        derived.print();
    }

    public interface Base {
        void print();
    }

    public static final class BaseImpl implements Base {
        private final int x;

        public BaseImpl(int x) {
            this.x = x;
        }

        @Override
        public void print() {
            System.out.println(this.x);
        }
    }

    public static final class Derived implements Base {
        private final Base delegate;

        public Derived(Base b) {
            this.delegate = b;
        }

        @Override
        public void print() {
            this.delegate.print();
        }
    }
}
