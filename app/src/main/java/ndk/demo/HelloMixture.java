package ndk.demo;

public class HelloMixture {
    static {
        System.loadLibrary("demo"); // hello.dll (Windows) or libhello.so (Unixes)
    }

    // Native method declaration
    public native void sayHelloMixture();
}
