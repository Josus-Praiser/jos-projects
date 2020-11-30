package com.josus.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.josus.bookhub.R
import com.josus.bookhub.model.Book
import kotlinx.android.synthetic.main.recycler__dashboard_single_row.view.*
import java.util.ArrayList

class DashboardRecyclerAdapter(val context: Context, val itemList:ArrayList<Book>):RecyclerView.Adapter<DashboardRecyclerAdapter.DasboardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DasboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler__dashboard_single_row, parent, false)
        return DasboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

    override fun onBindViewHolder(holder: DasboardViewHolder, position: Int) {

        val book=itemList[position]

        holder.txtBookName.text=book.bookName
        holder.txtBookAuthor.text=book.bookAuthor
        holder.txtBookPrice.text=book.bookCost
        holder.txtBookRating.text=book.bookRating
        holder.imgBookImage.setImageResource(book.bookImage)

        holder.llContent.setOnClickListener {
            Toast.makeText(context,"Clicked on ${holder.txtBookName.text}",Toast.LENGTH_SHORT).show()
        }

    }

    class DasboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtBookName: TextView = view.findViewById(R.id.txtBookName)
        val txtBookAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
        val txtBookPrice:TextView=view.findViewById(R.id.txtBookPrice)
        val txtBookRating:TextView=view.findViewById(R.id.txtBookRating)
        val imgBookImage:ImageView=view.findViewById(R.id.imgBookImage)
        val llContent:LinearLayout=view.findViewById(R.id.llContent)


    }
}