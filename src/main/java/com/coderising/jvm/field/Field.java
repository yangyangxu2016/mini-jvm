package com.coderising.jvm.field;

import com.coderising.jvm.constant.ConstantPool;
import com.coderising.jvm.loader.ByteCodeIterator;

/**
 * 字段
 *
 * @author xyy
 * @create 2017-04-14 17:17
 **/
public class Field {

    private int accessFlag;
    private int descriptorIndex;
    private int nameIndex;


    private ConstantPool pool;

    public Field(int accessFlag, int descriptorIndex, int nameIndex, ConstantPool pool) {
        this.accessFlag = accessFlag;
        this.descriptorIndex = descriptorIndex;
        this.nameIndex = nameIndex;
        this.pool = pool;
    }


    //解析常量池
    public static Field parse(ConstantPool pool, ByteCodeIterator iterator) {

        return null;
    }
}
