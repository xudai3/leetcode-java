package com.xd.leetcode.solutions;

import com.xd.leetcode.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class _399_EvaluateDivisionTest {
    _399_EvaluateDivision e;
    Utils u;
    String[][][] equations;
    double[][] values;
    String[][][] queries;
    double[][] expect;

    _399_EvaluateDivisionTest() {
        e = new _399_EvaluateDivision();
        u = new Utils();
        equations = new String[][][]{{{"a", "b"}, {"b", "c"}}, {{"a", "b"}, {"b", "c"}, {"bc", "cd"}}, {{"a", "b"}}};
        values = new double[][]{{2.0, 3.0}, {1.5, 2.5, 5.0}, {0.5}};
        queries = new String[][][]{
                {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}},
                {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}},
                {{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}}};
        expect = new double[][]{{6.0, 0.5, -1.0, 1.0, -1.0}, {3.75, 0.4, 5.0, 0.2}, {0.5, 2.0, -1.0, -1.0}};
    }

    @Test
    void calcEquation() {
        for (int i = 0; i < equations.length; i++) {
            List equation = u.twoDStringArrayToList(equations[i]);
            List query = u.twoDStringArrayToList(queries[i]);
            assertTrue(u.doubleArrayEquals(e.calcEquation(equation, values[i], query), expect[i]));
        }
    }
}