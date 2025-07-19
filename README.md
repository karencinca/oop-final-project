# RENDUE DOCS

## 🏢 Overview

This system manages property rentals using MVC architecture and the DAO pattern, allowing users to register properties and manage reservations. Data is in-memory but easily adaptable for persistence.

## 📂 Project Structure

```
├── model
│   ├── Booking.java
│   ├── Person.java
│   ├── Property.java
│   └── PropertyType.java
│
├── dao
│   ├── BookingDAO.java
│   ├── DAO.java
│   ├── PersonDAO.java
│   └── PropertyDAO.java
│
├── controller
│   ├── BookingController.java
│   ├── PersonController.java
│   └── PropertyController.java
├── utils
│   └── MetaInfo.java
├── view
│   ├── BookingView.java
│   ├── Main.java
│   ├── PersonView.java
│   └── PropertyView.java
```

## 📃 Models

### `model.Person`

Represents a user or property owner.

**Attributes:**

- `int id`: Unique identifier.
- `String CPF`: Brazilian Individual ID number.
- `String name`: First name.
- `String lastName`: Last name.
- `String email`: Email address.

**Methods:**

- `Person(String CPF, String name, String lastName, String email)` - returns a new `Person` object, constructs a new `Person` object with the provided details.
- `int getId()` - returns `int`, retrieves the ID.
- `void setId(int id)` - returns `void`, sets the ID.
- `String getCPF()` - returns `String`, retrieves the CPF.
- `void setCPF(String CPF)` - returns `void`, sets the CPF.
- `String getName()` - returns `String`, retrieves the first name.
- `void setName(String name)` - returns `void`, sets the first name.
- `String getLastName()` - returns `String`, retrieves the last name.
- `void setLastName(String lastName)` - returns `void`, sets the last name.
- `String getEmail()` - returns `String`, retrieves the email.
- `void setEmail(String email)` - returns `void`, sets the email.
- `int hashCode()` - returns `int`, generates a hash code for the `Person` object.
- `boolean equals(Object obj)` - returns `boolean`, compares this `Person` object to another object for equality.
- `String toString()` - returns `String`, returns a string representation of the `Person` object.

### `model.Property`

Represents a real estate unit available for rent.

**Attributes:**

- `int id`: Unique identifier.
- `String name`: Descriptive name (e.g., "Cozy Apartment").
- `String address`: Full address.
- `Person user`: The `Person` object representing the owner.
- `int roomAmount`: Number of rooms in the property.
- `int bathroomAmount`: Number of bathrooms in the property.
- `PropertyType type`: The type of property (e.g., HOUSE, APARTMENT).

**Methods:**

- `Property(Person user, String name, String address, PropertyType type)` - returns a new `Property` object, constructs a new `Property` object with the provided details.
- `int getId()` - returns `int`, retrieves the ID.
- `void setId(int id)` - returns `void`, sets the ID.
- `String getName()` - returns `String`, retrieves the name.
- `void setName(String name)` - returns `void`, sets the name.
- `String getAddress()` - returns `String`, retrieves the address.
- `void setAddress(String address)` - returns `void`, sets the address.
- `Person getUser()` - returns `Person`, retrieves the owner (`Person`).
- `void setUser(Person user)` - returns `void`, sets the owner (`Person`).
- `int getRoomAmount()` - returns `int`, retrieves the number of rooms in the property.
- `void setRoomAmount(int roomAmount)` - returns `void`, sets the number of rooms in the property.
- `int getBathroomAmount()` - returns `int`, retrieves the number of bathrooms in the property.
- `void setBathroomAmount(int bathroomAmount)` - returns `void`, sets the number of bathrooms in the property.
- `PropertyType getType()` - returns `PropertyType`, retrieves the type of the property.
- `void setType(PropertyType type)` - returns `void`, sets the type of the property.
- `int hashCode()` - returns `int`, generates a hash code for the `Property` object.
- `boolean equals(Object obj)` - returns `boolean`, compares this `Property` object to another object for equality.
- `String toString()` - returns `String`, returns a string representation of the `Property` object.

### `model.PropertyType` (enum)

Defines the available types of properties.

