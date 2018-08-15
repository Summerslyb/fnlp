package org.fnlp.nlp.similarity;

import org.fnlp.ml.types.sv.HashSparseVector;

import java.io.Serializable;


public class SparseVectorSimilarity implements ISimilarity<HashSparseVector>, Serializable {

    @Override
    public float calc(HashSparseVector item1, HashSparseVector item2) {
        //return item1.dotProduct(item2);
        return item1.cos(item2);
    }

}
