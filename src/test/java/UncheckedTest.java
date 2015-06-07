
class Holder<T> {

    T instance;

    void set(T instance) {
        this.instance = instance;
    }

    T get() {
        return instance;
    }

}

public class UncheckedTest {

    public static void main(String[] args) {
        // Without the annotation, this code generates a warning
        // since a raw type is assigned to a parameterized type:
        @SuppressWarnings("unchecked")
        Holder<String> holder1 = createHolder();
    }

    static Holder createHolder() {
        return new Holder();
    }

}

