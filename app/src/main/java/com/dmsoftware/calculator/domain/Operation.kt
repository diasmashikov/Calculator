package com.dmsoftware.calculator.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('x'),
    DIVIDE('/'),
    PERCENT('%'),
}

val operationSymbols = Operation.values().map { it.symbol }.joinToString("")

fun operationsFromSymbol(symbol: Char): Operation {
    return Operation.values().find { it.symbol == symbol }
        ?: throw IllegalAccessException("Invalid symbol")
}