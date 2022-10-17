package com.msy.enerjisaabonelik.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.msy.enerjisaabonelik.R
import com.msy.enerjisaabonelik.databinding.FragmentSubscriptionMenuBinding
import com.msy.enerjisaabonelik.util.LoadingDialog
import com.msy.enerjisaabonelik.util.ViewUtil
import com.msy.enerjisaabonelik.viewmodel.SubscriptionMenuViewModel


class SubscriptionMenu : Fragment() {

    private var _binding: FragmentSubscriptionMenuBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SubscriptionMenuViewModel

    private val subscriptionMenuChoiceLayout: LinearLayout by lazy { binding.subscriptionMenuChoiceLayout }

    private val processButtonOne: Button by lazy { binding.subscriptionProcessButtonOne }
    private val processButtonTwo: Button by lazy { binding.subscriptionProcessButtonTwo }
    private val processButtonThree: Button by lazy { binding.subscriptionProcessButtonThree }
    private val processButtonFour: Button by lazy { binding.subscriptionProcessButtonFour }

    private val loadingDialog = LoadingDialog()
    private val viewUtil = ViewUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(SubscriptionMenuViewModel::class.java)
        viewModel.loadMenu()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubscriptionMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        goToSubscriptionFragment()

        return view
    }

    override fun onStart() {
        super.onStart()
        loadingDialog.show(activity, "Lütfen Bekleyiniz...")
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.data.observe(this) { data ->
            data?.let {
                Log.d("bilgi", data.toString())
                if (!data.equals(null)) {
                    subscriptionMenuChoiceLayout.visibility = View.VISIBLE
                    loadingDialog.dismiss()
                    processButtonOne.text = data.result?.resultObject?.get(0)?.value ?: ""
                    processButtonTwo.text = data.result?.resultObject?.get(1)?.value ?: ""
                    processButtonThree.text = data.result?.resultObject?.get(2)?.value ?: ""
                    processButtonFour.text = data.result?.resultObject?.get(3)?.value ?: ""
                } else {
                    loadingDialog.dismiss()
                    viewUtil.showCustomDialog(
                        activity,
                        "Hata",
                        "Bir hata oluştu. Lütfen tekrar deneyiniz.",
                        "Yeniden Dene",
                        "Tamam",
                        { observeLiveData() },
                        { },
                    )
                }
            }

        }
    }

    private fun goToSubscriptionFragment() {
        processButtonOne.setOnClickListener {
            val fragment = CustomerForm()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView, fragment)
            transaction?.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}