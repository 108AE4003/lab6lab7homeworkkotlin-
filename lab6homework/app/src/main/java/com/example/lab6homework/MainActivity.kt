package com.example.lab6homework

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    class Data {
        var photo: Int = 0
        var name: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transNameArray = arrayOf("脚踏车", "机车", "汽车", "巴士")
        val transPhotoArray = intArrayOf(R.drawable.trans1, R.drawable.trans2
            , R.drawable.trans3, R.drawable.trans4)
        val transData = arrayOfNulls<Data>(transNameArray.size)
        for (i in transData.indices) {
            transData[i] = Data()
            transData[i]!!.name = transNameArray[i]
            transData[i]!!.photo = transPhotoArray[i]
        }
        spinner.adapter = MyAdapter(transData, R.layout.trans_list)

        //listView
        val messageArray = arrayOf("讯息1", "讯息2", "讯息3", "讯息4", "讯息5", "讯息6")
        val messageAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, messageArray)
        ListView.adapter = messageAdapter

        //gridView
        val cubeeNameArray = arrayOf("哭哭", "发抖", "再见", "生气", "昏倒", "窃笑", "很棒", "你好", "惊吓", "大笑")
        val cubeePhotoIdArray = intArrayOf(R.drawable.cubee1, R.drawable.cubee2,
            R.drawable.cubee3, R.drawable.cubee4, R.drawable.cubee5, R.drawable.cubee6,
            R.drawable.cubee7, R.drawable.cubee8, R.drawable.cubee9, R.drawable.cubee10)
        val cubeeData = arrayOfNulls<Data>(cubeeNameArray.size)
        for (i in cubeeData.indices) {
            cubeeData[i] = Data()
            cubeeData[i]!!.name = cubeeNameArray[i]
            cubeeData[i]!!.photo = cubeePhotoIdArray[i]
        }
        gridView.adapter = MyAdapter(cubeeData, R.layout.cubee_list)
        gridView.numColumns = 3

    }

    inner class MyAdapter(private val data: Array<Data?>, private var view: Int) : BaseAdapter() {

        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(position: Int): Any {
            return data[position]!!
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView= layoutInflater.inflate(view, parent, false)
            val name = convertView.findViewById<TextView>(R.id.name)
            name.text = data[position]!!.name
            val imageView = convertView.findViewById<ImageView>(R.id.ImageView)
            imageView.setImageResource(data[position]!!.photo)
            return convertView
        }
    }
}