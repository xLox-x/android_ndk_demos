#include "ndk_utils.h"
#include "ndk_demo_TestJNIInstanceVariable.h"

JNIEXPORT void JNICALL Java_ndk_demo_TestJNIInstanceVariable_modifyInstanceVariable
        (JNIEnv *env, jobject thisObj) {
    // Get a reference to this object's class
    jclass thisClass = (*env)->GetObjectClass(env, thisObj);

    // int
    // Get the Field ID of the instance variables "number"
    jfieldID fidNumber = (*env)->GetFieldID(env, thisClass, "number", "I");
    if (NULL == fidNumber) return;

    // Get the int given the Field ID
    jint number = (*env)->GetIntField(env, thisObj, fidNumber);
    LOG_D("In C, the int is %d\n", number);

    // Change the variable
    number = 99;
    (*env)->SetIntField(env, thisObj, fidNumber, number);

    // Get the Field ID of the instance variables "message"
    jfieldID fidMessage = (*env)->GetFieldID(env, thisClass, "message", "Ljava/lang/String;");
    if (NULL == fidMessage) return;

    // String
    // Get the object given the Field ID
    jstring message = (*env)->GetObjectField(env, thisObj, fidMessage);

    // Create a C-string with the JNI String
    const char *cStr = (*env)->GetStringUTFChars(env, message, NULL);
    if (NULL == cStr) return;

    LOG_D("In C, the string is %s\n", cStr);
    (*env)->ReleaseStringUTFChars(env, message, cStr);

    // Create a new C-string and assign to the JNI string
    message = (*env)->NewStringUTF(env, "Hello from C");
    if (NULL == message) return;

    // modify the instance variables
    (*env)->SetObjectField(env, thisObj, fidMessage, message);
}

