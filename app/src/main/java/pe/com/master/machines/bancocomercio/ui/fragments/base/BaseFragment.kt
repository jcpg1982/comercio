package pe.com.master.machines.bancocomercio.ui.fragments.base

import androidx.fragment.app.Fragment
import pe.com.master.machines.bancocomercio.di.dependencies.AppComponent
import pe.com.master.machines.bancocomercio.ui.activities.baseActivity.BaseActivity

abstract class BaseFragment : Fragment() {

    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }

    fun getAppComponent(): AppComponent {
        return getBaseActivity().getAppComponent()
    }
}