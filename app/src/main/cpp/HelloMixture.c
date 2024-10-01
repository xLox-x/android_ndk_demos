#include "ndk_demo_HelloMixture.h"
#include "HelloJNICppImpl.h"
#include "ndk_utils.h"

JNIEXPORT void JNICALL Java_ndk_demo_HelloMixture_sayHelloMixture
(JNIEnv *env, jobject obj) {
    LOG_D("Hello Mixture!");
    sayHello();
}
