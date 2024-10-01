package ndk.demo;

public class TestJNIString {
    static {
        System.loadLibrary("demo");
    }

    // Native method that receives a Java String and return a Java String
    public native String sayHello(String msg);
}

