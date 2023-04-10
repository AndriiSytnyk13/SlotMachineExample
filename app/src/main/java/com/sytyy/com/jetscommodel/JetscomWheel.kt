package com.sytyy.com.jetscommodel

import com.sytyy.com.R
import kotlinx.coroutines.delay

data class JetscomWheel(
    private val jetscomDuration: Long,
    var jetscomCurrentSlot: Int = 0,
    var jetscomStart: Boolean = true,
    private val jetscomPicture: JetscomPicListner,
) {

    companion object {
        val jetscomSlots = arrayOf(
            R.drawable.jetscom_slot_1,
            R.drawable.jetscom_slot_2,
            R.drawable.jetscom_slot_3,
            R.drawable.jetscom_slot_4,
            R.drawable.jetscom_slot_5,
            R.drawable.jetscom_slot_6
        )
    }

    suspend fun spinJetscomWheel() {
        while (jetscomStart) {
            delay(jetscomDuration)
            showJetscomSlots()
            jetscomPicture.showJetscomSlotPicture(jetscomSlots[jetscomCurrentSlot])
        }
    }

    fun showJetscomSlots() {
        jetscomCurrentSlot++
        if (jetscomCurrentSlot == jetscomSlots.size)
            jetscomCurrentSlot = 0
    }
}