/*
 * KOTLIN TOUR — ATIVIDADES RESOLVIDAS
 *
 * Beginner + Intermediate
 *
 * Organização:
 *   BEGINNER
 *     01 - Hello world
 *     02 - Basic types
 *     03 - Collections
 *     04 - Control flow
 *     05 - Functions
 *     06 - Classes
 *     07 - Null safety
 *
 *   INTERMEDIATE
 *     08 - Extension functions
 *     09 - Scope functions
 *     10 - Lambda expressions with receiver
 *     11 - Classes and interfaces
 *     12 - Objects
 *     13 - Open and special classes
 *     14 - Properties
 *     15 - Null safety
 *     16 - Libraries and APIs
 *
 * Fonte:
 * https://kotlinlang.org/docs/kotlin-tour-welcome.html
 */

import kotlin.math.PI
import kotlin.math.pow
import kotlin.random.Random
import kotlin.properties.Delegates.observable
import kotlin.time.measureTime


// ============================================================
// BEGINNER
// ============================================================


// ------------------------------------------------------------
// 01 - HELLO WORLD
// Exercício 1
// ------------------------------------------------------------

object Beginner01HelloWorld {
    fun main() {
        val name = "Mary"
        val age = 20

        println("$name is $age years old")
    }
}


// ------------------------------------------------------------
// 02 - BASIC TYPES
// Exercício 1
// ------------------------------------------------------------

object Beginner02BasicTypes {
    fun main() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'

        println("$a $b $c $d $e $f")
    }
}


// ------------------------------------------------------------
// 03 - COLLECTIONS
// Exercício 1
// ------------------------------------------------------------

object Beginner03CollectionsExercise01 {
    fun main() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)

        val totalCount = greenNumbers.count() + redNumbers.count()

        println(totalCount)
    }
}


// Exercício 2

object Beginner03CollectionsExercise02 {
    fun main() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"

        val isSupported = requested.uppercase() in SUPPORTED

        println("Support for $requested: $isSupported")
    }
}


// Exercício 3

object Beginner03CollectionsExercise03 {
    fun main() {
        val number2word = mapOf(
            1 to "one",
            2 to "two",
            3 to "three"
        )

        val n = 2

        println("$n is spelt as '${number2word[n]}'")
    }
}


// ------------------------------------------------------------
// 04 - CONTROL FLOW
// Exercício 1
// ------------------------------------------------------------

object Beginner04ControlFlowExercise01 {
    fun main() {
        val firstResult = Random.nextInt(6)
        val secondResult = Random.nextInt(6)

        if (firstResult == secondResult) {
            println("You win :)")
        } else {
            println("You lose :(")
        }
    }
}


// Exercício 2

object Beginner04ControlFlowExercise02 {
    fun main() {
        val button = "A"

        println(
            when (button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no such button"
            }
        )
    }
}


// Exercício 3 — while

object Beginner04ControlFlowExercise03 {
    fun main() {
        var pizzaSlices = 0

        while (pizzaSlices < 8) {
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        }

        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }
}


// Exercício 3 — do-while

object Beginner04ControlFlowExercise03DoWhile {
    fun main() {
        var pizzaSlices = 0

        do {
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        } while (pizzaSlices < 8)

        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }
}


// Exercício 4

object Beginner04ControlFlowExercise04 {
    fun main() {
        for (number in 1..100) {
            println(
                when {
                    number % 15 == 0 -> "fizzbuzz"
                    number % 3 == 0 -> "fizz"
                    number % 5 == 0 -> "buzz"
                    else -> "$number"
                }
            )
        }
    }
}


// Exercício 5

object Beginner04ControlFlowExercise05 {
    fun main() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")

        for (w in words) {
            if (w.startsWith("l")) {
                println(w)
            }
        }
    }
}


// ------------------------------------------------------------
// 05 - FUNCTIONS
// Exercício 1
// ------------------------------------------------------------

object Beginner05FunctionsExercise01 {
    fun circleArea(radius: Int): Double {
        return PI * radius * radius
    }

    fun main() {
        println(circleArea(2))
    }
}


// Exercício 2

object Beginner05FunctionsExercise02 {
    fun circleArea(radius: Int): Double = PI * radius * radius

    fun main() {
        println(circleArea(2))
    }
}


// Exercício 3

