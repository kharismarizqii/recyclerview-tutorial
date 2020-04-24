package com.kharismarizqii.recyclerviewexample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SuperHero(
    val name: String,
    val desc: String
): Parcelable