#include <jni.h>
#include <string>
#include "ndk_utils.h"

extern "C" JNIEXPORT jstring JNICALL
Java_ndk_demo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    LOG_D("Hello from native");
    return env->NewStringUTF(hello.c_str());
}