object Beginner05FunctionsExercise03 {
    fun intervalInSeconds(
        hours: Int = 0,
        minutes: Int = 0,
        seconds: Int = 0
    ) = ((hours * 60) + minutes) * 60 + seconds

    fun main() {
        println(intervalInSeconds(1, 20, 15))
        println(intervalInSeconds(minutes = 1, seconds = 25))
        println(intervalInSeconds(hours = 2))
        println(intervalInSeconds(minutes = 10))
        println(intervalInSeconds(hours = 1, seconds = 1))
    }
}


// ------------------------------------------------------------
// 06 - CLASSES
// Exercício 1
// ------------------------------------------------------------

object Beginner06ClassesExercise01 {
    data class Employee(
        val name: String,
        var salary: Int
    )

    fun main() {
        val emp = Employee("Mary", 20)

        println(emp)

        emp.salary += 10

        println(emp)
    }
}


// Exercício 2

object Beginner06ClassesExercise02 {
    data class Person(
        val name: Name,
        val address: Address,
        val ownsAPet: Boolean = true
    )

    data class Name(
        val first: String,
        val last: String
    )

    data class Address(
        val street: String,
        val city: City
    )

    data class City(
        val name: String,
        val countryCode: String
    )

    fun main() {
        val person = Person(
            Name("John", "Smith"),
            Address("123 Fake Street", City("Springfield", "US")),
            ownsAPet = false
        )

        println(person)
    }
}


// Exercício 3

object Beginner06ClassesExercise03 {
    data class Employee(
        val name: String,
        var salary: Int
    )

    class RandomEmployeeGenerator(
        var minSalary: Int,
        var maxSalary: Int
    ) {
        val names = listOf(
            "John",
            "Mary",
            "Ann",
            "Paul",
            "Jack",
            "Elizabeth"
        )

        fun generateEmployee() =
            Employee(
                names.random(),
                Random.nextInt(
                    from = minSalary,
                    until = maxSalary
                )
            )
    }

    fun main() {
        val empGen = RandomEmployeeGenerator(10, 30)

        println(empGen.generateEmployee())
        println(empGen.generateEmployee())
        println(empGen.generateEmployee())

        empGen.minSalary = 50
        empGen.maxSalary = 100

        println(empGen.generateEmployee())
    }
}


// ------------------------------------------------------------
// 07 - NULL SAFETY
// Exercício 1
// ------------------------------------------------------------

object Beginner07NullSafety {
    data class Employee(
        val name: String,
        var salary: Int
    )

    fun employeeById(id: Int) = when (id) {
        1 -> Employee("Mary", 20)
        2 -> null
        3 -> Employee("John", 21)
        4 -> Employee("Ann", 23)
        else -> null
    }

    fun salaryById(id: Int) =
        employeeById(id)?.salary ?: 0

    fun main() {
        println((1..5).sumOf { id -> salaryById(id) })
    }
}


// ============================================================
// INTERMEDIATE
// ============================================================


// ------------------------------------------------------------
// 08 - EXTENSION FUNCTIONS
// Exercício 1
// ------------------------------------------------------------

object Intermediate08ExtensionFunctionsExercise01 {
    fun Int.isPositive(): Boolean = this > 0

    fun main() {
        println(1.isPositive())
    }
}


// Exercício 2

object Intermediate08ExtensionFunctionsExercise02 {
    fun String.toLowercaseString(): String = this.lowercase()

    fun main() {
        println("Hello World!".toLowercaseString())
    }
}


// ------------------------------------------------------------
// 09 - SCOPE FUNCTIONS
// Exercício 1
// ------------------------------------------------------------

object Intermediate09ScopeFunctionsExercise01 {
    data class ProductInfo(
        val priceInDollars: Double?
    )

    class Product {
        fun getProductInfo(): ProductInfo? {
            return ProductInfo(100.0)
        }
    }

    fun Product.getPriceInEuros() =
        getProductInfo()?.priceInDollars?.let {
            convertToEuros(it)
        }

    fun convertToEuros(dollars: Double): Double {
        return dollars * 0.85
    }

    fun main() {
        val product = Product()
        val priceInEuros = product.getPriceInEuros()

        if (priceInEuros != null) {
            println("Price in Euros: €$priceInEuros")
        } else {
            println("Price information is not available.")
        }
    }
}


// Exercício 2

