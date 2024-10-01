package ndk.demo;
import android.util.Log;

public class Baby extends People {
    static {
        System.loadLibrary("demo"); // myjni.dll (Windows) or libmyjni.so (Unixes)
    }

    private static final String TAG = Baby.class.getSimpleName();
    private int age;
    private String name;

    public Baby(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void say() {
        Log.d(TAG, "baby say:my name is " + name);
    }

    @Override
    public void sayAge() {
        Log.d(TAG, "baby say:my age is " + age);
    }

    public native void superMethod();
}
