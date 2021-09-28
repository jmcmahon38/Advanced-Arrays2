import java.lang.NumberFormatException

//menu
fun menu(): Int{
    var selectionNum = 0
    print("\n Please select an option\n" +
            "1. Check inventory\n" +
            "2. Change inventory\n" +
            "3. Exit\n")
    selectionNum = readLine()!!.toInt()
    return selectionNum
}

fun checkInventory(array1: Array<Array<String>>){

    var inventorySize = array1[0].size -1
    for (i in 0..inventorySize) {
        var itemName = array1[0][i]
        var itemQty = array1[1][i]
        print("$itemName : $itemQty \n")
    }

}

fun changeInventory(array1: Array<Array<String>>): Array<Array<String>> {

    var inventorySize = array1[0].size - 1
    println("You have selected change inventory\n")
    for (i in 0..inventorySize) {
        var itemName = array1[0][i]
        var itemQty = array1[1][i]
        print("item #${i + 1} : $itemName : $itemQty\n")
    }
    var selectionNum = 0

    print("please select the number 1-${inventorySize + 1} for the item you wish to change\n")
    selectionNum = (readLine()!!.toInt() -1)


    var selectedItem = array1[0][selectionNum]
    var selectedQty = array1[1][selectionNum]
    print(
        "you have selected ${selectedItem} \n" +
                "current quantity: ${selectedQty}\n\n" +
                "please enter an amount to add or subtract from existing quantity:\n" +
                "(use negative numbers for subtractions)\n"
    )
    var newQty = readLine()!!.toInt()
    newQty += selectedQty.toInt()
    if (newQty < 0) {
        println("Error: selected amount will reduce QOH to less than 0\n" +
                "changing $selectedItem quantity to 0\n")
        newQty = 0
        selectedQty = newQty.toString()
        array1[1][selectionNum] = selectedQty

    }
    else {
        selectedQty = newQty.toString()
        array1[1][selectionNum] = selectedQty
        println(
            "new values: \n" +
                    "Name: $selectedItem \n" +
                    "Qty: $selectedQty"
        )
    }
    return array1
}

fun main() {
    // inventory
    val favoriteThings = arrayOf(
        "Raindrops on roses", "Whiskers on kittens", "Bright copper kettles",
        "Warm woolen mittens", "Brown paper packages tied up with strings")
    val favoriteThingsQty = arrayOf( "10", "11", "12", "13", "14" )
    var inventoryDetails = arrayOf<Array<String>>()
    inventoryDetails+= favoriteThings
    inventoryDetails+= favoriteThingsQty

    var finished = false
    while (finished != true ) {
        when (menu()) {
            1 -> checkInventory(inventoryDetails)
            2 -> inventoryDetails = changeInventory(inventoryDetails)
            3 -> break
            !in 1..3 -> println("that is an invalid selection")
            else -> println("That is not a valid selection")
        }
    }

}



