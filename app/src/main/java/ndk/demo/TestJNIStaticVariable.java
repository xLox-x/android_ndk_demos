package ndk.demo;

import androidx.annotation.NonNull;

public class TestJNIStaticVariable {
    static {
        System.loadLibrary("demo"); // nyjni.dll (Windows) or libmyjni.so (Unixes)
    }

    // Static variables
    private static double number = 55.66;

    // Declare a native method that modifies the static variable
    public native void modifyStaticVariable();

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("In Java, int is ");
        result.append(number);
        return result.toString();
    }
}