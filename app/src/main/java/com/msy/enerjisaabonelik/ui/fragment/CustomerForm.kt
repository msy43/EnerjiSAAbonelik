package com.msy.enerjisaabonelik.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.msy.enerjisaabonelik.R
import com.msy.enerjisaabonelik.databinding.FragmentCustomerFormBinding

class CustomerForm : Fragment() {

    private var _binding: FragmentCustomerFormBinding? = null
    private val binding get() = _binding!!

    private val subscriptionTypeAutoCompleteTextView: AutoCompleteTextView by lazy {
        binding.newSubscriptionSubscriptionType
    }

    private val guaranteeFeeButton: Button by lazy { binding.newSubscriptionGuaranteeFeeButton }
    private val guaranteeFeeInfoLinearLayout: LinearLayout by lazy { binding.newSubscriptionGuaranteeFeeInfoLinearLayout }
    private val guaranteeFeeInfoCloseButton: Button by lazy { binding.newSubscriptionGuaranteeFeeInfoCloseButton }

    private var subscriptionTypeList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCustomerFormBinding.inflate(inflater, container, false)
        val view = binding.root

        setsubscriptionTypeList()

        binding.newSubscriptionToolbarBack.setOnClickListener {
            goBack()
        }

        guaranteeFeeButton.setOnClickListener {
            openInfoDialog()
        }
        return view
    }

    private fun goBack() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentContainerView, SubscriptionMenu())
        transaction?.commit()
    }

    private fun openInfoDialog() {
        if (guaranteeFeeInfoLinearLayout.visibility == View.GONE) {
            guaranteeFeeInfoLinearLayout.visibility = View.VISIBLE
        } else {
            guaranteeFeeInfoLinearLayout.visibility = View.GONE
        }
        guaranteeFeeInfoCloseButton.setOnClickListener {
            guaranteeFeeInfoLinearLayout.visibility = View.GONE
        }
    }

    private fun setsubscriptionTypeList() {

        subscriptionTypeList.add("Mesken (Konut)")
        subscriptionTypeList.add("Mesken (İş Yeri)")

        val companyAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                requireContext(),
                R.layout.subscriptiontype_item_layout,
                subscriptionTypeList
            )
        subscriptionTypeAutoCompleteTextView.setAdapter(companyAdapter)
        companyAdapter.notifyDataSetChanged()
    }
}