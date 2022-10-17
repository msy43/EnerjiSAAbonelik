package com.msy.enerjisaabonelik.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.msy.enerjisaabonelik.R

class ViewUtil {
    fun showCustomDialog(
        context: Context?,
        title: String?,
        message: String?,
        positiveButtonText: String?,
        negativeButtonText: String?,
        positiveButtonAction: Runnable,
        negativeButtonAction: Runnable
    ) {
        val alert = MaterialAlertDialogBuilder(context!!)
        val inflater = LayoutInflater.from(context)
        val dialogView: View = inflater.inflate(R.layout.custom_dialog_layout, null)
        alert.setView(dialogView)
        val titleTxt = dialogView.findViewById<TextView>(R.id.customDialogTitleText)
        val messageTxt = dialogView.findViewById<TextView>(R.id.customDialogMessageText)
        val positiveButton = dialogView.findViewById<Button>(R.id.customDialogPositiveButton)
        val negativeButton = dialogView.findViewById<Button>(R.id.customDialogNegativeButton)
        val dialog = alert.create()
        titleTxt.text = title
        messageTxt.text = message
        positiveButton.setOnClickListener {
            positiveButtonAction.run()
            dialog.dismiss()
        }
        negativeButton.setOnClickListener {
            negativeButtonAction.run()
            dialog.dismiss()
        }
        dialog.show()
    }
}