**Enum Values:**

- `HOUSE("house")`
- `APARTMENT("apartment")`
- `FARM("farm house")`
- `BEDROOM("bed and breakfast")`

**Attributes:**

- `String type`: A string representation of the property type.

**Methods:**

- `PropertyType(String type)` - returns an enum constant, constructs an enum constant with the provided string.
- `String getType()` - returns `String`, retrieves the string representation of the property type.

### `model.Booking`

Represents a reservation for a property within a specific time frame.

**Attributes:**

- `int id`: Unique identifier.
- `Person user`: The `Person` object who made the booking.
- `String tenantName`: The name of the tenant.
- `Property property`: The `Property` object being booked.
- `LocalDate checkIn`: The check-in date for the booking.
- `LocalDate checkOut`: The check-out date for the booking.
- `double totalPrice`: The total price of the booking.

**Methods:**

- `Booking(Person user, String tenantName, Property property, LocalDate checkIn, LocalDate checkOut, double totalPrice)` - returns a new `Booking` object, constructs a new `Booking` object with the provided details.
- `int getId()` - returns `int`, retrieves the ID.
- `void setId(int id)` - returns `void`, sets the ID.
- `String getTenantName()` - returns `String`, retrieves the tenant's name.
- `void setTenantName(String tenantName)` - returns `void`, sets the tenant's name.
- `Property getProperty()` - returns `Property`, retrieves the property associated with the booking.
- `void setProperty(Property property)` - returns `void`, sets the property associated with the booking.
- `LocalDate getCheckIn()` - returns `LocalDate`, retrieves the check-in date.
- `void setCheckIn(LocalDate checkIn)` - returns `void`, sets the check-in date.
- `LocalDate getCheckOut()` - returns `LocalDate`, retrieves the check-out date.
- `void setCheckOut(LocalDate checkOut)` - returns `void`, sets the check-out date.
- `double getTotalPrice()` - returns `double`, retrieves the total price of the booking.
- `void setTotalPrice(double totalPrice)` - returns `void`, sets the total price of the booking.
- `int hashCode()` - returns `int`, generates a hash code for the `Booking` object.
- `boolean equals(Object obj)` - returns `boolean`, compares this `Booking` object to another object for equality.
- `String toString()` - returns `String`, returns a string representation of the `Booking` object.

## 📂 DAO (Data Access Object)

### `model.DAO.DAO<E,T>` (Interface)

Generic interface for Data Access Objects.

**Methods:**

- `void create(T t)` - returns `void`, creates a new entity.
- `boolean read(T t)` - returns `boolean`, checks if an entity exists.
- `boolean delete(T t)` - returns `boolean`, deletes an entity.
- `HashMap<E,T> readAll()` - returns `HashMap<E,T>`, retrieves all entities.
- `T readById(int id)` - returns `T`, retrieves an entity by its ID.

### `model.DAO.PersonDAO`

Manages `Person` objects in memory.

**Attributes:**

- `private HashMap<Integer, Person> userData`: Stores `Person` objects.
- `private static PersonDAO instance`: Singleton instance.

**Methods:**

- `private PersonDAO()` - returns `void`, private constructor initializing `userData`.
- `static PersonDAO getInstance()` - returns `PersonDAO`, retrieves the singleton instance.
- `void create(Person t)` - returns `void`, adds a new `Person` and assigns an ID.
- `boolean read(Person t)` - returns `boolean`, checks if a `Person` exists.
- `boolean delete(Person t)` - returns `boolean`, removes a `Person` by ID.
- `HashMap<Integer, Person> readAll()` - returns `HashMap<Integer, Person>`, retrieves all `Person` objects.
- `Person readById(int id)` - returns `Person`, retrieves a `Person` by ID.
- `void update(Person t)` - returns `void`, updates an existing `Person` object.
- `HashMap<Integer, Person> getUserData()` - returns `HashMap<Integer, Person>`, retrieves the internal `userData` HashMap.
- `void setUserData(HashMap<Integer, Person> userData)` - returns `void`, sets the internal `userData` HashMap.

### `model.DAO.PropertyDAO`

Manages `Property` objects in memory.

