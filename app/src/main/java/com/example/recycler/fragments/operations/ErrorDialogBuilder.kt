package com.example.recycler.fragments.operations

import android.app.AlertDialog
import com.example.recycler.MAIN
import com.example.recycler.R

class ErrorDialogBuilder {
    val builder = AlertDialog.Builder(MAIN, R.style.error_dialog_style)

    fun createDialog() {
        builder.setTitle(R.string.error_dialog_title_string)
        builder.setMessage(R.string.error_dialog_text_string)
        builder.setPositiveButton(R.string.error_dialog_positive_button) { _, i ->
            MAIN.navController.navigate(R.id.action_listFragment_to_FirstFragment)
            MAIN.navController.navigate(R.id.action_FirstFragment_to_listFragment)
        }
        builder.setNegativeButton(R.string.error_dialog_negative_button) { _, i ->
            MAIN.navController.navigate(R.id.action_listFragment_to_FirstFragment)
        }
        builder.show()
    }
}