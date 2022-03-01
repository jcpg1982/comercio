package pe.com.master.machines.bancocomercio.data.rest

import pe.com.master.machines.bancocomercio.BuildConfig
import pe.com.master.machines.bancocomercio.data.model.User
import retrofit2.http.GET

interface WebService {

    @GET(BuildConfig.ALL_USERS)
    suspend fun getAllUsers(): List<User>
}