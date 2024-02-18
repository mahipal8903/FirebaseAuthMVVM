import com.example.demoproject.dashboard.ApiService
import com.example.demoproject.dashboard.Coffee
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoffeeRepository {

    private val apiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getCoffees(): Call<List<Coffee>> {
        return apiService.getHotCoffees()
    }
}
