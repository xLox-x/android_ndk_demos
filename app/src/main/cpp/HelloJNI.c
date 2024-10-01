#include "ndk_demo_HelloJNI.h"
#include "ndk_utils.h"

JNIEXPORT void JNICALL Java_ndk_demo_HelloJNI_sayHello
        (JNIEnv *env, jobject obj) {
    LOG_D("Hello NDK C!");
}
