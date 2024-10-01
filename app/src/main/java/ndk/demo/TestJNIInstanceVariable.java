package ndk.demo;

import androidx.annotation.NonNull;

public class TestJNIInstanceVariable {
    static {
        System.loadLibrary("demo"); // myjni.dll (Windows) or libmyjni.so (Unixes)
    }

    // Instance variables
    private int number = 88;
    private String message = "Hello from Java";

    // Declare a native method that modifies the instance variables
    public native void modifyInstanceVariable();

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("In Java, int is ");
        result.append(number);
        result.append("\nIn Java, message is ");
        result.append(message);
        return result.toString();
    }
}