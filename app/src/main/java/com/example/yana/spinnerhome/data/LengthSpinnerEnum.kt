package com.example.yana.spinnerhome.data

enum class LengthSpinnerEnum(val valueName: String, val value: Double) {
    MILLIMETR("Миллиметр", 0.01),
    SANTIMETR("Сантиметр", 0.1),
    METR("Метр", 10.0),
    KILOMETR("Километр", 1000.0),
    MILYA("Миля", 1609.0),
    YARD("Ярд", 914.0),
    FUT("Фут", 304.0),
    DUIM("Дюйм", 25.4)
}