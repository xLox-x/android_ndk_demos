//
// Created by james on 9/11/2024.
//

#ifndef NDK_DEMO_NDK_UTILS_H
#define NDK_DEMO_NDK_UTILS_H
#include <android/log.h>

#define TAG "ndk_log"
#define LOG_D(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__);

#endif //NDK_DEMO_NDK_UTILS_H
