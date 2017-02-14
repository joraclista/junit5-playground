# junit5-playground
junit5 samples for 30-minutes Junit Intro for project interns

This talk introduces you to JUnit 5. 
We'll start by installing JUnit 5. 

We'll talk about architecture and components, 
then with the help of code snippets we will see how to use annotations, assertions, and assumptions.

### Prerequisites
This tutorial assumes you are comfortable with:

  * Intellij IDEA
  * Maven
  * Git
  
 ###  Dependencies
Just add the following to your pom.xml:
```xml 
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
        <!-- To run tests on IDE such as Eclipse, Intellij -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-runner</artifactId>
            <version>${junit.platform.version}</version>
            <scope>test</scope>
        </dependency>
```

### Annotations
Since JUnit 4, annotations have been a core of the testing framework.
We'll cover most important of them.

The JUnit 5 some JUnit 4 annotations names were changed, without change in their meaning and function.
If you've been using JUnit 4, the table below will update you on this.

  #### Annotations in JUnit 4 vs JUnit 5
 
 
|    JUnit 5    |    JUnit 4    |    Description    |
| ----- | ----- | ------- |
| @Test |	@Test	| annotation is used to signal that the annotated method is a test, method annotated with it should not be private or static|
| @BeforeAll | 	@BeforeClass	|  method will be executed once before any @Test method in the current class.| 
|  @BeforeEach | 	@Before	 |  method will be executed before each @Test method in the current class. | 
| @AfterEach	 | @After	 | method will be executed after each @Test method in the current class. | 
| @AfterAll	 | @AfterClass	 | method will be executed once after all @Test methods in the current class. | 
| @Disabled | 	@Ignore	 |  method will not be executed, but reported as such. | 
| @DisplayName  | n/a |  tells JUnit to display the "value" rather than the method name when reporting test results | 

### Assertions
An assertion is one of a number of static methods on the org.junit.jupiter.api.Assertions class. 
Assertions are used to test a condition that must evaluate to true in order for the test to continue executing.

If an assertion fails, the test is halted and test failure is reported. 
If the assertion succeeds, the test continues to the next line of code.

All assertion methods listed below take an optional message parameter that displays if the assertion fails, rather than the standard default message.


|    Assertion |	Description |
| ----- | ----- |
|  assertEquals(expected, actual)	 | asserts *expected* and *actual* are equal .	 |
|  assertTrue(booleanExpression) | 	asserts *booleanExpression* is true, fails otherwise 	 |
|  assertFalse(booleanExpression)	 | asserts *booleanExpression* is false, fails otherwise 	 |
|  assertNull(actual)	 | asserts *actual* is null, fails otherwise 	 |
|  assertNotNull(actual)	 | asserts *actual* is not null, fails otherwise	 |
|  assertThrows(expectedExceptionClassType, Executable executable)	 | Asserts execution of the *executable* throws an exception of *expectedExceptionClassType* type and returns the exception. Fails otherwise	 |
|  assertTimeout(timeout, executable)	 | Asserts execution of the supplied *executable*  completes before the given *timeout* is exceeded, fails otherwise	 |
|  assertAll(heading, executables)	 | Asserts all supplied *executables* do not throw exceptions.	 |


### Parameterized tests
A parameterized test is one where the @Test method is invoked multiple times
with different parameter values each time. 
A parameterized test must be annotated with @ParameterizedTest, and must specify a source for its arguments.

JUnit Jupiter provides several sources for parameters. 
With each of the sources, there is a tradeoff between ease-of-use and flexibility of allowed data types.
This tutorial covers next sources:

|    Annotation for source |	Description | 
| ----- | ----- |
| @ValueSource	 | provides access to an array of literal values of primitive types. Supported primitive types include *strings*, *ints*,*longs*, and *doubles*.  |	
| @EnumSource	 | provides an enum that JUnit will supply—one at-a-time—to your @ParameterizedTest method.	 |	
| @MethodSource	 | The name(s) of the test class method(s) to use as sources for arguments, must not be empty.	 |
| @CsvSource	 | 	The CSV lines to use as source of arguments, must not be empty |

 

### Running tests with Maven
Open a terminal window (Mac) or command prompt (Windows), 
navigate to the directory where you cloned the repository, 
and enter the following command:

```mvn test```
