package pe.com.master.machines.bancocomercio.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.com.master.machines.bancocomercio.data.model.User
import pe.com.master.machines.bancocomercio.databinding.RowHomeBinding

class HomeAdapter(val openDetail: (user: User) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.viewHolder>() {

    private var mDataList: MutableList<User> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder =
        viewHolder(RowHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false))

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item: User = mDataList.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int = mDataList.size

    fun setData(dataList: List<User>) {
        if (mDataList == null) mDataList = ArrayList()
        mDataList.clear()
        mDataList.addAll(dataList)
        notifyDataSetChanged()
    }

    inner class viewHolder(private val binding: RowHomeBinding) :
        RecyclerView.ViewHolder(binding.getRoot()),
        View.OnClickListener {
        private lateinit var data: User

        fun bind(item: User) {
            data = item
            binding.txtName.text = data.name
            binding.txtEmail.text = data.email
            binding.txtPhone.text = data.phone
            binding.txtWebsite.text = data.website
        }


        override fun onClick(view: View) {
            when (view.getId()) {
                binding.containerRow.id -> {
                    openDetail(data)
                }
            }
        }

        init {
            binding.containerRow.setOnClickListener(this)
        }
    }
}