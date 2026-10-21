package bo.edu.uajms.beymarchoque.surmarket.models

data class product (
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val imageUrl: String,
    val description: String,
    val available: Boolean,
    val stock: Int
)