object Intermediate09ScopeFunctionsExercise02 {
    data class User(
        val id: Int,
        var email: String
    )

    fun updateEmail(
        user: User,
        newEmail: String
    ): User = user.apply {
        this.email = newEmail
    }.also {
        println("Updating email for user with ID: ${it.id}")
    }

    fun main() {
        val user = User(
            1,
            "old_email@example.com"
        )

        val updatedUser =
            updateEmail(
                user,
                "new_email@example.com"
            )

        println("Updated User: $updatedUser")
    }
}


// ------------------------------------------------------------
// 10 - LAMBDA EXPRESSIONS WITH RECEIVER
// Exercício 1
// ------------------------------------------------------------

object Intermediate10LambdaWithReceiverExercise01 {
    fun fetchData(
        callback: StringBuilder.() -> Unit
    ) {
        val builder = StringBuilder("Data received")
        builder.callback()
    }

    fun main() {
        fetchData {
            append(" - Processed")
            println(this.toString())
        }
    }
}


// Exercício 2

object Intermediate10LambdaWithReceiverExercise02 {
    class Button {
        fun onEvent(
            action: ButtonEvent.() -> Unit
        ) {
            val event = ButtonEvent(
                isRightClick = false,
                amount = 2,
                position = Position(100, 200)
            )

            event.action()
        }
    }

    data class ButtonEvent(
        val isRightClick: Boolean,
        val amount: Int,
        val position: Position
    )

    data class Position(
        val x: Int,
        val y: Int
    )

    fun main() {
        val button = Button()

        button.onEvent {
            if (!isRightClick && amount == 2) {
                println("Double click!")
            }
        }
    }
}


// ------------------------------------------------------------
// 11 - CLASSES AND INTERFACES
// Exercício 1
// ------------------------------------------------------------

object Intermediate11ClassesInterfacesExercise01 {
    abstract class SmartDevice(
        val name: String
    ) {
        abstract fun turnOn()
        abstract fun turnOff()
    }

    class SmartLight(
        name: String
    ) : SmartDevice(name) {

        override fun turnOn() {
            println("$name is now ON.")
        }

        override fun turnOff() {
            println("$name is now OFF.")
        }

        fun adjustBrightness(level: Int) {
            println("Adjusting $name brightness to $level%.")
        }
    }

    class SmartThermostat(
        name: String
    ) : SmartDevice(name) {

        override fun turnOn() {
            println("$name thermostat is now heating.")
        }

        override fun turnOff() {
            println("$name thermostat is now off.")
        }

        fun adjustTemperature(temperature: Int) {
            println("$name thermostat set to $temperature°C.")
        }
    }

    fun main() {
        val livingRoomLight =
            SmartLight("Living Room Light")

        val bedroomThermostat =
            SmartThermostat("Bedroom Thermostat")

        livingRoomLight.turnOn()
        livingRoomLight.adjustBrightness(10)
        livingRoomLight.turnOff()

        bedroomThermostat.turnOn()
        bedroomThermostat.adjustTemperature(5)
        bedroomThermostat.turnOff()
    }
}


// Exercício 2

object Intermediate11ClassesInterfacesExercise02 {
    interface Media {
        val title: String
        fun play()
    }

    class Audio(
        override val title: String,
        val composer: String
    ) : Media {

        override fun play() {
            println(
                "Playing audio: $title, composed by $composer"
            )
        }
    }

    fun main() {
        val audio =
            Audio("Symphony No. 5", "Beethoven")

        audio.play()
    }
}


// Exercício 3

object Intermediate11ClassesInterfacesExercise03 {
    interface Refundable {
        fun refund(amount: Double)
    }

    abstract class PaymentMethod(
        val name: String
    ) {
        fun authorize(amount: Double) {
            println("Authorizing payment of $$amount.")
        }

        abstract fun processPayment(amount: Double)
    }

    class CreditCard(
        name: String
    ) : PaymentMethod(name), Refundable {

        override fun processPayment(amount: Double) {
            println(
                "Processing credit card payment of $$amount."
            )
        }

        override fun refund(amount: Double) {
            println(
                "Refunding $$amount to the credit card."
            )
        }
    }

    fun main() {
        val visa = CreditCard("Visa")

        visa.authorize(100.0)
        visa.processPayment(100.0)
        visa.refund(50.0)
    }
}


// Exercício 4

