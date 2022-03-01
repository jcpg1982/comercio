package pe.com.master.machines.bancocomercio.ui.fragments.homeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import pe.com.master.machines.bancocomercio.data.model.User
import pe.com.master.machines.bancocomercio.data.repository.DataSourceRemote
import pe.com.master.machines.bancocomercio.data.resultData.ResultData
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val dataSourceRemote: DataSourceRemote) :
    ViewModel() {

    private val _getAllUsers: MutableStateFlow<ResultData<List<User>>> =
        MutableStateFlow(ResultData.First)
    val getAllUsers: StateFlow<ResultData<List<User>>> = _getAllUsers

    fun getAllUsers() {
        viewModelScope.launch {
            dataSourceRemote.getAllUsers()
                .flowOn(Dispatchers.IO)
                .onStart {
                    _getAllUsers.value = ResultData.Loading("Obteniendo la data")
                }
                .catch {
                    _getAllUsers.value = ResultData.Error(it)
                }
                .onEmpty {
                    _getAllUsers.value = ResultData.Empty
                }
                .collect {
                    _getAllUsers.value = ResultData.Success(it)
                }
        }
    }
}