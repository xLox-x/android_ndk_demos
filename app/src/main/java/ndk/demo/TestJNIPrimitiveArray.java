package ndk.demo;

public class TestJNIPrimitiveArray {
    static {
        System.loadLibrary("demo");
    }
    // Declare a native method sumAndAverage() that receives an int[] and
    //  return a double[2] array with [0] as sum and [1] as average
    public native double[] sumAndAverage(int[] numbers);
}