**Attributes:**

- `private HashMap<Integer, Property> propertyData`: Stores `Property` objects.
- `private static PropertyDAO instance`: Singleton instance.

**Methods:**

- `private PropertyDAO()` - returns `void`, private constructor initializing `propertyData`.
- `static PropertyDAO getInstance()` - returns `PropertyDAO`, retrieves the singleton instance.
- `void create(Property t)` - returns `void`, adds a new `Property` and assigns an ID.
- `boolean read(Property t)` - returns `boolean`, checks if a `Property` exists.
- `boolean delete(Property t)` - returns `boolean`, removes a `Property` by ID.
- `HashMap<Integer, Property> readAll()` - returns `HashMap<Integer, Property>`, retrieves all `Property` objects.
- `Property readById(int id)` - returns `Property`, retrieves a `Property` by ID.
- `boolean update(Property t)` - returns `boolean`, updates an existing `Property` object.
- `HashMap<Integer, Property> getPropertyData()` - returns `HashMap<Integer, Property>`, retrieves the internal `propertyData` HashMap.
- `void setPropertyData(HashMap<Integer, Property> propertyData)` - returns `void`, sets the internal `propertyData` HashMap.

### `model.DAO.BookingDAO`

Manages `Booking` objects in memory.

**Attributes:**

- `private HashMap<Integer, Booking> bookingData`: Stores `Booking` objects.
- `private static BookingDAO instance`: Singleton instance.

**Methods:**

- `private BookingDAO()` - returns `void`, private constructor initializing `bookingData`.
- `static BookingDAO getInstance()` - returns `BookingDAO`, retrieves the singleton instance.
- `void create(Booking t)` - returns `void`, adds a new `Booking` and assigns an ID.
- `boolean read(Booking t)` - returns `boolean`, checks if a `Booking` exists.
- `boolean delete(Booking t)` - returns `boolean`, removes a `Booking` by ID.
- `HashMap<Integer, Booking> readAll()` - returns `HashMap<Integer, Booking>`, retrieves all `Booking` objects.
- `Booking readById(int id)` - returns `Booking`, retrieves a `Booking` by ID.
- `boolean update(Booking t)` - returns `boolean`, updates an existing `Booking` object.
- `HashMap<Integer, Booking> getBookingData()` - returns `HashMap<Integer, Booking>`, retrieves the internal `bookingData` HashMap.
- `void setBookingData(HashMap<Integer, Booking> bookingData)` - returns `void`, sets the internal `bookingData` HashMap.

## 🤖 Controllers

Controllers handle business logic and validation.

### `controller.PersonController`

Handles business logic for `Person` entities.

**Methods:**

- `static void register(Person user)` - returns `void`, registers a new `Person` after CPF validation, throws `IllegalArgumentException` for invalid CPF.
- `static void edit(Person user)` - returns `void`, edits a `Person`'s info after CPF validation, throws `IllegalArgumentException` for invalid CPF.
- `static boolean isCpfValid(String cpf)` - returns `boolean`, validates the format and check digits of a CPF.

### `controller.PropertyController`

Handles business logic for `Property` entities.

**Methods:**

- `static void register(String name, String address, PropertyType type)` - returns `void`, registers a new `Property` with the default user as owner.
- `static boolean edit(Property property)` - returns `boolean`, edits a `Property`'s info (rooms, bathrooms) and owner, throws `IllegalArgumentException` for invalid amounts or update errors.
- `static Property showUnique(Property property)` - returns `Property`, retrieves a specific `Property` by ID, throws `IllegalArgumentException` if not found.
- `static boolean delete(int id)` - returns `boolean`, deletes a `Property` by ID, throws `IllegalArgumentException` for deletion errors.

### `controller.BookingController`

Handles business logic for `Booking` entities, including availability validation.

**Methods:**

