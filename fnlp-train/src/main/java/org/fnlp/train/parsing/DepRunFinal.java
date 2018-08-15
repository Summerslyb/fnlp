package org.fnlp.train.parsing;

import org.fnlp.nlp.parser.dep.train.JointParerTrainer;
import org.fnlp.train.tag.ModelOptimization;
import org.fnlp.util.MyFiles;

public class DepRunFinal {

    public static void main(String[] args) throws Exception {

        String datapath = "../data";
        String model = "../models/dep.m";
        //合并训练文件

        String allfile = datapath + "/FNLPDATA/all.dep";
        MyFiles.delete(allfile);
        String testfile = datapath + "/FNLPDATA/test.dep";
        String trainfile = datapath + "/FNLPDATA/train.dep";


        MyFiles.combine(allfile, trainfile, testfile);


        JointParerTrainer trainer = new JointParerTrainer(model);
        int maxite = 100;
        float c = 0.01f;
        trainer.train(allfile, maxite, c);

        float thres = 1.0E-3f;
        ModelOptimization op = new ModelOptimization(thres);
        op.optimizeDep(model);

    }

}
