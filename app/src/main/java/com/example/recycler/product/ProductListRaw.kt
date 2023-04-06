import com.example.recycler.product.ProductModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductListRaw(
    @Json(name = "products")
    val products: MutableList<ProductModel>? = null
)