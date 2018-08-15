package org.fnlp.demo;

import org.fnlp.demo.nlp.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NLPTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void test() throws Exception {
        ChineseWordSegmentation.main(null);
        PartsOfSpeechTag.main(null);
        DepParser.main(null);
        KeyWordExtraction.main(null);
        NamedEntityRecognition.main(null);
        TimeExpressionRecognition.main(null);
//		AnaphoraResolution.main(null);

    }

}
