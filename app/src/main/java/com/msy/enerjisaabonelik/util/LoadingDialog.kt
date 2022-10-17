package com.msy.enerjisaabonelik.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.msy.enerjisaabonelik.R

class LoadingDialog {

    private var dialog: AlertDialog? = null

    fun show(context: Context?, message: String?) {
        val alert = MaterialAlertDialogBuilder(context!!)
        val inflater = LayoutInflater.from(context)
        val dialogView: View = inflater.inflate(R.layout.loading_dialog_layout, null)
        alert.setView(dialogView)
        alert.setCancelable(false)
        val loadingMessage = dialogView.findViewById<TextView>(R.id.loadingMessage)
        dialog = alert.create()
        loadingMessage.text = message
        dialog!!.show()
    }

    fun dismiss() {
        if (dialog != null) {
            dialog!!.dismiss()
        }
    }
}