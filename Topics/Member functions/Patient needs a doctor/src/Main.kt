class Patient(val name: String) {
    // write the say method here
    fun say():Unit {
        println("Hello, my name is ${this.name}, I need a doctor.")
    }
}