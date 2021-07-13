package com.example.androidtesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MathUtilityTest {
    @Ignore
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    //add over here---mathUtility class

    @Test
    fun testMathUtilityAdd(){
        //first create the object of this class
        val utility = MathUtility()
        val addResult = utility.add(10,20)

        assertEquals("add() did not work",30, addResult)/////expected, actual---it will check are they equal or not

    }

    @Test
    fun testEven() {
        val utility = MathUtility()
        val isEven = utility.isEven(20)

        assertTrue("20 is even",isEven)
    }

    @Test
    fun multiply(){
        val utility = MathUtility()
        val product = utility.multiply(10,0)
        assertEquals("Multiplication with 0 is always 0",0, product)
    }
}