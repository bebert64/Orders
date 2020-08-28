package com.bydb.orders.examples

import com.bydb.orders.orders.Article
import com.bydb.orders.orders.Category


val caesarSalad = Article(
    "CAESR",
    "Caesar",
    "salade, tomate, poulet, croûtons, parmesan, câpres, sauce caesar",
    9.60
)

val littleItalySalad = Article(
    "LITLI",
    "Little Italy",
    "salade, tomates, billes de mozzarella, tomates confites au basilic, olives noires, câpres, jambon serrano, sauce balsamique",
    10.90
)

val salads = Category(
    "SALAD",
    "Salades",
    "Composées de salade & légumes frais",
    mutableMapOf(
        caesarSalad.ID to caesarSalad,
        littleItalySalad.ID to littleItalySalad
    )
)


val cookie = Article(
    "COOK",
    "Cookie",
    "",
    2.50
)

val brownie = Article(
    "BROWN",
    "Brownie",
    "",
    3.60
)

val cronut = Article(
    "CROWN",
    "Crownie",
    "la pâtisserie new-yorkaise mi-croissant mi-donut + topping coulis-chocolat ou caramel beurre salé au choix",
    4.80
)

val desserts = Category(
    "DESSRT",
    "Desserts",
    "",
    mutableMapOf(
        cookie.ID to cookie,
        brownie.ID to brownie,
        cronut.ID to cronut
    )
)


val ninkaBlonde = Article(
    "BLOND",
    "Ninkasi Blonde",
    "ARÔMES: miel, notes fruitées",
    5.70
)

val ninkaAmbree = Article(
    "AMBR",
    "Ninkasi Ambrée",
    "ARÔMES: caramel, fruits exotiques.",
    6.50
)

val beers = Category(
    "BEER",
    "Bières",
    "",
    mutableMapOf(
        ninkaBlonde.ID to ninkaBlonde,
        ninkaAmbree.ID to ninkaAmbree
    )
)

val ninkasiCategories = listOf<Category>(salads, desserts, beers)
