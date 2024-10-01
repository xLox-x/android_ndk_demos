package ndk.demo;

public class TestJNIConstructor {
    static {
        System.loadLibrary("demo"); // myjni.dll (Windows) or libmyjni.so (Unixes)
    }

    // Native method that calls back the constructor and return the constructed object.
    // Return an Integer object with the given int.
    public native Integer getIntegerObject(int number);
}
