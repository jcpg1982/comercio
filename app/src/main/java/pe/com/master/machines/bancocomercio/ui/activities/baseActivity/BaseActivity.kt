package pe.com.master.machines.bancocomercio.ui.activities.baseActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pe.com.master.machines.bancocomercio.di.dependencies.AppComponent
import pe.com.master.machines.bancocomercio.ui.Application

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun getAppComponent(): AppComponent {
        return (application as Application).getAppComponent()
    }

    fun cleanAppComponent() {
        (application as Application).clearDaggerComponent()
    }
}