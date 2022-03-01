package pe.com.master.machines.bancocomercio.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Geo(
    var lat: String,
    var lng: String
) : Parcelable
