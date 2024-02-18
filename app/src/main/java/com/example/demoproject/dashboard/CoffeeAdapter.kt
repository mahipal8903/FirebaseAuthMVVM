import CoffeeAdapter.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.dashboard.Coffee
import com.example.demoproject.databinding.RecyclerLayoutBinding
import com.bumptech.glide.Glide

class CoffeeAdapter(private val coffees: List<Coffee>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(coffees[position])
    }

    override fun getItemCount(): Int {
        return coffees.size
    }

    inner class ViewHolder(private val binding: RecyclerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(coffee: Coffee) {
            binding.apply {
                binding.tvTitle.text = coffee.title
                binding.tvDescription.text = coffee.description
                Glide.with(itemView)
                    .load(coffee.imageUrl)
                    .centerCrop()
                    .into(binding.imageMain)
            }
        }
    }
}
