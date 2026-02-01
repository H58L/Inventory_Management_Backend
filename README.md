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

Model layer and Entity layer are often used interchangeably
</div>

<br><br>
<h2>ANNOTATIONS</h2>
<div>
<h3>@Entity</h3>
@Entity is a JPA annotation that marks a Java class as an entity. 
An entity in JPA represents a table in a relational database schema. 
When you annotate a class with @Entity , you're telling JPA that instances
of this class are to be mapped to rows in a corresponding database table.

<h2>@Table (JPA)</h2>
<p>
The <code>@Table</code> annotation is used to specify the database table details
for a JPA entity.
</p>
<ul>
  <li>Maps the entity to a specific table in the database</li>
  <li>Allows customization of table name, schema, and constraints</li>
</ul>
<p><strong>Example:</strong></p>
<pre>
@Table(name = "employees")
</pre>

<hr/>

<h2>@Builder (Lombok)</h2>
<p>
The <code>@Builder</code> annotation implements the <strong>Builder Design Pattern</strong>,
which is used to construct complex objects step by step.
</p>

<h3>What is the Builder Pattern?</h3>
<p>
The Builder Pattern separates the construction of an object from its representation,
allowing the same construction process to create different representations.
</p>
<ul>
  <li>Useful when a class has many fields or optional parameters</li>
  <li>Prevents large and confusing constructors</li>
  <li>Makes object creation readable and less error-prone</li>
</ul>

<p><strong>How Lombok's @Builder helps:</strong></p>
<ul>
  <li>Generates a builder class automatically</li>
  <li>Provides a fluent API for setting fields</li>
  <li>Ensures immutability after object creation</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
Employee emp = Employee.builder()
    .name("Lisa")
    .age(23)
    .department("Engineering")
    .build();
</pre>

<hr/>

<h2>@Data (Lombok)</h2>
<p>
The <code>@Data</code> annotation is a shortcut that automatically generates
boilerplate code.
</p>
<ul>
  <li>Getters and setters for all fields</li>
  <li><code>toString()</code>, <code>equals()</code>, and <code>hashCode()</code></li>
  <li>Required arguments constructor</li>
</ul>
<p>
It is equivalent to using:
<code>@Getter</code>, <code>@Setter</code>, <code>@ToString</code>,
<code>@EqualsAndHashCode</code>, and <code>@RequiredArgsConstructor</code>
together.
</p>

</div>

<h3>Object Creation: Without Builder vs With Builder</h3>

<h4>Without Builder Pattern</h4>
<p>
Objects are created using constructors or setters. This approach becomes
hard to manage when a class has many fields.
</p>
<ul>
  <li>Requires large constructors with many parameters</li>
  <li>Hard to remember parameter order</li>
  <li>Error-prone when many parameters have the same type</li>
  <li>Less readable code</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
Employee emp = new Employee(
    "Lisa",
    23,
    "Engineering",
    "Pune",
    true
);
</pre>

<hr/>

<h4>With Builder Pattern (@Builder)</h4>
<p>
The Builder Pattern allows step-by-step construction of an object using
a fluent and readable API.
</p>
<ul>
  <li>No need to remember parameter order</li>
  <li>Supports optional fields easily</li>
  <li>Improves readability and maintainability</li>
  <li>Reduces bugs caused by incorrect parameter mapping</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
Employee emp = Employee.builder()
    .name("Lisa")
    .age(23)
    .department("Engineering")
    .city("Pune")
    .active(true)
    .build();
</pre>

<hr/>

<h4>Summary Comparison</h4>
<table border="1" cellpadding="8" cellspacing="0">
  <tr>
    <th>Aspect</th>
    <th>Without Builder</th>
    <th>With Builder</th>
  </tr>
  <tr>
    <td>Readability</td>
    <td>Low</td>
    <td>High</td>
  </tr>
  <tr>
    <td>Handling optional fields</td>
    <td>Difficult</td>
    <td>Easy</td>
  </tr>
  <tr>
    <td>Error-prone</td>
    <td>High</td>
    <td>Low</td>
  </tr>
  <tr>
    <td>Maintainability</td>
    <td>Poor</td>
    <td>Excellent</td>
  </tr>
</table>

