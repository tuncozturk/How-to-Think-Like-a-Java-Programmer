package playground;

public class StaticVsNonStatic {
    public static void main(String[] args) {
        A a1 = new C();
        a1.foo(); // C.foo
        a1.bar(); // A.bar

        A a2 = new B();
        a2.foo(); // B.foo
        a2.bar(); // A.bar

        A a3 = new A();
        a3.foo(); // A.foo
        a3.bar(); // A.bar

        C c = new C();
        c.foo(); // C.foo
        c.bar(); // C.bar

    }
}
