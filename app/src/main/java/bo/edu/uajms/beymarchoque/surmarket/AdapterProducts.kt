package bo.edu.uajms.beymarchoque.surmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.beymarchoque.surmarket.models.product

class AdapterProducts (
    private val products_List: List<product>,
    private val clickOnBuy: (product) -> Unit
): RecyclerView.Adapter<AdapterProducts.ViewHolderProducts>(){

    //=====================================
    class ViewHolderProducts(itemView: View): RecyclerView.ViewHolder(itemView){
        val TXV_IProductList_category: TextView = itemView.findViewById(R.id.TXV_IProductList_category)
        val TXV_IProductList_ProductName: TextView = itemView.findViewById(R.id.TXV_IProductList_ProductName)
        val TXV_IProductList_Price: TextView = itemView.findViewById(R.id.TXV_IProductList_Price)
        val BTN_IProductList_Buy: Button = itemView.findViewById(R.id.BTN_IProductList_Buy)
        val IMV_IProductList_ProductsImage: ImageView = itemView.findViewById(R.id.IMV_IProductList_ProductsImage)
        val stringCategory = itemView.context.getString(R.string.category)
        val stringPrice = itemView.context.getString(R.string.price)



    }
    //=====================================

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.ViewHolderProducts {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_productslist,parent,false)
        return ViewHolderProducts(vista)
    }

    override fun onBindViewHolder(holder: AdapterProducts.ViewHolderProducts, position: Int) {
        val product= products_List[position]
        holder.TXV_IProductList_category.text= holder.stringCategory + ": " + product.category
        holder.TXV_IProductList_ProductName.text= product.name
        holder.TXV_IProductList_Price.text= holder.stringPrice + ": " + "${product.price}"
        holder.IMV_IProductList_ProductsImage.setImageResource(R.drawable.ic_sur__market)
        holder.BTN_IProductList_Buy.setOnClickListener {
            clickOnBuy(product)
        }
    }

    override fun getItemCount(): Int {
        return products_List.size
    }

    fun notifyChanged()
    {
        notifyDataSetChanged()
    }
}