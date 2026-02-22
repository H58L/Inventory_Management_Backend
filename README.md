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


<h3>@Id</h3>
<p>
The <code>@Id</code> annotation marks a field as the
<strong>primary key</strong> of the entity.
</p>
<ul>
  <li>Uniquely identifies each record in the table</li>
  <li>Mandatory for every JPA entity</li>
</ul>

<hr/>

<h3>@GeneratedValue</h3>
<p>
The <code>@GeneratedValue</code> annotation specifies how the primary key
value is generated.
</p>
<p>
<code>GenerationType.IDENTITY</code> means:
</p>
<ul>
  <li>The database automatically generates the ID</li>
  <li>Commonly uses <code>AUTO_INCREMENT</code> (MySQL) or identity columns</li>
  <li>Hibernate does not manage the ID value</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
</pre>

<hr/>

<h3>@Column</h3>
<p>
The <code>@Column</code> annotation is used to define column-level
constraints and properties.
</p>

<h4>@Column(unique = true)</h4>
<ul>
  <li>Ensures the column value is unique across all rows</li>
  <li>Creates a UNIQUE constraint at the database level</li>
  <li>Prevents duplicate entries</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
@Column(unique = true)
private String categoryId;

@Column(unique = true)
private String name;
</pre>

<hr/>

<h3>Fields without @Column</h3>
<p>
Fields without the <code>@Column</code> annotation are mapped automatically
using default JPA settings.
</p>
<ul>
  <li>Column name defaults to the field name</li>
  <li>Nullable by default</li>
  <li>No special constraints applied</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
private String description;
private String bgColor;
private String imgUrl;
</pre>

<hr/>

<h3>@CreationTimestamp</h3>
<p>
The <code>@CreationTimestamp</code> annotation automatically sets the timestamp
when the entity is first persisted.
</p>
<ul>
  <li>Value is generated by Hibernate</li>
  <li>Set only once during INSERT</li>
  <li>No manual assignment required</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
@CreationTimestamp
@Column(updatable = false)
private Timestamp createdAt;
</pre>

<hr/>

<h3>@UpdateTimestamp</h3>
<p>
The <code>@UpdateTimestamp</code> annotation automatically updates the timestamp
whenever the entity is modified.
</p>
<ul>
  <li>Updated on every UPDATE operation</li>
  <li>Managed entirely by Hibernate</li>
</ul>

<p><strong>Example:</strong></p>
<pre>
@UpdateTimestamp
private Timestamp updatedAt;
</pre>

<hr/>

<h3>Summary</h3>
<table border="1" cellpadding="8" cellspacing="0">
  <tr>
    <th>Annotation</th>
    <th>Purpose</th>
  </tr>
  <tr>
    <td>@Id</td>
    <td>Defines the primary key</td>
  </tr>
  <tr>
    <td>@GeneratedValue</td>
    <td>Auto-generates primary key values</td>
  </tr>
  <tr>
    <td>@Column(unique = true)</td>
    <td>Enforces uniqueness constraint</td>
  </tr>
  <tr>
    <td>@CreationTimestamp</td>
    <td>Sets creation time automatically</td>
  </tr>
  <tr>
    <td>@UpdateTimestamp</td>
    <td>Updates modification time automatically</td>
  </tr>
</table>

<br><br>
<code>A DTO is a simple object used to transfer data between layers without exposing internal entity structure</code>

<div>
<h3>@RestController </h3>
@RestController = @Controller + @ResponseBody

👉 It tells Spring that:

this class will handle HTTP requests

and return data (JSON/XML) instead of views (HTML/JSP)

🔹 @Controller

Marks the class as a Spring MVC controller

Handles incoming HTTP requests

🔹 @ResponseBody

Converts return values directly into JSON/XML

Uses Jackson internally to serialize objects
</div>
<div>
<h3>
@RequestMapping
</h3>
@RequestMapping is a Spring MVC annotation used to map HTTP requests to controller classes or methods.
@RequestMapping maps HTTP requests to controller methods and defines URL paths and HTTP methods.
</div>

<div>
<h3>@PostMapping</h3>
What is @PostMapping?

@PostMapping is a Spring MVC annotation used to handle HTTP POST requests.

👉 It is mainly used to create new resources on the server.
</div>

<div>
<h3>@RequestBody</h3>
@RequestBody is a Spring MVC annotation used to bind the HTTP request body to a Java object.

👉 In simple terms:
It converts incoming JSON into a Java object automatically.

Important Rules ⚠️

Used mainly with POST, PUT, PATCH

GET requests should not use @RequestBody

Field names in JSON must match Java fields
</div>

<div>
<h3>
@ResponseBody
@ResponseBody tells Spring to return data directly in the HTTP response instead of resolving a view.
</h3>
<br> <br>
<hr>
<div>
<table border="1" cellpadding="8" cellspacing="0">
  <thead>
    <tr>
      <th>Aspect</th>
      <th>@RequestBody</th>
      <th>@ResponseBody</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Direction</td>
      <td>Client → Server</td>
      <td>Server → Client</td>
    </tr>
    <tr>
      <td>Works on</td>
      <td>Method parameter</td>
      <td>Method return value</td>
    </tr>
    <tr>
      <td>Converts</td>
      <td>JSON → Java</td>
      <td>Java → JSON</td>
    </tr>
    <tr>
      <td>Uses Jackson</td>
      <td>Yes</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td>Common HTTP methods</td>
      <td>POST, PUT, PATCH</td>
      <td>GET, POST, PUT</td>
    </tr>
  </tbody>
