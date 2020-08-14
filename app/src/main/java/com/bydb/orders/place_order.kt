package com.bydb.orders
import com.bydb.orders.examples.salades
import com.bydb.orders.examples.desserts
import com.bydb.orders.orders.myOrder
import com.bydb.orders.orders.myBasket

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bydb.orders.databinding.ArticleBinding
import com.bydb.orders.databinding.CategoryBinding
import com.bydb.orders.databinding.PlaceOrderBinding
import com.bydb.orders.orders.Article
import com.bydb.orders.orders.Category


class PlaceOrder : AppCompatActivity()  {

    private var articles: MutableList<Article>? = null
//    private var categories: MutableList<Category>? = null
//    lateinit var categoriesLayout: LinearLayout
    lateinit var articlesLayout: LinearLayout
    lateinit var viewBinding: PlaceOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = PlaceOrderBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        articlesLayout = findViewById<LinearLayout>(R.id.articles_layout)
//        categoriesLayout = findViewById<LinearLayout>(R.id.categories_layout)

        for (article in salades.articles!!.values) { addArticle(article) }
        for (article in desserts.articles!!.values) { addArticle(article) }
        myBasket.addCategory(salades)
        myBasket.addCategory(desserts)

        viewBinding.myBasket = myBasket

//        viewBinding.placeOrderButton.setOnClickListener {
//            place_order()
//            val intent = Intent(this@placeOrder, viewOrder::class.java) as Intent
//            startActivity(intent)
//        }
    }

//    private fun addCategory(category: Category) {
//
//        val categoryBinding: CategoryBinding = CategoryBinding.inflate(this.layoutInflater)
//        categoryBinding.category = category
//        categoriesLayout.addView(categoryBinding.root)
//        if (articles == null) {
//            articles = mutableListOf(article)
//        } else {
//            articles?.add(article)
//        }
//        myBasket.addArticle(article)
//    }

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
    }

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
