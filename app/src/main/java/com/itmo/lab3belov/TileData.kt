package com.itmo.lab3belov

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TileData(val title: String, @DrawableRes val imageAndroid: Int, @DrawableRes val poster: Int, val desc: String, val relDate: String, val link: String) :
    Parcelable