object Intermediate11ClassesInterfacesExercise04 {
    interface Messenger {
        fun sendMessage(message: String)
        fun receiveMessage(): String
    }

    class BasicMessenger : Messenger {

        override fun sendMessage(message: String) {
            println("Sending message: $message")
        }

        override fun receiveMessage(): String {
            return "You've got a new message!"
        }
    }

    class SmartMessenger(
        val basicMessenger: BasicMessenger
    ) : Messenger by basicMessenger {

        override fun sendMessage(message: String) {
            println("Sending a smart message: $message")
            basicMessenger.sendMessage("[smart] $message")
        }
    }

    fun main() {
        val basicMessenger = BasicMessenger()
        val smartMessenger =
            SmartMessenger(basicMessenger)

        basicMessenger.sendMessage("Hello!")
        println(smartMessenger.receiveMessage())

        smartMessenger.sendMessage(
            "Hello from SmartMessenger!"
        )
    }
}


// ------------------------------------------------------------
// 12 - OBJECTS
// Exercício 1
// ------------------------------------------------------------

object Intermediate12ObjectsExercise01 {
    interface Order {
        val orderId: String
        val customerName: String
        val orderTotal: Double
    }

    data object OrderOne : Order {
        override val orderId = "001"
        override val customerName = "Alice"
        override val orderTotal = 15.50
    }

    data object OrderTwo : Order {
        override val orderId = "002"
        override val customerName = "Bob"
        override val orderTotal = 12.75
    }

    fun main() {
        println("Order name: $OrderOne")
        println("Order name: $OrderTwo")

        println(
            "Are the two orders identical? " +
                "${OrderOne == OrderTwo}"
        )

        if (OrderOne == OrderTwo) {
            println("The orders are identical.")
        } else {
            println("The orders are unique.")
        }

        println(
            "Do the orders have the same customer name? " +
                "${OrderOne.customerName == OrderTwo.customerName}"
        )
    }
}


// Exercício 2

object Intermediate12ObjectsExercise02 {
    interface Vehicle {
        val name: String
        fun move(): String
    }

    object FlyingSkateboard : Vehicle {

        override val name =
            "Flying Skateboard"

        override fun move() =
            "Glides through the air with a hover engine"

        fun fly(): String =
            "Woooooooo"
    }

    fun main() {
        println(
            "${FlyingSkateboard.name}: " +
                FlyingSkateboard.move()
        )

        println(
            "${FlyingSkateboard.name}: " +
                FlyingSkateboard.fly()
        )
    }
}


// Exercício 3

object Intermediate12ObjectsExercise03 {
    data class Temperature(
        val celsius: Double
    ) {
        val fahrenheit: Double =
            celsius * 9 / 5 + 32

        companion object {
            fun fromFahrenheit(
                fahrenheit: Double
            ): Temperature =
                Temperature(
                    (fahrenheit - 32) * 5 / 9
                )
        }
    }

    fun main() {
        val fahrenheit = 90.0

        val temp =
            Temperature.fromFahrenheit(fahrenheit)

        println(
            "${temp.celsius}°C is $fahrenheit °F"
        )
    }
}


// ------------------------------------------------------------
// 13 - OPEN AND SPECIAL CLASSES
// Exercício 1
// ------------------------------------------------------------

object Intermediate13OpenSpecialClassesExercise01 {
    sealed class DeliveryStatus {

        data class Pending(
            val sender: String
        ) : DeliveryStatus()

        data class InTransit(
            val estimatedDeliveryDate: String
        ) : DeliveryStatus()

        data class Delivered(
            val deliveryDate: String,
            val recipient: String
        ) : DeliveryStatus()

        data class Canceled(
            val reason: String
        ) : DeliveryStatus()
    }

    fun printDeliveryStatus(
        status: DeliveryStatus
    ) {
        when (status) {
            is DeliveryStatus.Pending -> {
                println(
                    "The package is pending pickup " +
                        "from ${status.sender}."
                )
            }

            is DeliveryStatus.InTransit -> {
                println(
                    "The package is in transit and " +
                        "expected to arrive by " +
                        "${status.estimatedDeliveryDate}."
                )
            }

            is DeliveryStatus.Delivered -> {
                println(
                    "The package was delivered to " +
                        "${status.recipient} on " +
                        "${status.deliveryDate}."
                )
            }

            is DeliveryStatus.Canceled -> {
                println(
                    "The delivery was canceled due to: " +
                        "${status.reason}."
                )
            }
        }
    }

