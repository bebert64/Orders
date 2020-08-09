package com.bydb.orders.examples

import com.bydb.orders.orders.Article

val blondeSmall = Article(title = "Heineken 25 cl", price = 3.50)
val blondeBig = Article(title = "Heineken 50 cl", price = 5.50)
val blancheSmall = Article(title = "Hoegarden 25 cl", price = 4.00)
val blancheBig = Article(title = "Hoegarden 50 cl", price = 6.50)

val bieres = listOf(blondeBig, blondeSmall, blancheBig, blancheSmall)