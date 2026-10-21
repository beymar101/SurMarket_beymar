package bo.edu.uajms.beymarchoque.surmarket

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.beymarchoque.surmarket.models.product

class AdapterProducts (
    private val products_List: List<product>,
    private val clickOnBuy: (product) -> Unit
): RecyclerView.Adapter<AdapterProducts.ViewHolderProducts>(){

    //=====================================
    class ViewHolderProducts(){

    }
    //=====================================

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.ViewHolderProducts {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: AdapterProducts.ViewHolderProducts,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}