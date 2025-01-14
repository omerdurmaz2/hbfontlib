package com.devomer.hbfontlib

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface

public class FontProvider private constructor(private val context: Context) {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: FontProvider? = null

        fun getInstance(context: Context): FontProvider {
            return instance ?: synchronized(this) {
                instance ?: FontProvider(context.applicationContext).also { instance = it }
            }
        }
    }

    fun getInterBlack(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_black.ttf")
    }

    fun getInterBold(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_bold.ttf")
    }

    fun getInterExtraBold(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_extra_bold.ttf")
    }

    fun getInterExtraLight(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_extra_light.ttf")
    }

    fun getInterLight(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_light.ttf")
    }

    fun getInterMedium(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_medium.ttf")
    }

    fun getInterRegular(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_regular.ttf")
    }

    fun getInterSemiBold(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_semi_bold.ttf")
    }

    fun getInterThin(): Typeface {
        return Typeface.createFromAsset(context.assets, "font/inter_thin.ttf")
    }
}
