package com.fauzan.quest.data.model

import androidx.compose.ui.graphics.Color

enum class TaskPriority(
    val color: Color,
    val value: String
) {
    HIGH(Color(0xFFFF4444), "High"),
    MEDIUM(Color(0xFFFF8800), "Medium"),
    LOW(Color(0xFF00AA44), "Low")
}