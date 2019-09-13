package com.lambdaschool.sprintandroidoopchallenge.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lambdaschool.sprintandroidoopchallenge.R
import com.lambdaschool.sprintandroidoopchallenge.model.AgeOfEmpiresApiObject
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: AgeOfEmpiresApiObject? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = it.getSerializable(ARG_ITEM_ID) as AgeOfEmpiresApiObject
                activity?.toolbar_layout?.title = item?.name ?: ""
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        rootView.btn_toast.setOnClickListener {
            responseObject?.provideInfoForObject(item?.info() ?: "No info")
        }

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.item_text.text = it.name
        }

        return rootView
    }

    interface DetailResponse {
        fun provideInfoForObject(info: String)
    }

    private var responseObject: DetailResponse? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DetailResponse) {
            responseObject = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        responseObject = null
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
