package edu.msudenver.crud

class Item(
    var name: String,
    var category: Int,
    var quantity: Int,
    var unit: String) {

    companion object {
        const val VEGETABLES = 1
        const val FRUITS = 2
        const val MEAT_AND_FISH = 3
        const val CONDIMENTS = 4
        const val BEVERAGES = 5
        const val SNACKS = 6
        const val BAKING_AND_SPICES = 7
        const val BREAD_AND_GRAINS = 8
        const val DAIRY_AND_EGGS = 9
        const val FROZEN = 10
        const val CANNED_GOODS = 11
        const val FOR_THE_HOME = 12
        const val TOILETRIES = 13

        val CATEGORY_DESCRIPTIONS = arrayOf(
            "vegetables",
            "fruits",
            "meat and fish",
            "condiments",
            "beverages",
            "snacks",
            "baking and spices",
            "bread and grains",
            "dairy and eggs",
            "frozen",
            "canned goods",
            "for the home",
            "toiletries"
        )

    }

    fun categoryAsString(): String {
        return CATEGORY_DESCRIPTIONS[category]
    }

    override fun toString(): String {
        return "Item(name='$name', category=$category, quantity=$quantity, unit='$unit')"
    }


}