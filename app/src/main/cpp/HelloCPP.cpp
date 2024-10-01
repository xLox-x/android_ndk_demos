//
// Created by james on 9/19/2024.
//
#include "ndk_demo_HelloCPP.h"
#include "ndk_utils.h"

JNIEXPORT void JNICALL Java_ndk_demo_HelloCPP_sayHelloCPP
        (JNIEnv *env, jobject thisObj) {
    LOG_D("Hello NDK C++!");
}