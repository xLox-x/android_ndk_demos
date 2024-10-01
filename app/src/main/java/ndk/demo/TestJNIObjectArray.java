package ndk.demo;

public class TestJNIObjectArray {
    static {
        System.loadLibrary("demo"); // myjni.dll (Windows) or libmyjni.so (Unixes)
    }
    // Native method that receives an Integer[] and
    //  returns a Double[2] with [0] as sum and [1] as average
    public native Double[] sumAndAverage(Integer[] numbers);
}
