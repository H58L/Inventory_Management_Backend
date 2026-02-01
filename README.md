# Inventory_Management_Backend
Refreshing Full Stack Skills
<h1> Study Guide Concepts</h1>
<br>
<div>
#// JPA is a specification (standard) that defines how ORM should work.
#// Hibernate is an implementation of JPA that provides the actual ORM functionality.

#JPA properties
#ddl-auto controls how Hibernate manages DB schema,
#context-path defines the base URL for all endpoints. Prefixes API versioning Eg: http://localhost:8080/api/v1.0/users
</div>

<br>
<h3>Basic Sprigboot Layers</h3>
<div>
Controller: The presentation layer component responsible for handling incoming HTTP requests from a client, validating input data, and returning the appropriate HTTP responses (e.g., JSON or an HTML view). It should contain very little to no business logic and primarily delegates tasks to the service layer.

Service: The business logic layer component where the core application logic resides. It orchestrates various operations, processes data, performs validations, and manages transactions. It acts as the middleware between the controller and repository layers, calling repositories as needed to fetch or persist data.

Repository: The data access layer component responsible for all interactions with the database or other data sources. It encapsulates the logic for data access and persistence, performing CRUD (Create, Read, Update, Delete) operations on entities. The service layer uses the repository as an abstraction to communicate with the data layer.
Entity: A class or data structure that represents a table in the database. It defines the structure and properties of the data being stored and retrieved, acting as the domain model for the persistence layer. 
</div>
