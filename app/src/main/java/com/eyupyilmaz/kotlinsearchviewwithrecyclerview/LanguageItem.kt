package com.eyupyilmaz.kotlinsearchviewwithrecyclerview

import android.os.Parcel
import android.os.Parcelable

data class LanguageItem(val title:String, val logo:Int, val explain:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(logo)
        parcel.writeString(explain)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LanguageItem> {
        override fun createFromParcel(parcel: Parcel): LanguageItem {
            return LanguageItem(parcel)
        }

        override fun newArray(size: Int): Array<LanguageItem?> {
            return arrayOfNulls(size)
        }
    }
}
