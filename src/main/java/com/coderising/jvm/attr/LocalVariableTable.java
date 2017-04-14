package com.coderising.jvm.attr;

import com.coderising.jvm.loader.ByteCodeIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xyy
 * @create 2017-04-14 17:36
 **/
public class LocalVariableTable extends AttributeInfo{

    List<LocalVariableItem> items = new ArrayList<LocalVariableItem>();

    public LocalVariableTable(int attrNameIndex, int attrLen) {
        super(attrNameIndex, attrLen);
    }

    public static LocalVariableTable parse(ByteCodeIterator iter){

        return null;
    }
    private void addLocalVariableItem(LocalVariableItem item) {
        this.items.add(item);
    }
}
