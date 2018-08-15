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

package org.fnlp.train.pos;

import org.fnlp.ml.types.alphabet.AlphabetFactory;
import org.fnlp.ml.types.alphabet.AlphabetFactory.Type;
import org.fnlp.ml.types.alphabet.IFeatureAlphabet;
import org.fnlp.ml.types.alphabet.LabelAlphabet;
import org.fnlp.nlp.pipe.Pipe;
import org.fnlp.nlp.pipe.SeriesPipes;
import org.fnlp.nlp.pipe.Target2Label;
import org.fnlp.nlp.pipe.seq.Sequence2FeatureSequence;
import org.fnlp.nlp.pipe.seq.templet.*;
import org.fnlp.nlp.tag.AbstractTagger;
import org.fnlp.ontology.CharClassDictionary;

/**
 * 序列标注器训练和测试程序
 *
 * @author xpqiu
 *
 */
public class POSTrain extends AbstractTagger {


    public Pipe createProcessor() throws Exception {

        templets = new TempletGroup();
        templets.load(templateFile);
        for (Templet templet : templets) {
            ((BaseTemplet) templet).minLen = 5;
        }
        // Dictionary d = new Dictionary();
        // d.loadWithWeigth("D:/xpqiu/项目/自选/CLP2010/CWS/av-b-lut.txt",
        // "AV");
        // templets.add(new DictionaryTemplet(d, gid++, -1, 0));
        // templets.add(new DictionaryTemplet(d, gid++, 0, 1));
        // templets.add(new DictionaryTemplet(d, gid++, -1,0, 1));
        // templets.add(new DictionaryTemplet(d, gid++, -2,-1,0, 1));

        templets.add(new CharInStringTemplet(templets.gid++, -1, 1));
        templets.add(new CharInStringTemplet(templets.gid++, 0, 1));
        templets.add(new CharInStringTemplet(templets.gid++, -2, 2));
        templets.add(new StringTypeTemplet(templets.gid++));

        CharClassDictionary dsurname = new CharClassDictionary();
        dsurname.load("../data/knowledge/百家姓.txt", "姓");
        templets.add(new CharClassTemplet(templets.gid++, new CharClassDictionary[]{dsurname}));

        if (cl != null)
            factory = cl.getAlphabetFactory();
        else
            factory = AlphabetFactory.buildFactory();

        //TODO: 修改字典类型
        AlphabetFactory.defaultFeatureType = Type.String;
        /**
         * 标签转为0、1、2、...
         */
        LabelAlphabet labels = factory.DefaultLabelAlphabet();

        // 将样本通过Pipe抽取特征
        IFeatureAlphabet features = factory.DefaultFeatureAlphabet();
        featurePipe = new Sequence2FeatureSequence(templets, features, labels);

        Pipe pipe = new SeriesPipes(new Pipe[]{new Target2Label(labels), featurePipe});
        return pipe;
    }
}