    fun main() {
        val status1: DeliveryStatus =
            DeliveryStatus.Pending("Alice")

        val status2: DeliveryStatus =
            DeliveryStatus.InTransit("2024-11-20")

        val status3: DeliveryStatus =
            DeliveryStatus.Delivered(
                "2024-11-18",
                "Bob"
            )

        val status4: DeliveryStatus =
            DeliveryStatus.Canceled(
                "Address not found"
            )

        printDeliveryStatus(status1)
        printDeliveryStatus(status2)
        printDeliveryStatus(status3)
        printDeliveryStatus(status4)
    }
}


// Exercício 2

object Intermediate13OpenSpecialClassesExercise02 {
    sealed class Status {

        data object Loading : Status()

        data class Error(
            val problem: Problem
        ) : Status() {

            enum class Problem {
                NETWORK,
                TIMEOUT,
                UNKNOWN
            }
        }

        data class OK(
            val data: List<String>
        ) : Status()
    }

    fun handleStatus(status: Status) {
        when (status) {
            is Status.Loading ->
                println("Loading...")

            is Status.OK ->
                println("Data received: ${status.data}")

            is Status.Error ->
                when (status.problem) {
                    Status.Error.Problem.NETWORK ->
                        println("Network issue")

                    Status.Error.Problem.TIMEOUT ->
                        println("Request timed out")

                    Status.Error.Problem.UNKNOWN ->
                        println("Unknown error occurred")
                }
        }
    }

    fun main() {
        val status1: Status =
            Status.Error(
                Status.Error.Problem.NETWORK
            )

        val status2: Status =
            Status.OK(listOf("Data1", "Data2"))

        handleStatus(status1)
        handleStatus(status2)
    }
}


// ------------------------------------------------------------
// 14 - PROPERTIES
// Exercício 1
// ------------------------------------------------------------

object Intermediate14PropertiesExercise01 {
    fun findOutOfStockBooks(
        inventory: List<Int>
    ): List<Int> {

        val outOfStockIndices =
            mutableListOf<Int>()

        for (index in inventory.indices) {
            if (inventory[index] == 0) {
                outOfStockIndices.add(index)
            }
        }

        return outOfStockIndices
    }

    fun main() {
        val inventory =
            listOf(3, 0, 7, 0, 5)

        println(findOutOfStockBooks(inventory))
    }
}


// Exercício 2

object Intermediate14PropertiesExercise02 {
    val Double.asMiles: Double
        get() = this * 0.621371

    fun main() {
        val distanceKm = 5.0

        println(
            "$distanceKm km is ${distanceKm.asMiles} miles"
        )

        val marathonDistance = 42.195

        println(
            "$marathonDistance km is " +
                "${marathonDistance.asMiles} miles"
        )
    }
}


// Exercício 3

object Intermediate14PropertiesExercise03 {
    fun checkAppServer(): Boolean {
        println(
            "Performing application server health check..."
        )
        return true
    }

    fun checkDatabase(): Boolean {
        println(
            "Performing database health check..."
        )
        return false
    }

    fun main() {
        val isAppServerHealthy by lazy {
            checkAppServer()
        }

        val isDatabaseHealthy by lazy {
            checkDatabase()
        }

        when {
            isAppServerHealthy ->
                println(
                    "Application server is online and healthy"
                )

            isDatabaseHealthy ->
                println("Database is healthy")

            else ->
                println("System is offline")
        }
    }
}


// Exercício 4

object Intermediate14PropertiesExercise04 {
    class Budget(
        val totalBudget: Int
    ) {
        var remainingBudget: Int by observable(
            totalBudget
        ) { _, oldValue, newValue ->

            if (newValue < totalBudget * 0.2) {
                println(
                    "Warning: Your remaining budget " +
                        "($newValue) is below 20% of " +
                        "your total budget."
                )
            } else if (newValue > oldValue) {
                println(
                    "Good news: Your remaining budget " +
                        "increased to $newValue."
                )
            }
        }
    }

    fun main() {
        val myBudget =
            Budget(totalBudget = 1000)

        myBudget.remainingBudget = 800
        myBudget.remainingBudget = 150
        myBudget.remainingBudget = 50
        myBudget.remainingBudget = 300
    }
}


