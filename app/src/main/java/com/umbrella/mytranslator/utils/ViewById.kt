package com.umbrella.mytranslator.utils

import android.view.View
import kotlin.reflect.KProperty

class ViewById<T : View>(private val view: View, private val id: Int) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return view.findViewById(id) as T
    }
}