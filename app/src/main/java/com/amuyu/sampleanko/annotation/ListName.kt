package com.amuyu.sampleanko.annotation

import android.support.annotation.StringDef


@Retention(AnnotationRetention.SOURCE)
@StringDef(ListAnnotation.DIALOG,
        ListAnnotation.TOSTS,
        ListAnnotation.CUSTOM,
        ListAnnotation.SELECTORS,
        ListAnnotation.PROGRESS_DIALOG)
annotation class ListName

object ListAnnotation {
    const val DIALOG = "Alert"
    const val TOSTS = "Toasts"
    const val CUSTOM = "CustomAlert"
    const val SELECTORS = "Selectors"
    const val PROGRESS_DIALOG = "ProgressDialog"
}