// ------------------------------------------------------------
// 15 - NULL SAFETY
// Exercício 1
// ------------------------------------------------------------

object Intermediate15NullSafetyExercise01 {
    data class User(
        val name: String?
    )

    fun getNotificationPreferences(
        user: Any,
        emailEnabled: Boolean,
        smsEnabled: Boolean
    ): List<String> {

        val validUser =
            user as? User ?: return emptyList()

        val userName =
            validUser.name ?: "Guest"

        return listOfNotNull(
            "Email Notifications enabled for $userName"
                .takeIf { emailEnabled },

            "SMS Notifications enabled for $userName"
                .takeIf { smsEnabled }
        )
    }

    fun main() {
        val user1 = User("Alice")
        val user2 = User(null)
        val invalidUser = "NotAUser"

        println(
            getNotificationPreferences(
                user1,
                emailEnabled = true,
                smsEnabled = false
            )
        )

        println(
            getNotificationPreferences(
                user2,
                emailEnabled = false,
                smsEnabled = true
            )
        )

        println(
            getNotificationPreferences(
                invalidUser,
                emailEnabled = true,
                smsEnabled = true
            )
        )
    }
}


// Exercício 2

object Intermediate15NullSafetyExercise02 {
    data class Subscription(
        val name: String,
        val isActive: Boolean
    )

    fun getActiveSubscription(
        subscriptions: List<Subscription>
    ): Subscription? =
        subscriptions.singleOrNull {
            it.isActive
        }

    fun main() {
        val userWithPremiumPlan =
            listOf(
                Subscription("Basic Plan", false),
                Subscription("Premium Plan", true)
            )

        val userWithConflictingPlans =
            listOf(
                Subscription("Basic Plan", true),
                Subscription("Premium Plan", true)
            )

        println(
            getActiveSubscription(
                userWithPremiumPlan
            )
        )

        println(
            getActiveSubscription(
                userWithConflictingPlans
            )
        )
    }
}


// Exercício 3

object Intermediate15NullSafetyExercise03 {
    data class User(
        val username: String,
        val isActive: Boolean
    )

    fun getActiveUsernames(
        users: List<User>
    ): List<String> =
        users.mapNotNull { user ->
            user.username.takeIf {
                user.isActive
            }
        }

    fun main() {
        val allUsers =
            listOf(
                User("alice123", true),
                User("bob_the_builder", false),
                User("charlie99", true)
            )

        println(
            getActiveUsernames(allUsers)
        )
    }
}


// Exercício 4

object Intermediate15NullSafetyExercise04 {
    fun validateStock(
        requested: Int?,
        available: Int?
    ): Int {

        val validRequested =
            requested ?: return -1

        val validAvailable =
            available ?: return -1

        if (validRequested < 0) {
            return -1
        }

        if (validRequested > validAvailable) {
            return -1
        }

        return validRequested
    }

    fun main() {
        println(validateStock(5, 10))
        println(validateStock(null, 10))
        println(validateStock(-2, 10))
    }
}


// ------------------------------------------------------------
// 16 - LIBRARIES AND APIS
// Exercício 1
// ------------------------------------------------------------

object Intermediate16LibrariesApisExercise01 {
    fun calculateCompoundInterest(
        P: Double,
        r: Double,
        n: Int,
        t: Int
    ): Double {
        return P * (1 + r / n).pow(n * t)
    }

    fun main() {
        val principal = 1000.0
        val rate = 0.05
        val timesCompounded = 4
        val years = 5

        val amount =
            calculateCompoundInterest(
                principal,
                rate,
                timesCompounded,
                years
            )

        println(
            "The accumulated amount is: $amount"
        )
    }
}


// Exercício 2

object Intermediate16LibrariesApisExercise02 {
    fun main() {
        val timeTaken = measureTime {

            val data =
                List(1000) { it * 2 }

            val filteredData =
                data.filter { it % 3 == 0 }

            val processedData =
                filteredData.map { it / 2 }

            println("Processed data")
        }

        println("Time taken: $timeTaken")
    }
}


// Exercício 3

@OptIn(ExperimentalStdlibApi::class)
object Intermediate16LibrariesApisExercise03 {
    fun main() {
        println(
            "Opt-in for ExperimentalStdlibApi enabled."
        )
    }
}


// ============================================================
// FIM DAS ATIVIDADES
// ============================================================
