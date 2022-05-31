package space.kis.database.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import space.kis.database.R
import space.kis.database.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstStart()
        (activity as AppCompatActivity).supportActionBar?.title = "List menu"

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.btn_menu -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerMain, EditFragment())
                        .commit()
                }
                R.id.btn_list_db -> {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.containerMain, ListFragment())
                        .commit()
                }
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun firstStart() {
        parentFragmentManager
            .beginTransaction()
            .add(R.id.containerMain, EditFragment())
            .commit()
    }
}