- `static void register(Person user, String tenantName, Property property, LocalDate checkIn, LocalDate checkOut, double totalPrice)` - returns `void`, registers a new `Booking`, validates price and property availability, throws `IllegalArgumentException` for negative price or date overlaps.
- `static boolean edit(Booking booking)` - returns `boolean`, edits an existing `Booking`, validates price and updated availability, throws `IllegalArgumentException` for negative price, date overlaps, or update errors.
- `static Booking showUnique(Booking booking)` - returns `Booking`, retrieves a specific `Booking` by ID, throws `IllegalArgumentException` if not found.
- `static boolean isAvailable(int propertyId, LocalDate checkin, LocalDate checkout, int bookingIdToIgnore)` - returns `boolean`, checks if a property is available for booking within specified dates, optionally ignoring a given booking ID.
- `static boolean delete(int id)` - returns `boolean`, deletes a `Booking` by ID, throws `IllegalArgumentException` for deletion errors.

## 🛠️ Utils

### `utils.MetaInfo`

A utility class for managing global counters.

**Attributes:**

- `public static int bookingCount`: Counter for bookings, used to set the id inside the DAO create methods.
- `public static int propertyCount`: Counter for properties, used to set the id inside the DAO create methods.
- `public static int userCount`: Counter for users, used to set the id inside the DAO create methods.

**Methods:**

- `static void setBookingCount(int bookingCount)` - returns `void`, sets the `bookingCount`.
- `static void setPropertyCount(int propertyCount)` - returns `void`, sets the `propertyCount`.
- `static void setUserCount(int userCount)` - returns `void`, sets the `userCount`.

## 🖥️ View

View classes handle user interaction and display.

### `view.Main`

Main entry point of the application.

**Attributes:**

- `private static final Scanner console`: `Scanner` for console input.

**Methods:**

- `static void main(String[] args)` - returns `void`, initializes counters, displays header, registers user, populates data, and presents the main menu.
- `private static void mainMenu()` - returns `void`, displays main menu options and navigates sections or exits.
- `private static void registerUser()` - returns `void`, prompts for user registration details (CPF, name, last name, email).
- `private static void header()` - returns `void`, displays the application welcome header.
- `private static void populateData()` - returns `void`, populates sample `Person`, `Property`, and `Booking` data.

### `view.PersonView`

Manages user interaction for `Person` data.

**Attributes:**

- `private static final Scanner console`: `Scanner` for console input.

**Methods:**

- `static void mainMenu()` - returns `void`, displays `Person` management menu and handles input.
- `private static void edit()` - returns `void`, displays user info and prompts for updated details (CPF, name, last name, email).

### `view.PropertyView`

Manages user interaction for `Property` data.

**Attributes:**

- `private static final Scanner console`: `Scanner` for console input.
- `private static final PropertyDAO propertyDAO`: `PropertyDAO` instance for data access.

**Methods:**

- `static void mainMenu()` - returns `void`, displays `Property` management menu and handles input.
- `private static void register()` - returns `void`, prompts for new property details (name, address, type).
- `private static void edit()` - returns `void`, lists properties, then prompts for ID and new details (name, address, room amount, bathroom amount, type) to edit.
- `private static void list()` - returns `void`, lists all registered properties.
- `private static void showUnique()` - returns `void`, prompts for a property ID and attempts to display its unique information.
- `private static void delete()` - returns `void`, prompts for a property ID and attempts to delete the corresponding `Property`.
- `private static PropertyType chooseType()` - returns `PropertyType`, prompts user to select a `PropertyType` from options.

### `view.BookingView`

Manages user interaction for `Booking` data.

**Attributes:**

- `private static final Scanner console`: `Scanner` for console input.
- `private static final BookingDAO bookingDao`: `BookingDAO` instance for data access.

**Methods:**

- `static void mainMenu()` - returns `void`, displays `Booking` management menu and handles input.
- `static void register()` - returns `void`, prompts for tenant name, property ID, check-in/out dates, and total price to register a new `Booking`.
- `static void edit()` - returns `void`, lists bookings, then prompts for ID and new details (tenant name, check-in/out dates, total price) to edit an existing `Booking`.
- `static void showUnique()` - returns `void`, prompts for a booking ID and attempts to display its unique information.
- `static void list()` - returns `void`, prompts for a property ID and lists all bookings related to it.
- `static void delete()` - returns `void`, prompts for a booking ID and attempts to delete the corresponding `Booking`.
