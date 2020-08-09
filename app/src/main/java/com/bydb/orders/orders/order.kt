package com.bydb.orders.orders

class Order () {

    var articles: MutableList<Article>? = null

    fun addArticle (article: Article) {
        if (articles == null) {
            articles = mutableListOf(article)
        } else {
            articles?.add(article)
        }
    }

    val amountTotal: Double
        get() {
            return if (articles == null) {
                0.0
            } else {
                var amount = 0.0
                for (article in articles!!) {
                    amount += article.price * article.quantity
                }
                amount
            }
        }

    private val amountPaid: Double
        get() {
            return if (articles == null) {
                0.0
            } else {
                var amount = 0.0
                for (article in articles!!) {
                    amount += article.amount_paid
                }
                amount
            }
        }

    val amountDue: Double
        get() = amountTotal - amountPaid

}

class Article(var title: String, var price: Double,
              var quantity: Int = 0, var amount_paid: Double = 0.0)

val myOrder: Order = Order()

val myBasket: Order = Order()