</table>


</div>
</div>

<div>
<h3>@RestCOntroller v/s @Controller</h3>


<table border="1" cellpadding="8" cellspacing="0">
  <thead>
    <tr>
      <th>Aspect</th>
      <th>@Controller</th>
      <th>@RestController</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Purpose</td>
      <td>Used for Spring MVC applications</td>
      <td>Used for building REST APIs</td>
    </tr>
    <tr>
      <td>Returns</td>
      <td>View name (HTML, JSP, Thymeleaf)</td>
      <td>Data (JSON / XML)</td>
    </tr>
    <tr>
      <td>@ResponseBody needed?</td>
      <td>Yes, for returning JSON</td>
      <td>No (included by default)</td>
    </tr>
    <tr>
      <td>Internal composition</td>
      <td>@Controller</td>
      <td>@Controller + @ResponseBody</td>
    </tr>
    <tr>
      <td>View Resolver</td>
      <td>Used</td>
      <td>Skipped</td>
    </tr>
    <tr>
      <td>Common usage</td>
      <td>Web applications (MVC)</td>
      <td>RESTful backend services</td>
    </tr>
  </tbody>
</table>

</div>
<div>
<h3>
@Service
</h3>
Marks a class as a Service layer component

Tells Spring to manage this class as a Bean

Used to hold business logic

Why it’s used:

Separates business logic from controllers and repositories

Improves readability, testability, and layering
</div>

<h2>@Service &amp; @RequiredArgsConstructor (Spring Boot + Lombok)</h2>

<h3>What is a Bean?</h3>
<p>
A <strong>Bean</strong> is an object that is
<strong>created, managed, and controlled by the Spring container</strong>.
Instead of creating objects manually using <code>new</code>,
Spring handles object creation and lifecycle.
</p>

<pre>
@Service
public class CategoryService {
}
</pre>

<p>
The <code>CategoryService</code> class becomes a
<strong>Spring Bean</strong>.
</p>

<hr/>

<h3>What is Dependency Injection (DI)?</h3>
<p>
<strong>Dependency Injection</strong> is a design pattern where a class
receives its dependencies from Spring instead of creating them itself.
</p>
<ul>
  <li>Promotes loose coupling</li>
  <li>Improves testability</li>
  <li>Improves maintainability</li>
</ul>

<hr/>

<h3>@Service</h3>
<p>
The <code>@Service</code> annotation marks a class as a
<strong>Service-layer Spring Bean</strong>.
</p>
<ul>
  <li>Registers the class in Spring’s Application Context</li>
  <li>Used to store business logic</li>
  <li>Enables dependency injection</li>
</ul>

<pre>
@Service
public class CategoryService {
    // business logic
}
</pre>

<hr/>

<h3>@RequiredArgsConstructor (Lombok)</h3>
<p>
The <code>@RequiredArgsConstructor</code> annotation automatically generates
a constructor for all <code>final</code> fields.
</p>
<ul>
  <li>Enables constructor-based dependency injection</li>
  <li>Removes boilerplate constructor code</li>
  <li>Encourages immutability</li>
</ul>

<pre>
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
}
</pre>

<p>
Lombok generates the following constructor:
</p>

<pre>
public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
}
</pre>

<p>
Spring uses this constructor to
<strong>inject the dependency</strong>.
</p>

<hr/>

<h3>Why Use @Service with @RequiredArgsConstructor?</h3>
<ul>
  <li><code>@Service</code> creates a Spring-managed Bean</li>
  <li><code>@RequiredArgsConstructor</code> injects required dependencies cleanly</li>
  <li>This approach follows Spring Boot best practices</li>
</ul>

<hr/>

<h3>Summary</h3>
<ul>
  <li><strong>Bean</strong>: Spring-managed object</li>
  <li><strong>Dependency Injection</strong>: Dependencies provided by Spring</li>
  <li><strong>@Service</strong>: Marks the business logic layer</li>
  <li><strong>@RequiredArgsConstructor</strong>: Enables constructor-based dependency injection</li>
</ul>

<hr/>

<h3>Interview One-Liner</h3>
<p>
<em>
@Service creates a Spring-managed service Bean, and @RequiredArgsConstructor
enables constructor-based dependency injection without boilerplate code.
</em>
</p>

<div>
@ResponseStatus
@ResponseStatus → controls HTTP status code

HttpStatus.CREATED → 201

Used for successful POST / create operations

Improves REST API correctness & clarity


</div>

<div>
<table border="1" cellpadding="8" cellspacing="0">
  <thead>
    <tr>
      <th>Feature</th>
      <th>@ResponseStatus</th>
      <th>ResponseEntity</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Simplicity</td>
      <td>✅ Very simple</td>
      <td>❌ More code</td>
    </tr>
    <tr>
      <td>Dynamic status</td>
      <td>❌ No</td>
      <td>✅ Yes</td>
    </tr>
    <tr>
      <td>Custom headers</td>
      <td>❌ No</td>
      <td>✅ Yes</td>
    </tr>
    <tr>
      <td>Best for</td>
      <td>Basic APIs</td>
      <td>Complex APIs</td>
    </tr>
  </tbody>
</table>

</div>
