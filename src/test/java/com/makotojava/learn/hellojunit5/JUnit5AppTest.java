package com.makotojava.learn.hellojunit5;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;

/**
 * JUnit 5 (with JUnitPlatform.class)
 * 
 * Class-level Exercises:
 * <ol>
 * <li>Enable Eclipse JUnit support for this test class using the {@link org.junit.runner.RunWith @RunWith} and
 * {@link org.junit.platform.runner.JUnitPlatform
 * JUnitPlatform} class.</li>
 * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
 * report.</li>
 * </ol>
 *
 */
@DisplayName("Test Display Name")
public class JUnit5AppTest {
  static Logger logger = LoggerFactory.getLogger(App.class);
  // Create a JDK Logger here

  // Create a fixture for the class under test
  private App classToTest;
  // Do something before ANY test is run in this class
  @BeforeAll
  public static void init() {
    logger.info("Starting another Test!");
  }

  @AfterAll
  // Do something after ALL tests in this class are run
  public static void done() {
    logger.info("Finished all tests!");
  }

  // Create an instance of the test class before each @Test method is executed
  @BeforeEach
  public void startup() {
    classToTest = new App();
  }

  // Destroy reference to the instance of the test class after each @Test method is executed
  @AfterEach
  public void teardown() {
    classToTest = null;
  }

  // Disabled test
  @Disabled
  void testNotRun() {
    logger.info("This test does not run");
  }

