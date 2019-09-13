package com.lambdaschool.sprintandroidoopchallenge.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.lambdaschool.sprintandroidoopchallenge.R
import com.lambdaschool.sprintandroidoopchallenge.model.*
import com.lambdaschool.sprintandroidoopchallenge.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list_content.view.*
import kotlinx.android.synthetic.main.item_list.*

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity(), ItemDetailFragment.FragmentListener {

    override fun showToast(ageOfEmpires: AgeOfEmpires) {
        val favorite = if (ageOfEmpires.isFavorite) "is a favorite" else "is not a favorite"
        Toast.makeText(this, "${ageOfEmpires.name} $favorite", Toast.LENGTH_SHORT).show()
    }

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false
    private var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        if (item_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        setupRecyclerView(item_list as RecyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, viewModel.ITEMS, twoPane)
    }

    class SimpleItemRecyclerViewAdapter(
        private val parentActivity: ItemListActivity,
        private val values: List<AgeOfEmpires>,
        private val twoPane: Boolean
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private var lastPosition = -1

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as AgeOfEmpires
                if (twoPane) {
                    val fragment = ItemDetailFragment()
                        .apply {
                        arguments = Bundle().apply {
                            putSerializable(ItemDetailFragment.ARG_ITEM_ID, item.name)
                        }
                    }
                    parentActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.item_detail_container, fragment)
                        .commit()
                } else {
                    val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                        putExtra(ItemDetailFragment.ARG_ITEM_ID, item.name)
                    }
                    v.context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val ageOfEmpiresApiObject = values[position]
            holder.nameView.text = ageOfEmpiresApiObject.name
            holder.contentView.text = ageOfEmpiresApiObject.info()

            with(holder.itemView) {
                tag = ageOfEmpiresApiObject
                setOnClickListener(onClickListener)

                setEnterAnimation(holder.parentView, position)
            }
        }

        override fun getItemCount() = values.size

        private fun setEnterAnimation(viewToAnimate: View, position: Int) {
            if (position > lastPosition) {
                val animation = AnimationUtils.loadAnimation(
                    viewToAnimate.context, android.R.anim.slide_in_left
                )
                viewToAnimate.startAnimation(animation)
                lastPosition = position
            }
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameView: TextView = view.id_text
            val contentView: TextView = view.content
            val parentView: View = view.parent_view
        }
    }
}
