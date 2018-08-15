package org.fnlp.demo;

import org.fnlp.demo.ml.HierClassifierUsage1;
import org.fnlp.demo.ml.HierClassifierUsage2;
import org.fnlp.demo.ml.SequenceLabeling;
import org.fnlp.demo.ml.SimpleClassifier2;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MLTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void test() throws Exception {
        System.out.println("SequenceLabeling: ");
        SequenceLabeling.main(null);

        System.out.println("SimpleClassifier2: ");
        SimpleClassifier2.main(null);

        System.out.println("HierClassifierUsage1: ");
        HierClassifierUsage1.main(null);

        System.out.println("HierClassifierUsage2: ");
        HierClassifierUsage2.main(null);
    }

}