  /**
   * testAdd() - Exercises:
   * <ol>
   * <li>Tell JUnit this method is a test method.</li>
   * <li>Give it a cool display name for the test report.</li>
   * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
   * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
   * <ol>
   * <li>1, 2, 3, 4</li>
   * <li>20, 934, 110</li>
   * <li>2, 4, 6</li>
   * </ol>
   * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers are
   * tested (i.e., if one fails, it should not fail the test method). Hint: use
   * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
   * </ol>
   *
   */
  @Test
  @DisplayName("Test using Assertall")
  public void testAdd() {
    assertNotNull(classToTest);

    //
    // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see the
    // buttery smooth javadoc above.)
    //

    assertAll(
      "Assert All of these",
      () -> {
        long[] array1 = {1,2,3,4};
        long expected1 = 10;
        assertEquals(expected1, classToTest.add(array1));
      },
      () -> {
        long[] array2 = {20, 934, 110};
        long expected2 = 1064;
        assertEquals(expected2, classToTest.add(array2));
      },
      () -> {
        long[] array3 = {2, 4, 6};
        long expected3 = 12;
        assertEquals(expected3, classToTest.add(array3));
      });
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * <li>Create an instance of the {@link com.makotojava.learn.hellojunit5.App App} class specifically for this nested
   * class:
   * <ul>
   * <li>Set the <code>classUnderTest</code> variable in a method called <code>setUp()</code> that runs before the test
   * method does (hint: use {@link org.junit.jupiter.api.BeforeEach @BeforeEach})</li>
   * </ul>
   * <li>Set the <code>classUnderTest</code> variable to null in a method called <code>tearDown()</code> that runs after
   * the
   * test method does (hint: use {@link org.junit.jupiter.api.AfterEach @AfterEach})</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Test Negative Numbers")
  class NegativeNumbersTest {


    private App classToTest;
  
    // Create an instance of the test class before each @Test method is executed
    @BeforeEach
    public void startup() {
      classToTest = new App();
    }
  
    // Destroy reference to the instance of the test class after each @Test method is executed
    @AfterEach
    public void teardown() {
      classToTest = null;
    }

    

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, -2, -3, -4</li>
     * <li>-20, -934, -110</li>
     * <li>-2, -4, -6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Test Negative Numbers three times")
    public void testAdd() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(classToTest);
      assertAll(
        "Assert All of these",
        () -> {
          long[] array1 = {-1, -2, -3, -4};
          long expected1 = -10;
          assertEquals(expected1, classToTest.add(array1));
        },
        () -> {
          long[] array2 = {-20, -934, -110};
          long expected2 = -1064;
          assertEquals(expected2, classToTest.add(array2));
        },
        () -> {
          long[] array3 = {-2, -4, -6};
          long expected3 = -12;
          assertEquals(expected3, classToTest.add(array3));
        });
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Test Positive And Negative Numbers")
  class PositiveAndNegativeNumbersTest {

    private App classToTest;
  
    // Create an instance of the test class before each @Test method is executed
    @BeforeEach
    public void startup() {
      classToTest = new App();
    }
  
    // Destroy reference to the instance of the test class after each @Test method is executed
    @AfterEach
    public void teardown() {
      classToTest = null;
    }
    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, 2, -3, 4</li>
     * <li>-20, 934, -110</li>
     * <li>-2, -4, 6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Test positive and negative Numbers three times")
    public void testAdd() {

      assertNotNull(classToTest);
      assertAll(
        "Assert All of these",
        () -> {
          long[] array1 = {-1, 2, -3, 4};
          long expected1 = 2;
          assertEquals(expected1, classToTest.add(array1));
        },
        () -> {
          long[] array2 = {-20, 934, -110};
          long expected2 = 804;
          assertEquals(expected2, classToTest.add(array2));
        },
        () -> {
          long[] array3 = {-2, -4, 6};
          long expected3 = 0;
          assertEquals(expected3, classToTest.add(array3));
        });
    }

    /**
     * testAdd_OnlyOnFriday - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumeTrue(boolean) assumeTrue()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Only Friday AssumeTrue Test")
    public void testAdd_OnlyOnFriday() {
      assertNotNull(classToTest);
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      LocalDateTime ldt = LocalDateTime.now();
      assumeTrue(ldt.getDayOfWeek().getValue() == 5);

      long[] array = {1,2,3,4,5};
      long expected = 15;
      assertEquals(expected, classToTest.add(array));
    }

    /**
     * testAdd_OnlyOnFriday_WithLambda - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumingThat(boolean, org.junit.jupiter.api.function.Executable)
     * assumingThat()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Only Friday AssumingThat Test")
    public void testAdd_OnlyOnFriday_WithLambda() {
      assertNotNull(classToTest);
      LocalDateTime ldt = LocalDateTime.now();
      assumingThat(ldt.getDayOfWeek().getValue() == 5,
          () -> {
            // Execute this if assumption holds...
          });
          long[] array = {1,2,3,4,5};
          long expected = 15;
          assertEquals(expected, classToTest.add(array));
    }

  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Only Friday AssumingThat Test")
  class JUnit5AppSingleOperandTest {

    /**
     * testAdd_NumbersGt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>1</li>
     * <li>0</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Only Friday AssumingThat Test")
    public void testAdd_NumbersGt0() {
      assertNotNull(classToTest);
      assertAll(
        "Assert All of these",
        () -> {
          long[] array1 = {1};
          long expected1 = 1;
          assertEquals(expected1, classToTest.add(array1));
        },
        () -> {
          long[] array2 = {0};
          long expected2 = 0;
          assertEquals(expected2, classToTest.add(array2));
        });
    }

    /**
     * testAdd_NumbersLt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1</li>
     * <li>-10</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Only Friday AssumingThat Test")
    public void testAdd_NumbersLt0() {
      assertNotNull(classToTest);
      assertAll(
        "Assert All of these",
        () -> {
          long[] array1 = {-1};
          long expected1 = -1;
          assertEquals(expected1, classToTest.add(array1));
        },
        () -> { 
          long[] array2 = {-10};
          long expected2 = -10;
          assertEquals(expected2, classToTest.add(array2));
        });
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Only Friday AssumingThat Test")
  class JUnit5AppZeroOperandsTest {

    /**
     * testAdd_ZeroOperands_EmptyArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * </ol>
     */
    @Test
    @DisplayName("Pass Zero operands Test")
    public void testAdd_ZeroOperands_EmptyArgument() {
      assertNotNull(classToTest);
      long[] numbersToSum = {};
      assertThrows(IllegalArgumentException.class, () -> classToTest.add(numbersToSum));
    }

    /**
     * testAdd_ZeroOperands_NullArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * <li>The test should fail if the message in the exception is not "Operands argument cannot be null".</li>
     * </ol>
     */
    @Test
    @DisplayName("Pass null argument Test")
    public void testAdd_ZeroOperands_NullArgument() {
      assertNotNull(classToTest);
      long[] numbersToSum = null;
      Throwable expectedException = assertThrows(IllegalArgumentException.class,
          () -> classToTest.add(numbersToSum));
      assertEquals("Operands argument cannot be null", expectedException.getLocalizedMessage());
    }

  }

}
