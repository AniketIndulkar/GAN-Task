package com.gan.gan_task.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gan.gan_task.databinding.BbCharRvItemBinding
import com.gan.gan_task.model.BBCharacter

class BBCharRVAdapter :
    ListAdapter<BBCharacter, BBCharRVAdapter.BBCharViewHolder>(CharDiffCallback()) {

    var charClickListener: OnCharClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BBCharViewHolder {
        return BBCharViewHolder(
            BbCharRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BBCharViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character, charClickListener!!)//
    }

    fun setClickListener(listener: OnCharClickListener) {
        charClickListener = listener
    }

    class BBCharViewHolder(
        private val binding: BbCharRvItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BBCharacter, listener: OnCharClickListener) {
            binding.apply {
                bbCharData = item
                executePendingBindings()
            }

            setFadeAnimation(binding.root)// To set fade animation

            //Setting Listner to entire view
            binding.root.setOnClickListener(View.OnClickListener {
                listener.onCharClick(item)
            })

        }

        private fun setFadeAnimation(view: View) {
            val anim = AlphaAnimation(0.0f, 1.0f)
            anim.duration = 300
            view.startAnimation(anim)
        }
    }


}

//Difference callback for CakeList adapter yo check that data has changed or not
private class CharDiffCallback : DiffUtil.ItemCallback<BBCharacter>() {

    override fun areItemsTheSame(oldItem: BBCharacter, newItem: BBCharacter): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: BBCharacter, newItem: BBCharacter): Boolean {
        return oldItem == newItem
    }
}

//Listener for Recyclerview
interface OnCharClickListener {
    fun onCharClick(bbCharacter: BBCharacter)
}