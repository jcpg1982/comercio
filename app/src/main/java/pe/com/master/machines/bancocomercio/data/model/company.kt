package pe.com.master.machines.bancocomercio.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class company(
    var name: String,
    var catchPhrase: String,
    var bs: String
) : Parcelable
