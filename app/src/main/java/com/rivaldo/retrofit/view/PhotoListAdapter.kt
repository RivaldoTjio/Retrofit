package com.rivaldo.retrofit.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.ResourceManagerInternal.get
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivaldo.retrofit.R
import com.rivaldo.retrofit.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class PhotoListAdapter(var photos: ArrayList<Photo>) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

 inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(photos: Photo) {
            itemView.tvTitle.text = photos.title
            itemView.setOnClickListener { view ->
            Toast.makeText(itemView.context, "Hello", Toast.LENGTH_LONG).show()
            }
            Picasso.get().load(photos.thumbnail).into(itemView.imageView)
        }
    }

    fun updatePhotos(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(photos[position])
    }

    override fun getItemCount() = photos.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemview : View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(itemview)
    }

}