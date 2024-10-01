package ndk.demo;

public class HelloJNI {  // Save as HelloJNI.java
    static {
        System.loadLibrary("demo"); // Load native library libhello.so
        //  at runtime
        // This library contains a native method called sayHello()
    }

    // Declare an instance native method sayHello() which receives no parameter and returns void
    public native void sayHello();
}