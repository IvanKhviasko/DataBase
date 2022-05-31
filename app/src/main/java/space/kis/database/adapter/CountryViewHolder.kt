package space.kis.database.adapter

import androidx.recyclerview.widget.RecyclerView
import space.kis.database.databinding.ItemCountryBinding
import space.kis.database.model.Country

class CountryViewHolder(
    private val binding: ItemCountryBinding,
    private val onClick: (Country, Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country) {
        binding.textName.text = country.toString()
        binding.root.setOnLongClickListener {
            onClick(country, BUTTON_DELETE)
            true
        }
        binding.imageBtn.setOnClickListener {
            onClick(country, BUTTON_EDIT)
        }
    }

    companion object {
        const val BUTTON_DELETE = 0
        const val BUTTON_EDIT = 1
    }
}