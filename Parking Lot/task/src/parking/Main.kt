package parking

fun main() {
    var create = readln()
    while (create.split(" ")[0] != "create" && create.split(" ")[0] != "exit") {
        println("Sorry, a parking lot has not been created.")
        create = readln()
    }


    if (create != "exit") {
        var size = create.split(" ")[1]

        class car(var name: String, var color: String) {
        }

        var park = MutableList(size.toInt()) { car("free", "free") }
        println("Created a parking lot with $size spots.")

        var user = readln()
        while (user != "exit") {
            val order = user.split(" ")[0]
            var okay = false
            loop@ for (spot in park) {
                if (spot.name == "free") {
                    okay = true
                    break@loop
                }
            }
            if (order == "park") {
                var index = 0
                if (okay) {
                    loop@ for (spot in park) {
                        if (spot.name == "free") {
                            val name = user.split(" ")[1]
                            val color = user.split(" ")[2]
                            park[index] = car(name, color)
                            println("${color} car parked in spot ${index + 1}.")
                            break@loop
                        }
                        index = index + 1
                    }

                }
                else println("Sorry, the parking lot is full.")
            } else if (order == "leave") {
                val num = user.split(" ")[1].toInt()
                if (park[num - 1].name != "free") {
                    park[num - 1] = car("free", "free")
                    println("Spot ${num} is free.")
                } else println("There is no car in spot $num.")
            } else if (order == "status") {
                var count = 0
                var empty = true
                for (spot in park) {
                    if (spot.name != "free") {
                        println("${count + 1} ${spot.name} ${spot.color}")
                        empty = false
                    }
                    count = count + 1
                }
                if (empty) println("Parking lot is empty.")
            } else if (order == "create") {
                size = user.split(" ")[1]
                park = MutableList(size.toInt()) { car("free", "free") }
                println("Created a parking lot with $size spots.")
            } else if (order == "reg_by_color") {
                val list = mutableListOf<String>()
                val color = user.split(" ")[1]
                for (car in park) {
                    if (car.color.lowercase() == color.lowercase()) list.add(car.name)
                }
                if (list.isEmpty()) {
                    println("No cars with color $color were found.")
                } else {
                    println(list.joinToString())
                }
            } else if (order == "spot_by_reg") {
                val list = mutableListOf<Int>()
                val name = user.split(" ")[1]
                var index = 1
                for (car in park) {
                    if (car.name.lowercase() == name.lowercase()) list.add(index)
                    index = index + 1
                }
                if (list.isEmpty()) {
                    println("No cars with registration number $name were found.")
                } else {
                    println(list.joinToString())
                }
            } else if (order == "spot_by_color") {
                val list = mutableListOf<Int>()
                val color = user.split(" ")[1]
                var index = 1
                for (car in park) {
                    if (car.color.lowercase() == color.lowercase()) list.add(index)
                    index = index + 1
                }
                if (list.isEmpty()) {
                    println("No cars with color $color were found.")
                } else {
                    println(list.joinToString())
                }

            }
            user = readln()
        }

    }
}

