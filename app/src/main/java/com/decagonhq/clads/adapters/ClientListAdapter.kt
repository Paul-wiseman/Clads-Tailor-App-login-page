package com.decagonhq.clads.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.decagonhq.clads.databinding.FragmentClientsListRecyclerviewLayoutBinding
import com.decagonhq.clads.utils.ClientDetailsDataClass
import java.util.Random

class ClientListAdapter : RecyclerView.Adapter<ClientListAdapter.ClientListViewHolder>() {

    var clients = mutableListOf<ClientDetailsDataClass>()
    // this function is responsible for setting up the list to be displayed in the recyclerview
    private fun setClientData(clients: MutableList<ClientDetailsDataClass>) {
        this.clients = clients
    }
    inner class ClientListViewHolder(val binding: FragmentClientsListRecyclerviewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClientListViewHolder {
        return ClientListViewHolder(
            FragmentClientsListRecyclerviewLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ClientListViewHolder, position: Int) {

        var currentClient = clients[position]
        holder.binding.fragmentClientsListRecyclerviewLayoutFirstNameTextView.text =
            currentClient.firstName
        holder.binding.fragmentClientsListRecyclerviewLayoutLastNameTextView.text =
            currentClient.lastName
        holder.binding.fragmentClientListRecyclerviewLayoutLocationTextView.text =
            currentClient.address

        // creating a random color
        val rnd = Random()
        val color = Color.argb(230, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        // below text drawable is a circular
        var drawable2 = TextDrawable.builder().beginConfig()
            .width(100)
            .height(100)
            .endConfig()

            // as we are building a circular drawable
            // we are calling a build round method.
            // in that method we are passing our text and color.
            .buildRound(setCircleText(currentClient.firstName?.trim(), currentClient.lastName?.trim()), color)

        holder.binding.fragmentClientsListRecyclerviewLayoutCircularImageTextViewText.setImageDrawable(drawable2)
    }

    override fun getItemCount() = clients.size

    // the function takes the user's first and last name, splits it to get the first letters of first and last name
    // and the string result is used in the circle image view
    private fun setCircleText(firstName: String?, lastName: String?): String {
        val firstText = firstName?.substring(0, 1)
        val secondText = lastName?.substring(0, 1)

        return "$firstText$secondText"
    }
}
