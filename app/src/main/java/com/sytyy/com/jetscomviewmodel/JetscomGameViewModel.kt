package com.sytyy.com.jetscomviewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sytyy.com.jetscommodel.JetscomPicListner
import com.sytyy.com.jetscommodel.JetscomWheel
import com.sytyy.com.jetscommodel.JetscomWheel.Companion.jetscomSlots
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class JetscomGameViewModel : ViewModel() {

    private val _jetscomCurrentScore = MutableStateFlow(0)
    val jetscomCurrentScore = _jetscomCurrentScore.asStateFlow()

    private val _jetscomSpinVisibility = MutableStateFlow(View.VISIBLE)
    val jetscomSpinVisibility = _jetscomSpinVisibility.asStateFlow()

    private val _jetscomSlot1Pic =
        MutableStateFlow(jetscomSlots[Random.nextInt(0, 5)])
    val jetscomSlot1Pic = _jetscomSlot1Pic.asStateFlow()

    private val _jetscomSlot2Pic =
        MutableStateFlow(jetscomSlots[Random.nextInt(0, 5)])
    val jetscomSlot2Pic = _jetscomSlot2Pic.asStateFlow()

    private val _jetscomSlot3Pic =
        MutableStateFlow(jetscomSlots[Random.nextInt(0, 5)])
    val jetscomSlot3Pic = _jetscomSlot3Pic.asStateFlow()

    private val _jetscomSlot1 = MutableStateFlow<JetscomWheel?>(null)
    private val _jetscomSlot2 = MutableStateFlow<JetscomWheel?>(null)
    private val _jetscomSlot3 = MutableStateFlow<JetscomWheel?>(null)

    private var isJetscomIsSpinning = false

    fun jetscomStartSpin() {
        if (!isJetscomIsSpinning) {
            _jetscomSpinVisibility.value = View.GONE
            viewModelScope.launch {
                launch {
                    _jetscomSlot1.value =
                        JetscomWheel(50, jetscomPicture = object : JetscomPicListner {
                            override fun showJetscomSlotPicture(jetscomPic: Int) {
                                _jetscomSlot1Pic.value = jetscomPic
                            }
                        })
                    _jetscomSlot1.value!!.spinJetscomWheel()
                }
                launch {
                    _jetscomSlot2.value =
                        JetscomWheel(20, jetscomPicture = object : JetscomPicListner {
                            override fun showJetscomSlotPicture(jetscomPic: Int) {
                                _jetscomSlot2Pic.value = jetscomPic
                            }
                        })
                    _jetscomSlot2.value!!.spinJetscomWheel()
                }
                launch {
                    _jetscomSlot3.value =
                        JetscomWheel(27, jetscomPicture = object : JetscomPicListner {
                            override fun showJetscomSlotPicture(jetscomPic: Int) {
                                _jetscomSlot3Pic.value = jetscomPic
                            }
                        })
                    _jetscomSlot3.value!!.spinJetscomWheel()
                }
                isJetscomIsSpinning = true
                delay(Random.nextLong(1000, 5000))
                jetscomStopSpin()
            }
        }
    }

    fun jetscomStopSpinWhenNavigateToPayTable() {
        _jetscomSlot1.value?.jetscomStart = false
        _jetscomSlot2.value?.jetscomStart = false
        _jetscomSlot3.value?.jetscomStart = false
        isJetscomIsSpinning = false
        _jetscomSpinVisibility.value = View.VISIBLE
    }

    private fun jetscomStopSpin() {
        _jetscomSlot1.value?.jetscomStart = false
        _jetscomSlot2.value?.jetscomStart = false
        _jetscomSlot3.value?.jetscomStart = false
        isJetscomIsSpinning = false
        _jetscomSpinVisibility.value = View.VISIBLE
        getJetscomPonts()
    }

    private fun sumJetscomPoints(jetscomPoints: Int) {
        _jetscomCurrentScore.value = _jetscomCurrentScore.value.plus(jetscomPoints)
    }

    private fun getJetscomPonts() {
        for (i in jetscomSlots.indices) {
            if (_jetscomSlot1.value!!.jetscomCurrentSlot == i && _jetscomSlot2.value!!.jetscomCurrentSlot == i && _jetscomSlot3.value!!.jetscomCurrentSlot == i) {
                sumJetscomPoints(100 + (i * 100))
            } else if (
                _jetscomSlot1.value!!.jetscomCurrentSlot == i && _jetscomSlot2.value!!.jetscomCurrentSlot == i ||
                _jetscomSlot2.value!!.jetscomCurrentSlot == i && _jetscomSlot3.value!!.jetscomCurrentSlot == i ||
                _jetscomSlot3.value!!.jetscomCurrentSlot == i && _jetscomSlot1.value!!.jetscomCurrentSlot == i
            ) {
                sumJetscomPoints(10 + (i * 10))
            }
        }
    }
}