package space.kis.database.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import space.kis.database.databinding.DialogFragmentUpdateBinding
import space.kis.database.model.Country

class DialogUpdate(
    private val country: Country
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogFragmentUpdateBinding.inflate(layoutInflater)

        return AlertDialog.Builder(requireContext())
            .setTitle("Edit")
            .setMessage("Enter new country name and capital")
            .setView(binding.root)
            .setPositiveButton("Yes") { _, _ ->
                with(binding) {

                    val countryName = if (!dialogUpdateCountry.text.isNullOrBlank()) {
                        binding.dialogUpdateCountry.text.toString()
                    } else {
                        country.countryName
                    }

                    val capitalName = if (!dialogUpdateCapital.text.isNullOrBlank()) {
                        binding.dialogUpdateCapital.text.toString()
                    } else {
                        country.capitalName
                    }

                    parentFragmentManager.setFragmentResult(
                        REQUEST_KEY,
                        bundleOf(
                            KEY_COUNTRY_NAME to countryName,
                            KEY_CAPITAL_NAME to capitalName,
                        )
                    )
                }
            }
            .setNegativeButton("No", null)
            .create()
    }

    companion object {
        const val TAG = "DialogDelete"
        const val REQUEST_KEY = "${TAG}REQUEST_KEY"
        const val KEY_COUNTRY_NAME = "KEY_COUNTRY_NAME"
        const val KEY_CAPITAL_NAME = "KEY_CAPITAL_NAME"
    }
}