package com.bydb.orders
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.bydb.orders.databinding.PlaceOrderBinding
import com.bydb.orders.databinding.ViewOrderBinding
import com.bydb.orders.orders.myOrder

class viewOrder: Activity() {

    lateinit var viewBinding: ViewOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ViewOrderBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        //val lin_lay = view_binding.linLay
        myOrder.categories!!.let() {
            for (article in it) {
                val textView = TextView(this)
//                textView.text = article.title
                viewBinding.root.addView(textView)
            }
        }
    }
}