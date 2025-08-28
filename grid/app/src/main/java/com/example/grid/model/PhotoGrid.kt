package com.example.grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PhotoGrid (
    @DrawableRes val imageResourceId: Int,
    val avaiableCourses: Int,
    @StringRes val stringResourceId: Int
)
