package utils

fun doubleClamp(value: Double, lowerBound: Double, upperBound: Double): Double{
    if (value < lowerBound){
        return lowerBound
    } else if (value > upperBound){
        return upperBound
    }
    return value
}