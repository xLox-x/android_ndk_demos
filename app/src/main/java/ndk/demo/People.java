package ndk.demo;

import android.util.Log;

public class People {
    private static final String TAG = People.class.getSimpleName();

    public void say() {
        Log.d(TAG, "people say");
        sayAge();
    }

    public void sayAge() {
        Log.d(TAG, "people say age");
    }
}


