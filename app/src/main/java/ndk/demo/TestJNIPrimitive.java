package ndk.demo;

public class TestJNIPrimitive {
    static {
        System.loadLibrary("demo");
    }

    // Declare a native method average() that receives two ints and return a double containing the average
    public native double average(int n1, int n2);
}
