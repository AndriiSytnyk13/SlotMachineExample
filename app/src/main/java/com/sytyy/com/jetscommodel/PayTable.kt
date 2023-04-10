package com.sytyy.com.jetscommodel

import com.sytyy.com.R

enum class PayTable(val image1: Int, val image2: Int, val image3: Int? = null, val pay: Int) {
    SLOT1_3(R.drawable.jetscom_slot_2, R.drawable.jetscom_slot_2, R.drawable.jetscom_slot_2, 100),
    SLOT2_3(R.drawable.jetscom_slot_3, R.drawable.jetscom_slot_3, R.drawable.jetscom_slot_3, 200),
    SLOT3_3(R.drawable.jetscom_slot_4, R.drawable.jetscom_slot_4, R.drawable.jetscom_slot_4, 300),
    SLOT4_3(R.drawable.jetscom_slot_5, R.drawable.jetscom_slot_5, R.drawable.jetscom_slot_5, 400),
    SLOT5_3(R.drawable.jetscom_slot_6, R.drawable.jetscom_slot_6, R.drawable.jetscom_slot_6, 500),
    SLOT6_3(R.drawable.jetscom_slot_1, R.drawable.jetscom_slot_1, R.drawable.jetscom_slot_1, 700),
    SLOT1_2(R.drawable.jetscom_slot_2, R.drawable.jetscom_slot_2, pay = 10),
    SLOT2_2(R.drawable.jetscom_slot_3, R.drawable.jetscom_slot_3, pay = 20),
    SLOT3_2(R.drawable.jetscom_slot_4, R.drawable.jetscom_slot_4, pay = 30),
    SLOT4_2(R.drawable.jetscom_slot_5, R.drawable.jetscom_slot_5, pay = 40),
    SLOT5_2(R.drawable.jetscom_slot_6, R.drawable.jetscom_slot_6, pay = 50),
    SLOT6_2(R.drawable.jetscom_slot_1, R.drawable.jetscom_slot_1, pay = 60)
}