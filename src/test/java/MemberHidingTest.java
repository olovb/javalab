
class MyUrBase {

    static int x;

}

class MyBase extends MyUrBase {

    int n;
    static int m;

    static String hello() { return "Hello from base."; }

}

class MyThing extends MyBase {

    static double x;  // Static field hides a static field.

    static double n;  // Static field hides non-static.
    double m;  // Non-static field hides static.

    int getBaseM(boolean useQualified) {
        if (useQualified) {
            return MyBase.m;  // Getting hidden field by the qualified name
        } else {
            return super.m;  // or by using super.
        }
    }

    int getUrBaseX() {
        return MyUrBase.x;
    }

    // The following method may not hide the override-equivalent one
    // in the base class since the former isn't return-type-substitutable
    // for the latter:
    //static int hello() { return 42; }

} 

