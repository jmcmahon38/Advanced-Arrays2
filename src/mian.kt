import javax.management.openmbean.ArrayType
val favoriteThings = arrayOf(
    "Raindrops on roses", "Whiskers on kittens", "Bright copper kettles",
    "Warm woolen mittens", "Brown paper packages tied up with strings")
val favoriteThingsQty = arrayOf( "10", "11", "12", "13", "14" )


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


fun checkInventory(array1: Array<String>, array2: Array<String>){
    var inventoryDetails = arrayOf<Array<String>>()
    inventoryDetails += array1
    inventoryDetails += array2
    var inventorySize = inventoryDetails[0].size -1
    for (i in 0..inventorySize) {
        var itemName = inventoryDetails[0][i]
        var itemQty = inventoryDetails[1][i]
        print("$itemName : $itemQty \n")
    }

}

fun changeInventory(array1: Array<String>, array2: Array<String>) {
    var inventoryDetails = arrayOf<Array<String>>()
    inventoryDetails += array1
    inventoryDetails += array2
    var inventorySize = inventoryDetails[0].size - 1
    println("You have selected change inventory\n")
    for (i in 0..inventorySize) {
        var itemName = inventoryDetails[0][i]
        var itemQty = inventoryDetails[1][i]
        print("item #${i + 1} : $itemName : $itemQty\n")
    }
    var selectionNum = 0
    print(
        "please select the number 1-${inventorySize+1} for the item you wish to change\n" +
                "type exit to exit\n"
    )

    selectionNum = (readLine()!!.toInt()-1)
    var selectedItem = inventoryDetails[0][selectionNum]
    var selectedQty = inventoryDetails[1][selectionNum]

    print(
        "you have selected ${selectedItem} \n" +
                "current quantity: ${selectedQty}\n\n" +
                "please enter an amount to add or subtract from existing quantity:\n" +
                "(use negative numbers for subtractions)\n"
    )
    var newQty = readLine()!!.toInt()
    newQty += selectedQty.toInt()
    if (newQty <= 0) {
        println("Error: selected amount will reduce QOH to less than 0\n" +
                "changing $selectedItem quantity to 0\n")
        selectedQty = "0"
    }
    else {
        selectedQty = newQty.toString()
        println(
            "new values: \n" +
                    "Name: $selectedItem \n" +
                    "Qty: $selectedQty"
        )
    }
}

fun main() {
    // inventory

    var finished = false
    while (finished != true ) {
        when (menu()) {
            1 -> checkInventory(favoriteThings, favoriteThingsQty)
            2 -> changeInventory(favoriteThings, favoriteThingsQty)
            3 -> break
            !in 1..3 -> println("that is an invalid selection")
            else -> println("That is not a valid selection")
        }
    }

}



