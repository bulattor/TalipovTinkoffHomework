package ru.tinkoff.fintech.task5

class GCListService {
    private val exchangeRate = 0.01;

    private fun getDescription(it: GraphicsCard) : String {
        return it.chipset + " " + it.name + " " + it.memory + "GB by " + it.brand + " - " + it.price * exchangeRate + " USD"
    }

    fun sortByPrice(cards: Collection<GraphicsCard>) : Sequence<String> {
        return cards.asSequence().sortedBy { it.price }.map { getDescription(it) }
    }

    fun groupByBrand(cards: Collection<GraphicsCard>) : Map<String, List<String>> {
        return cards.groupBy(keySelector = { it.brand }, valueTransform = { getDescription(it) })
    }

    fun countByPredicate(cards: Collection<GraphicsCard>, predicate: (GraphicsCard) -> (Boolean)) : Pair<Int, List<String>> {
        val sequence = cards.asSequence().filter { predicate(it) }
        val first = sequence.count()
        val second = sequence.take(3).map { it.brand + " " + it.name }.toList()
        return Pair(first,second)
    }
}