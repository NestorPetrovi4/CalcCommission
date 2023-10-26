import kotlin.math.max

fun main() {
    val cardName = "Visa"
    val sumTransfer = 100000
    val sumOldTransfer = 74000
    val sumCardDay = 0
    val sumCardMonth = 450000

    when {
        cardName == "VK Pay" && (sumTransfer > 15_000 || sumTransfer + sumOldTransfer > 40_000) -> {
            println("Превышен лимит переводов VK Pay")
            return
        }
        cardName != "VK Pay" && (sumTransfer + sumCardDay > 150_000 || sumTransfer + sumCardMonth > 600_000) ->{
            println("Превышен лимит по карте $cardName")
            return
        }
    }
    val sumCommission = calculationCommission(sumTransfer, sumOldTransfer, cardName)
    println(sumCommission)
}

fun calculationCommission(sumTransfer: Int, sumOldTransfer: Int, cardName: String = "VK Pay"): Int {
    return when (cardName) {
        "Mastercard", "Maestro" -> commissionMastercard(sumTransfer, sumOldTransfer)
        "Visa", "Mir" -> max((sumTransfer * 0.75) / 100, 35.0).toInt()
        "VK Pay" -> 0
        else -> 0
    }
}

fun commissionMastercard(sumTransfer: Int, sumOldTransfer: Int): Int {
    return when {
        sumTransfer <= 0 || (sumTransfer + sumOldTransfer < 75_000) -> 0
        sumOldTransfer > 75_000 -> ((sumTransfer * 0.6) / 100 + 20).toInt()
        else -> (((sumTransfer + sumOldTransfer - 75_000) * 0.6) / 100 + 20).toInt()
    }
}
