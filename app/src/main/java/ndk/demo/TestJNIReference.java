package ndk.demo;

public class TestJNIReference {
    static {
        System.loadLibrary("demo"); // myjni.dll (Windows) or libmyjni.so (Unixes)
    }

    // A native method that returns a java.lang.Integer with the given int.
    public native Integer getIntegerObject(int number);

    // Another native method that also returns a java.lang.Integer with the given int.
    public native Integer anotherGetIntegerObject(int number);

}
