package com.lambdaschool.sprintandroidoopchallenge.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.lambdaschool.sprintandroidoopchallenge.AgeOfEmpiresAPI
import com.lambdaschool.sprintandroidoopchallenge.R
import com.lambdaschool.sprintandroidoopchallenge.model.*

import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list_content.view.*
import kotlinx.android.synthetic.main.item_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity(), ItemDetailFragment.DetailResponse {
    override fun provideInfoForObject(info: String) {
        Toast.makeText(this, "Item Detail Fragment: $info", Toast.LENGTH_SHORT).show()
    }

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    var ageOfEmpiresApiObject = mutableListOf<AgeOfEmpiresApiObject>()
    private var viewAdapter: SimpleItemRecyclerViewAdapter? = null

    lateinit var ageOfEmpiresAPI: AgeOfEmpiresAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        ageOfEmpiresApiObject = mutableListOf()

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

        ageOfEmpiresAPI = AgeOfEmpiresAPI.Factory.create()

        setupRecyclerView(item_list as RecyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        viewAdapter = SimpleItemRecyclerViewAdapter(this, ageOfEmpiresApiObject, twoPane)
        recyclerView.adapter = viewAdapter

        if (isNetworkConnected()) {
            getData()
        } else {
            Toast.makeText(this@ItemListActivity,
                "Please check your internet connection and try again",
                Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun getData() {

    }

    fun getCivilizations() {
        ageOfEmpiresAPI.getCivilitzation().enqueue(object: Callback<List<Civilizations>> {

            override fun onFailure(call: Call<List<Civilizations>>, t: Throwable) {
                progressBar.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<List<Civilizations>>,
                response: Response<List<Civilizations>>
            ) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val civilizations = response.body()
                    civilizations?.let {
                        it.name = name

                    }
                }
            }
        })
    }

    fun getUnits() {
        ageOfEmpiresAPI.getUnits().enqueue(object: Callback<List<Units>> {
            override fun onFailure(call: Call<List<Units>>, t: Throwable) {
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<List<Units>>, response: Response<List<Units>>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val units = response.body()
                    units?.let {

                    }
                }
            }

        })
    }

    fun getStructures() {
        ageOfEmpiresAPI.getStructures().enqueue(object: Callback<List<Structures>> {
            override fun onFailure(call: Call<List<Structures>>, t: Throwable) {
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<List<Structures>>, response: Response<List<Structures>>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val units = response.body()
                    units?.let {

                    }
                }
            }

        })
    }

    fun getTechnologies() {
        ageOfEmpiresAPI.getTechnologies().enqueue(object: Callback<List<Technologies>> {
            override fun onFailure(call: Call<List<Technologies>>, t: Throwable) {
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<List<Technologies>>, response: Response<List<Technologies>>) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val units = response.body()
                    units?.let {

                    }
                }
            }

        })
    }

    class SimpleItemRecyclerViewAdapter(
        private val parentActivity: ItemListActivity,
        private val values: List<AgeOfEmpiresApiObject>,
        private val twoPane: Boolean
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private var lastPosition = -1

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as AgeOfEmpiresApiObject
                if (twoPane) {
                    val fragment = ItemDetailFragment()
                        .apply {
                        arguments = Bundle().apply {
                            putSerializable(ItemDetailFragment.ARG_ITEM_ID, item)
                        }
                    }
                    parentActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.item_detail_container, fragment)
                        .commit()
                } else {
                    val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                        putExtra(ItemDetailFragment.ARG_ITEM_ID, item)
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
            holder.nameView.text = ageOfEmpiresApiObject.name ?: ""
            holder.contentView.text = ageOfEmpiresApiObject.info()

            with(holder.itemView) {
                tag = ageOfEmpiresApiObject
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameView: TextView = view.id_text
            val contentView: TextView = view.content
        }
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true
    }
}
