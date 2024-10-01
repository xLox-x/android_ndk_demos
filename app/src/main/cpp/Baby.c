//
// Created by james on 9/6/2024.
//
#include "ndk_utils.h"
#include "ndk_demo_Baby.h"

JNIEXPORT void JNICALL Java_ndk_demo_Baby_superMethod (JNIEnv *env, jobject thisObj) {
    // Get a class reference for this object
    jclass thisClass = (*env)->GetObjectClass(env, thisObj);

    // Get the Method ID for method "callback", which takes no arg and return void
    jmethodID midCallBack = (*env)->GetMethodID(env, thisClass, "say", "()V");
    if (NULL == midCallBack) return;
    LOG_D("In C, call back Baby's say()\n");
    // Call back the method (which returns void), baed on the Method ID
    (*env)->CallVoidMethod(env, thisObj, midCallBack);

    // Get parent class: People
    jclass classPeople = (*env)->FindClass(env, "ndk/demo/People");
    jmethodID peopleSay = (*env)->GetMethodID(env, classPeople, "say", "()V");

    LOG_D("In C, call back object's superclass say()\n");
    (*env)->CallNonvirtualVoidMethod(env, thisObj, classPeople, peopleSay);
}

