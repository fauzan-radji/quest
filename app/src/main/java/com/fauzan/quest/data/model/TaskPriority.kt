package com.fauzan.quest.data.model

import androidx.compose.ui.graphics.Color

enum class TaskPriority(
    val color: Color,
    val value: String,
    val weight: Int
) {
    HIGH(
        color = Color(0xFFFF4444),
        value ="High",
        weight = 4
    ),
    MEDIUM(
        color = Color(0xFFFF8800),
        value = "Medium",
        weight = 2
    ),
    LOW(
        color = Color(0xFF00AA44),
        value = "Low",
        weight = 1
    )
}