
package com.poul.android.test.presentation.adapter

import android.net.ParseException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.poul.android.test.R.layout
import com.poul.android.test.domain.Post
import com.poul.android.test.presentation.adapter.PostAdapter.PostViewHolder
import com.poul.android.test.presentation.fragment.extensions.load
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_view_item.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class PostAdapter(
    private val onPostClickListener: ((view: View, post: Post) -> Unit)? = null
) : ListAdapter<Post, PostViewHolder>(ITEM_COMPARATOR) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return PostViewHolder(
        inflater.inflate(
            layout.recycler_view_item,
            parent,
            false
        )
    )
  }

  override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
    val item: Post = getItem(position)
    holder.bind(item, onPostClickListener)
  }
  class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
      LayoutContainer {

    override val containerView: View?
      get() = itemView

    fun bind(
        item: Post,
        onPostClickListener: ((view: View, post: Post) -> Unit)?
    ) {
        with(title_post) {
           text = item.title
        }
        with(rocket_name) {
           text = item.rocketName
        }
        with(date) {
            val formatter: DateFormat = SimpleDateFormat("dd-MM-yyyy")
            val date = formatter.parse(item.date) as Date
            text = date.year.toString() +" Год " +date.month.toString() +" месяц " + date.day.toString() +" день "

        }
        with(container)
        {
            setOnClickListener {
                onPostClickListener?.let {
                    it(this, item)
                }
            }
            transitionName = item.title
        }
      with(image_view) {
        item.picture?.let {
            load(it) {
                onPostClickListener?.let {
                it(this, item)
                }
            }
        }
        transitionName = item.picture
      }
    }
  }
}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<Post>() {
  override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
    return oldItem.picture == newItem.picture
  }

  override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
    return oldItem == newItem
  }
}