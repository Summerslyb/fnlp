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

package org.fnlp.nlp.corpus;

import org.fnlp.nlp.pipe.seq.String2Sequence;
import org.fnlp.util.MyStrings;

import java.io.*;

public class Unlabeled {
    public static void processUnLabeledData(String input, String output) throws Exception {
        FileInputStream is = new FileInputStream(input);
        //		is.skip(3); //skip BOM
        BufferedReader r = new BufferedReader(
                new InputStreamReader(is, "utf8"));
        OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(output), "utf8");
        while (true) {
            String sent = r.readLine();
            if (sent == null) break;
            String[][] ss = String2Sequence.genSequence(sent);
            String s = MyStrings.toString(ss, "\n");
            w.write(s);
        }
        w.close();
        r.close();
    }

}