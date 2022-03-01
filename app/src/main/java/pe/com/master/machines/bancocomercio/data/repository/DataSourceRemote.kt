package pe.com.master.machines.bancocomercio.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.com.master.machines.bancocomercio.data.model.User
import pe.com.master.machines.bancocomercio.data.rest.WebService
import javax.inject.Inject

class DataSourceRemote @Inject constructor(val webService: WebService) {

    suspend fun getAllUsers(): Flow<List<User>> {
        return flow {
            val result = webService.getAllUsers()
            emit(result)
        }
    }
}