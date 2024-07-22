package com.example.crudapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.crudapp.R
import com.example.crudapp.data.entity.Product
import com.example.crudapp.ui.theme.ProductViewModel

class ProductInputFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        val productNameEditText: EditText = view.findViewById(R.id.productName)
        val salePriceEditText: EditText = view.findViewById(R.id.salePrice)
        val purchasePriceEditText: EditText = view.findViewById(R.id.purchasePrice)
        val saveButton: Button = view.findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val productName = productNameEditText.text.toString()
            val salePrice = salePriceEditText.text.toString().toDoubleOrNull()
            val purchasePrice = purchasePriceEditText.text.toString().toDoubleOrNull()

            if (!productName.isNullOrEmpty() && salePrice != null && purchasePrice != null) {
                val product = Product(0, productName, salePrice, purchasePrice)
                productViewModel.insert(product)
            }
        }
    }
}
