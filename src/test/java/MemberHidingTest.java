
class MyUrBase {

    static int x;

}

class MyBase extends MyUrBase {

    int n;
    static int m;

    static String hello() { return "Hello base."; }

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

    // The following method may not hide the override-equivalent
    // in the HelloBase class:
    //static int hello() { return 42; }

} 

