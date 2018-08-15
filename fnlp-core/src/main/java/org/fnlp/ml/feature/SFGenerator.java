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

package org.fnlp.ml.feature;

import org.fnlp.ml.types.Instance;
import org.fnlp.ml.types.sv.BinarySparseVector;
import org.fnlp.ml.types.sv.ISparseVector;

/**
 * 结构化特征生成类
 *
 * @version Feb 16, 2009
 */
public class SFGenerator extends Generator {

    private static final long serialVersionUID = 6404015214630864081L;

    /**
     * 构造函数
     */
    public SFGenerator() {
    }

    @Override
    public ISparseVector getVector(Instance inst, Object label) {
        int[] data = (int[]) inst.getData();
        ISparseVector fv = new BinarySparseVector(data.length);
        for (int i = 0; i < data.length; i++) {
            int idx = data[i] + (Integer) label;
            fv.put(idx);
        }
        return fv;
    }
}