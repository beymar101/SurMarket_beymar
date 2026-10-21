package bo.edu.uajms.beymarchoque.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.beymarchoque.surmarket.models.product
import kotlin.Int
import kotlin.String


class FragmentProductsList : Fragment() {
    private lateinit var IMV_FRGProductsList_ShoppingCart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_AddProduct: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView
    private lateinit var adapterProducts: AdapterProducts
    private var listaProductos = mutableListOf<product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeView(view)
        configureListeners()
        configureRecyclerView()
        loadSampleProducts()
    }

    private fun initalizeView(view: View) {
         IMV_FRGProductsList_ShoppingCart= view.findViewById(R.id.IMV_FRGProductsList_ShoppingCart)
         IMV_FRGProductsList_Search= view.findViewById(R.id.IMV_FRGProductsList_Search)
         ETX_FRGProductsList_Search= view.findViewById(R.id.FRGProductList_Search)
         BTN_FRGProductsList_AddProduct= view.findViewById(R.id.BTN_FRGProductsList_AddProduct)
         RCV_FRGProductsList_ProductsList= view.findViewById(R.id.RCV_FRGProductsList_ProductsList)

    }

    private fun configureListeners(){

    }

    private fun configureRecyclerView(){
        adapterProducts = AdapterProducts(
            products_List = listaProductos,
            clickOnBuy = { product ->
                Toast.makeText(requireContext(),getString(R.string.addCart)+"${product.name}",
                    Toast.LENGTH_SHORT).show()
            }
        )
        RCV_FRGProductsList_ProductsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter =adapterProducts
        }
    }

    private fun loadSampleProducts(){
        val productsSample = listOf(
            product(
                id = 1,
                name = "Camisa",
                category = "Ropa de varon",
                price = 180.0,
                imageUrl = "",
                description = "Camisa de Varon Tommy Roja",
                available = true,
                stock = 1
            ),
            product(
                id = 2,
                name = "Pantalon",
                category = "Ropa de varon",
                price = 210.0,
                imageUrl = "",
                description = "Pantalon de jean azul",
                available = true,
                stock = 1
            ),
            product(
                id = 3,
                name = "Polera",
                category = "Ropa de varon",
                price = 160.0,
                imageUrl = "",
                description = "Polera polo Totto azul",
                available = true,
                stock = 1
            ),
            product(
                id = 4,
                name = "Zapatos",
                category = "Ropa de varon",
                price = 310.0,
                imageUrl = "",
                description = "Zapatos marca Batta",
                available = true,
                stock = 1
            )
        )
        listaProductos.clear()
        listaProductos.addAll(productsSample)
        adapterProducts.notifyChanged()

    }

}