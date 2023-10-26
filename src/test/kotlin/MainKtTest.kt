import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
    @Test
    fun calculationCommissionMastercard() {
        val sumCommission = calculationCommission(77_000, 0, "Mastercard")
        assertEquals(sumCommission, 32)
    }

    @Test
    fun calculationCommissionMastercardTransfer0() {
        val sumCommission = calculationCommission(0, 0, "Mastercard")
        assertEquals(sumCommission, 0)
    }

    @Test
    fun calculationCommissionMastercardTransfer0BigOldTransfer() {
        val sumCommission = calculationCommission(0, 100_000, "Mastercard")
        assertEquals(sumCommission, 0)
    }

    @Test
    fun calculationCommissionMastercardTransferBigOldTransfer() {
        val sumCommission = calculationCommission(50_000, 50_000, "Mastercard")
        assertEquals(sumCommission, 170)
    }

    @Test
    fun calculationCommissionMastercardTransfer75000() {
        val sumCommission = calculationCommission(50_000, 10_000, "Mastercard")
        assertEquals(sumCommission, 0)
    }

    @Test
    fun calculationCommissionMastercardTransfer30000BigOldTransfer() {
        val sumCommission = calculationCommission(30_000, 100_000, "Mastercard")
        assertEquals(sumCommission, 200)
    }

    @Test
    fun calculationCommissionMaestro() {
        val sumCommission = calculationCommission(77_000, 0, "Maestro")
        assertEquals(sumCommission, 32)
    }

    @Test
    fun calculationCommissionMaestroTransfer0() {
        val sumCommission = calculationCommission(0, 0, "Maestro")
        assertEquals(sumCommission, 0)
    }

    @Test
    fun calculationCommissionMaestroTransfer0BigOldTransfer() {
        val sumCommission = calculationCommission(0, 100_000, "Maestro")
        assertEquals(sumCommission, 0)
    }

    @Test
    fun calculationCommissionMaestroTransferBigOldTransfer() {
        val sumCommission = calculationCommission(50_000, 50_000, "Maestro")
        assertEquals(sumCommission, 170)
    }

    @Test
    fun calculationCommissionMaestroTransfer75000() {
        val sumCommission = calculationCommission(50_000, 10_000, "Maestro")
        assertEquals(sumCommission, 1)
    }

    @Test
    fun calculationCommissionMaestroTransfer30000BigOldTransfer() {
        val sumCommission = calculationCommission(30_000, 100_000, "Maestro")
        assertEquals(sumCommission, 200)
    }

    @Test
    fun calculationCommissionVisa35() {
        val sumCommission = calculationCommission(3000, 0, "Visa")
        assertEquals(sumCommission, 35)
    }

    @Test
    fun calculationCommissionVisaBigTransfer() {
        val sumCommission = calculationCommission(30_000, 0, "Visa")
        assertEquals(sumCommission, 225)
    }

    @Test
    fun calculationCommissionMir35() {
        val sumCommission = calculationCommission(3000, 0, "Mir")
        assertEquals(sumCommission, 35)
    }

    @Test
    fun calculationCommissionMirBigTransfer() {
        val sumCommission = calculationCommission(30_000, 0, "Mir")
        assertEquals(sumCommission, 225)
    }

    @Test
    fun calculationCommissionVKPay() {
        val sumCommission = calculationCommission(2000, 0, "VK Pay")
        assertEquals(sumCommission, 0)
    }

    @Test
    fun calculationCommissionNullCard() {
        val sumCommission = calculationCommission(90000, 0, "Странная карта")
        assertEquals(sumCommission, 0)
    }

    @Test
    fun calculationCommissionCardSave() {
        val sumCommission = calculationCommission(1000, 0)
        assertEquals(sumCommission, 0)
    }
}