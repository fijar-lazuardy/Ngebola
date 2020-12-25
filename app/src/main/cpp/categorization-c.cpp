//
// Created by fijar on 24/12/20.
//

#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_id_ac_ui_cs_mobileprogramming_fijar_ngebola_external_AgeCategory_categorizedAge(
        JNIEnv *env, jobject thiz, jint age
        ) {
    if (age > 18) {
        return (jstring) "Adult";
    }
    return (jstring) "Child";
}