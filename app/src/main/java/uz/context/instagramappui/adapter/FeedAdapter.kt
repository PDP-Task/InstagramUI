package uz.context.instagramappui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.context.instagramappui.R
import uz.context.instagramappui.model.Feed
import uz.context.instagramappui.model.Story

class FeedAdapter(
    private val context: Context,
    private val items: ArrayList<Feed>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ITEM_STORY = 0
        private const val TYPE_ITEM_POST = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].stories.size > 0) TYPE_ITEM_STORY else TYPE_ITEM_POST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context, view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val feed = items[position]

        if (holder is StoryViewHolder) {
            refreshAdapter(feed.stories,holder.recyclerView)
        }
        if (holder is PostViewHolder) {
            holder.apply {
                ivProfile.setImageResource(feed.post!!.profile)
                ivPhoto.setImageResource(feed.post!!.photo)
                tvFullName.text = feed.post!!.fullName
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context,stories)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    class StoryViewHolder(context: Context, view: View): RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
    }
    class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivProfile: ImageView = view.findViewById(R.id.iv_profile)
        val ivPhoto: ImageView = view.findViewById(R.id.iv_photo)
        val ivLike: ImageView = view.findViewById(R.id.iv_like)
        val ivComment: ImageView = view.findViewById(R.id.iv_comment)
        val ivSave: ImageView = view.findViewById(R.id.iv_save)
        val ivSend: ImageView = view.findViewById(R.id.iv_send)
        val tvFullName: TextView = view.findViewById(R.id.tv_full_name)
        val tvCaption: TextView = view.findViewById(R.id.tv_caption)
    }
}