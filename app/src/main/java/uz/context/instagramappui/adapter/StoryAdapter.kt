package uz.context.instagramappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.instagramappui.R
import uz.context.instagramappui.model.Story

class StoryAdapter(
    context: Context,
    private val items: ArrayList<Story>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            holder.apply {
                ivProfile.setImageResource(story.profile)
                tvFullName.text = story.fullName
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivProfile: ImageView = view.findViewById(R.id.iv_profile)
        val tvFullName: TextView = view.findViewById(R.id.tv_full_name)
    }
}