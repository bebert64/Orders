package com.bydb.orders
import com.bydb.orders.examples.bieres
import com.bydb.orders.orders.myOrder
import com.bydb.orders.orders.myBasket

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bydb.orders.databinding.ArticleBinding
import com.bydb.orders.databinding.PlaceOrderBinding
import com.bydb.orders.orders.Article


class PlaceOrder : AppCompatActivity()  {

    private var articles: MutableList<Article>? = null
    lateinit var articlesLayout: LinearLayout
    lateinit var viewBinding: PlaceOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = PlaceOrderBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        articlesLayout = findViewById<LinearLayout>(R.id.articles_list)

        for (biere in bieres) { addArticle(biere) }
        viewBinding.myBasket = myBasket
        viewBinding.calculatePrice.setOnClickListener {
            calculatePrice()
        }
//
//        viewBinding.placeOrderButton.setOnClickListener {
//            place_order()
//            val intent = Intent(this@placeOrder, viewOrder::class.java) as Intent
//            startActivity(intent)
//        }
    }

    private fun addArticle(article: Article) {

        val articleBinding: ArticleBinding = ArticleBinding.inflate(this.layoutInflater)
        articleBinding.article = article
        articleBinding.plusButton.setOnClickListener {
            article.quantity += 1
            articleBinding.invalidateAll()
            viewBinding.invalidateAll()
        }
        articleBinding.minusButton.setOnClickListener {
            article.quantity = when (articleBinding.article!!.quantity) {
                0 -> 0
                else -> articleBinding.article!!.quantity - 1
            }
            articleBinding.invalidateAll()
            viewBinding.invalidateAll()
        }
        articlesLayout.addView(articleBinding.root)
        if (articles == null) {
            articles = mutableListOf(article)
        } else {
            articles?.add(article)
        }
        myBasket.addArticle(article)
    }

//    fun add_quantity(quantity: TextView) {
//        val test = 1
//        //val qty_str = quantity.text
//        //val quantity_int = quantity.text.toString().toInt()
//        //quantity.text = (quantity_int + 1).toString()
//    }
//
//    fun remove_quantity(quantity: TextView) {
//        val test = 1
//        //val qty_str = quantity.text
//        //val quantity_int = quantity.text.toString().toInt()
//        //if (quantity_int > 0) quantity.text = (quantity_int - 1).toString()
//    }
//
    fun calculatePrice() {
        var price = 0.0
        for (article in myBasket.articles!!) {
//            val quantityStr: String = article.quantity.toString()
            price += article.quantity
        }
//        price = myBasket.amountTotal
        viewBinding.priceResult.text = price.toString()
    }
//
//    fun place_order() {
//        for (article in articles!!) {
//            var quantity = article.view_binding!!.quantity.text.toString().toInt()
//            if (quantity != 0) {
//                var order_article = OrderArticle(article, quantity, 0.0)
//                my_order.add_article(order_article)
//            }
//        }
//    }

}
