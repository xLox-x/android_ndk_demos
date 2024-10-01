#include "ndk_demo_TestJNIPrimitive.h"
#include "ndk_utils.h"

JNIEXPORT jdouble JNICALL Java_ndk_demo_TestJNIPrimitive_average
        (JNIEnv *env, jobject thisObj, jint n1, jint n2) {
    jdouble result;
    LOG_D("In C, the numbers are %d and %d\n", n1, n2);
    result = ((jdouble)n1 + n2) / 2.0;
    // jint is mapped to int, jdouble is mapped to double
    return result;
}