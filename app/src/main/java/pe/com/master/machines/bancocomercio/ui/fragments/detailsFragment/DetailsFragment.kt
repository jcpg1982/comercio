package pe.com.master.machines.bancocomercio.ui.fragments.detailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.com.master.machines.bancocomercio.data.model.User
import pe.com.master.machines.bancocomercio.databinding.FragmentDetailBinding
import pe.com.master.machines.bancocomercio.ui.fragments.base.BaseFragment

class DetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.get("user") as User
        viewDataUser(user)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun viewDataUser(user: User) {
        binding.txtName.text = user.name
        binding.txtPhone.text = user.phone
        binding.txtEmail.text = user.email
        binding.txtUserName.text = user.username
        binding.txtWebsite.text = user.website

        val address = user.address
        binding.txtStreet.text = address.street
        binding.txtSuite.text = address.suite
        binding.txtCity.text = address.city
        binding.txtZipCode.text = address.zipcode

        val geo = address.geo
        binding.txtLat.text = geo.lat
        binding.txtLng.text = geo.lng

        val company = user.company
        binding.txtNameCompany.text = company.name
        binding.txtCatchPhrase.text = company.catchPhrase
        binding.txtBs.text = company.bs

    }
}