package com.inturnsala.newsfresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//adapter need data, which is provided by the activity. adapter gets data under its constructor
//(val item : ArrayList<String>)
class NewsListAdapter(private val item : ArrayList<String> , private val listener: NewsItemClicked) : RecyclerView.Adapter<NewsViewHolder>()
{
    override fun getItemCount(): Int
     {
         return item.size
    }

//onCreateViewHolder function return NewsViewHolder
// NewsViewHolder needs an itemview . itemview comes from item_news.xml
 //itemview ( item_news.xml)  is in xml format but we need this view format
    //so we use layout inflater to convert xml to view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = NewsViewHolder(view)
        //we get position from viewholder
       view.setOnClickListener{
         listener.onItemClicked(item[viewHolder.adapterPosition])
       }

        return  viewHolder

    }

   // bind data   with holder
    // it takes item one by one and fill with corrensponding data
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int)
   {
       val currentItem = item[position]
       holder.titleView.text = currentItem

    }
}

class  NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val titleView : TextView = itemView.findViewById(R.id.title)  //we bring textview from item_news.xml is called item view
    ////item_news.xml is called item view

}
//item_news.xml is called item view
// after onclick some operation will be perfrormed, main activity is reponsible for that not adapter
//but activity does not realize that onclick occure or not .for that we need to make call back
//simple method to implement callback is interface
interface NewsItemClicked
{
    // creat fun names onItemClicked
    fun onItemClicked(Item : String)
}
//passing the instance of this interface
//class NewsListAdapter(private val item : ArrayList<String> , private val listener: NewsItemClicked) : RecyclerView.Adapter<NewsViewHolder>()














