public class Deadlock {
    /**
     * infer -- javac Deadlock.java
     * infer explore --html
     */
    public class A {
        public synchronized void foo(B b) {
            b.b();
        }

        public synchronized void a() {
        }
    }

    public class B {
        public synchronized void bar(A a) {
            a.a();
        }

        public synchronized void b() {
        }
    }
}
