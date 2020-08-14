package com.bydb.orders.orders

class Order {

    var categories: MutableMap<String, Category>? = null

    fun addCategory (category: Category) {
        if (categories == null) {
            categories = mutableMapOf(category.ID to category)
        } else {
            categories?.plusAssign(category.ID to category)
        }
    }

    var amountTotal: Double = 0.0
        get() {
            return if (categories == null) {
                0.0
            } else {
                var amount = 0.0
                for (category in categories!!.values) {
                    amount += category.amountTotal
                }
                amount
            }
        }

    private val amountPaid: Double
        get() {
            return if (categories == null) {
                0.0
            } else {
                var amount = 0.0
                for (category in categories!!.values) {
                    amount += category.amountPaid
                }
                amount
            }
        }

    val amountDue: Double
        get() = amountTotal - amountPaid

}


class Category(val ID: String,
                 val title: String,
                 val description: String,
                 var articles: MutableMap<String, Article>?) {

    fun addArticle(article: Article) {
        if (articles.isNullOrEmpty()) {
            articles = mutableMapOf(article.ID to article)
        }
        else if (article.ID !in articles!!.keys) {
            articles!!.plusAssign(article.ID to article)
        }
    }

    var amountTotal: Double = 0.0
        get() {
            return if (articles == null) {
                0.0
            } else {
                var amount = 0.0
                for (article in articles!!.values) {
                    amount += article.price * article.quantity
                }
                amount
            }
        }

    val amountPaid: Double
        get() {
            return if (articles == null) {
                0.0
            } else {
                var amount = 0.0
                for (article in articles!!.values) {
                    amount += article.amount_paid
                }
                amount
            }
        }
}



class Article(val ID: String,
              var title: String,
              var description: String,
              var price: Double,
              var quantity: Int = 0,
              var amount_paid: Double = 0.0)

val myOrder: Order = Order()

val myBasket: Order = Order()
