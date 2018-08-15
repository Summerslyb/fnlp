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

package org.fnlp.nlp.cn.tag;

import org.fnlp.util.MyFiles;
import org.junit.*;

public class POSTaggerTest {
    static String s1;
    static POSTagger pos;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        s1 = MyFiles.loadString("../example-data/data-tag.txt");
        pos = new POSTagger("../models/seg.m", "../models/pos.m");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testTagString() {
        String o1 = pos.tag(s1);
        System.out.println(o1);
    }


}