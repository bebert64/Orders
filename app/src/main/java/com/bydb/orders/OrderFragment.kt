package com.bydb.orders
import com.bydb.orders.examples.ninkasiCategories
import com.bydb.orders.orders.myOrder
import com.bydb.orders.orders.myBasket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bydb.orders.databinding.ArticleBinding
import com.bydb.orders.databinding.CategoryBinding
import com.bydb.orders.databinding.FragmentOrderBinding
import com.bydb.orders.orders.Article
import com.bydb.orders.orders.Category
import kotlinx.android.synthetic.main.fragment_order.*


class OrderFragment : Fragment()  {

    private var categories: MutableMap<String, CategoryBinding>? = null
    lateinit var binding: FragmentOrderBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_order, container, false)
        for (category in ninkasiCategories) {
            addCategory(category)
        }

        binding.myBasket = myBasket

//        viewBinding.placeOrderButton.setOnClickListener {
//            fragment_order()
//            val intent = Intent(this@placeOrder, viewOrder::class.java) as Intent
//            startActivity(intent)
//        }
        return binding.root
    }

    private fun addCategory(category: Category) {

        val categoryBinding: CategoryBinding = CategoryBinding.inflate(this.layoutInflater)
        categoryBinding.category = category
        binding.categoriesLayout.addView(categoryBinding.root)

        category.articles?.let {
            for (article in it.values) {
                addArticle(article, categoryBinding)
            }
        }

        if (categories == null) {
            categories = mutableMapOf(Pair(category.ID, categoryBinding))
        } else {
            categories!![category.ID] = categoryBinding
        }
        myBasket.addCategory(category)
    }

    private fun addArticle(article: Article, categoryBinding: CategoryBinding) {

        val articleBinding: ArticleBinding = ArticleBinding.inflate(this.layoutInflater)
        articleBinding.article = article
//        articleBinding.plusButton.setOnClickListener {
//            article.quantity += 1
//            articleBinding.invalidateAll()
//            viewBinding.invalidateAll()
//        }
//        articleBinding.minusButton.setOnClickListener {
//            article.quantity = when (articleBinding.article!!.quantity) {
//                0 -> 0
//                else -> articleBinding.article!!.quantity - 1
//            }
//            articleBinding.invalidateAll()
//            viewBinding.invalidateAll()
//        }
        categoryBinding.articlesLayout.addView(articleBinding.root)
    }

}
