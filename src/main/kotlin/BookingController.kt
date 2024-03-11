class BookingController {
    private val printer = Printer()
    private val bookingsList = mutableListOf<Booking>()

    fun createBooking(customer: Customer, room: Room) {
        printer.printMsg("Ingrese la fecha de inicio")
        val startDate = readln()
        printer.printMsg("Ingrese la fecha de salida")
        val endDate = readln()
        printer.printMsg("Ingrese el numero de noches")
        val totalNights = readln().toInt()

        val addedBooking = Booking(
            room, customer, startDate, endDate, totalNights, false
        )
        addedBooking.calculatePrice()
        customer.addBooking(addedBooking)
        bookingsList.add(addedBooking)
    }

    fun showBookings() {
        if (bookingsList.isEmpty()) {
            printer.printMsg("No hay habitaciones registradas")
        } else {
            var counter = 1
            for (booking in bookingsList) {
                printer.printMsg("$counter " + booking.getBookingData())
                counter++
            }
        }
    }
}