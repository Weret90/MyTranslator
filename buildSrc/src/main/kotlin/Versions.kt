object Versions {
    const val CORE_KTX_VERSION = "1.7.0"
    const val APP_COMPAT_VERSION = "1.4.0"
    const val MATERIAL_VERSION = "1.4.0"
    const val CONSTRAINT_LAYOUT_VERSION = "2.1.2"
    const val LEGACY_SUPPORT_VERSION = "1.0.0"
    const val J_UNIT_VERSION = "4.13.2"
    const val TEST_EXT_J_UNIT_VERSION = "1.1.3"
    const val ESPRESSO_CORE_VERSION = "3.4.0"
    const val RETROFIT_VERSION = "2.9.0"
    const val PICASSO_VERSION = "2.71828"
    const val KOIN_VERSION = "3.1.3"
    const val LIFECYCLE_VIEWMODEL_KTX_VERSION = "2.4.0"
    const val ROOM_VERSION = "2.4.0"
    const val SPLASH_SCREEN_VERSION = "1.0.0-alpha02"
}

object Dependencies {
    const val CORE_KTX_DEP = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
    const val APP_COMPAT_DEP = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val MATERIAL_DEP = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val CONSTRAINT_LAYOUT_DEP =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val LEGACY_SUPPORT_DEP =
        "androidx.legacy:legacy-support-v4:${Versions.LEGACY_SUPPORT_VERSION}"
    const val J_UNIT_DEP = "junit:junit:${Versions.J_UNIT_VERSION}"
    const val TEST_EXT_J_UNIT_DEP = "androidx.test.ext:junit:${Versions.TEST_EXT_J_UNIT_VERSION}"
    const val ESPRESSO_CORE_DEP =
        "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE_VERSION}"

    //retrofit
    const val RETROFIT_DEP = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val RETROFIT_CONVERTER_GSON_DEP =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"

    //picasso
    const val PICASSO_DEP = "com.squareup.picasso:picasso:${Versions.PICASSO_VERSION}"

    //koin
    const val KOIN_CORE_DEP = "io.insert-koin:koin-core:${Versions.KOIN_VERSION}"
    const val KOIN_ANDROID_DEP = "io.insert-koin:koin-android:${Versions.KOIN_VERSION}"

    //coroutines
    const val LIFECYCLE_VIEWMODEL_KTX_DEP =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VIEWMODEL_KTX_VERSION}"

    //Room
    const val ROOM_RUNTIME_DEP = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val ROOM_COMPILER_DEP = "androidx.room:room-compiler:${Versions.ROOM_VERSION}"
    const val ROOM_KTX_DEP = "androidx.room:room-ktx:${Versions.ROOM_VERSION}"

    //splash screen
    const val SPLASH_SCREEN_DEP = "androidx.core:core-splashscreen:${Versions.SPLASH_SCREEN_VERSION}"
}