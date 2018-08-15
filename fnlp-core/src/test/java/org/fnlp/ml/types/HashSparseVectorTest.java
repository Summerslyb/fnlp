/**
 * This file is part of FNLP (formerly FudanNLP).
 * <p>
 * FNLP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * FNLP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with FudanNLP.  If not, see <http://www.gnu.org/licenses/>.
 * <p>
 * Copyright 2009-2014 www.fnlp.org. All rights reserved.
 */

package org.fnlp.ml.types;

import org.fnlp.ml.types.sv.HashSparseVector;
import org.junit.*;

public class HashSparseVectorTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    private HashSparseVector sv;

    @Before
    public void setUp() throws Exception {
        sv = new HashSparseVector();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGet() {
        sv.put(1, 1);
        System.out.println(sv.containsKey(2));
        System.out.println(sv.get(2));
        System.out.println(sv.get(1));
    }

    @Test
    public void testPut() {
        sv.put(1, 1);

    }

}