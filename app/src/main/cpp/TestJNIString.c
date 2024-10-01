#include "ndk_utils.h"
#include "ndk_demo_TestJNIString.h"

JNIEXPORT jstring JNICALL Java_ndk_demo_TestJNIString_sayHello
        (JNIEnv *env, jobject thisObj, jstring inJNIStr) {
    // Step 1: Convert the JNI String (jstring) into C-String (char*)
    const char *inCStr = (*env)->GetStringUTFChars(env, inJNIStr, NULL);
    if (NULL == inCStr) return NULL;

    // Step 2: Perform its intended operations

    LOG_D("In C, the received string is: %s\n", inCStr);

    (*env)->ReleaseStringUTFChars(env, inJNIStr, inCStr);  // release resources

    // Prompt user for a C-string
    char outCStr[] = "Hello from native!";

    // Step 3: Convert the C-string (char*) into JNI String (jstring) and return
    return (*env)->NewStringUTF(env, outCStr);
}