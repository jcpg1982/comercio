package pe.com.master.machines.bancocomercio.di.dependencies

import dagger.Component
import pe.com.master.machines.bancocomercio.di.module.AppModule
import pe.com.master.machines.bancocomercio.di.module.NetModule
import pe.com.master.machines.bancocomercio.di.module.ViewModelModule
import pe.com.master.machines.bancocomercio.ui.fragments.homeFragment.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AppModule::class,
        NetModule::class,
        ViewModelModule::class
    )
)
interface AppComponent {

    fun inject(fragment: HomeFragment)
}