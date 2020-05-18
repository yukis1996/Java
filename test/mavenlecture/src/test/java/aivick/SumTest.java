package aivick;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest
{
    @Test
    void 足し算できること() {
        int actual = Sum.sum(1, 2);
        assertEquals(3, actual);
    }
}
