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

package org.fnlp.nlp.similarity;

import org.fnlp.data.reader.StringReader;
import org.fnlp.nlp.similarity.train.WordCluster;
import org.junit.*;

import java.io.IOException;

public class WordClusterTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
    public void testStartClustering() {
        WordCluster wc = new WordCluster();
        wc.slotsize = 6;
        String[] strs = new String[]{"猪肉", "狗肉", "狗头", "鸡头", "猪头", "鸡肉"};
        StringReader r = new StringReader(strs);
        wc.read(r);

        try {
            Cluster root = wc.startClustering();
            DrawTree.printTree(root, "../tmp/t.png");
            wc.saveModel("../tmp/t.m");
            wc.saveTxt("../tmp/t.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}