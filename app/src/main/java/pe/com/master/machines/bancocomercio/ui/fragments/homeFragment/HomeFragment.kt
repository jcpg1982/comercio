package pe.com.master.machines.bancocomercio.ui.fragments.homeFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pe.com.master.machines.bancocomercio.R
import pe.com.master.machines.bancocomercio.data.resultData.ResultData
import pe.com.master.machines.bancocomercio.databinding.FragmentHomeBinding
import pe.com.master.machines.bancocomercio.ui.adapter.HomeAdapter
import pe.com.master.machines.bancocomercio.ui.fragments.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private var TAG = HomeFragment::class.java.simpleName

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mAdapter: HomeAdapter

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAppComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupRecycler()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getAllUsers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        observer()
    }

    private fun setupRecycler() {
        mAdapter = HomeAdapter(openDetail = { data ->
            Log.d(TAG, "setupRecycler openDetail data: ${data}")
            findNavController().navigate(R.id.homeToDetail, Bundle().apply {
                putParcelable("user", data)
            })
        })
        val mLayoutManager = LinearLayoutManager(requireContext())
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerHome.setHasFixedSize(true)
        binding.recyclerHome.layoutManager = mLayoutManager
        binding.recyclerHome.adapter = mAdapter
    }

    private fun observer() {
        //getAllUsers
        lifecycleScope.launch {
            homeViewModel.getAllUsers.collect {
                when (it) {
                    is ResultData.Loading -> {
                        Log.d(TAG, "observer searchMusic esta cargando: ${it}")
                    }
                    is ResultData.Error -> {
                        Log.d(
                            TAG,
                            "observer searchMusic error: " + it.throwable.message
                        )
                    }
                    is ResultData.Empty -> {
                        Log.d(TAG, "observer searchMusic esta vacio: ")
                    }
                    is ResultData.Success -> {
                        Log.d(TAG, "observer searchMusic creado con exito: ${it.data.size}")
                        mAdapter.setData(it.data)
                    }
                }
            }

        }
    }
}