package video.nts.nl.componentarch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_items.view.*

class WordAdapter(context: Context, private var words : List<Word>) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mInflater = LayoutInflater.from(parent.context)
        val itemView = mInflater.inflate(R.layout.recyclerview_items, parent, false)

        return ViewHolder(itemView)
    }

    fun setWord(items: List<Word>){
        words = items
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int  = words.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(words.isNullOrEmpty())
        holder.bind(words[position])
        else holder.textView.text = "No word"
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         val textView: TextView = this.itemView.textView
        fun bind(item: Word){
            textView.text = item.mWord
        }
    }
}