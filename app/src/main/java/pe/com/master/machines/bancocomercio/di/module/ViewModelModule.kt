package pe.com.master.machines.bancocomercio.di.module

import dagger.Module
import dagger.Provides
import pe.com.master.machines.bancocomercio.data.repository.DataSourceRemote
import pe.com.master.machines.bancocomercio.data.rest.WebService
import pe.com.master.machines.bancocomercio.ui.fragments.homeFragment.HomeViewModel
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideHomeViewModel(dataSourceRemote: DataSourceRemote): HomeViewModel =
        HomeViewModel(dataSourceRemote)
}