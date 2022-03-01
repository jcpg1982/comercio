package pe.com.master.machines.bancocomercio.data.resultData

sealed class ResultData<out T> {

    object First : ResultData<Nothing>()

    data class Loading(val message: String) : ResultData<Nothing>()

    object Empty : ResultData<Nothing>()

    data class Success<out R>(val data: R) : ResultData<R>()

    data class Error(val throwable: Throwable) : ResultData<Nothing>()

}