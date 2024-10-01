//
// Created by james on 9/6/2024.
//
#include "ndk_utils.h"
#include "ndk_demo_TestJNIStaticVariable.h"

JNIEXPORT void JNICALL Java_ndk_demo_TestJNIStaticVariable_modifyStaticVariable
(JNIEnv *env, jobject thisObj) {
    // Get a reference to this object's class
    jclass cls = (*env)->GetObjectClass(env, thisObj);

    // Read the int static variable and modify its value
    jfieldID fidNumber = (*env)->GetStaticFieldID(env, cls, "number", "D");
    if (NULL == fidNumber) return;
    jdouble number = (*env)->GetStaticDoubleField(env, cls, fidNumber);
    LOG_D("In C, the double is %f\n", number);
    number = 77.88;
    (*env)->SetStaticDoubleField(env, cls, fidNumber, number);
}