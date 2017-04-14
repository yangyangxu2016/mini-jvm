package com.coderising.jvm.attr;


import com.coderising.jvm.clz.ClassFile;
import com.coderising.jvm.loader.ByteCodeIterator;

/**
 * 方法内代码表
 *
 * @author xyy
 * @create 2017-04-14 17:28
 **/
public class CodeAttr extends AttributeInfo{

    private int maxStack;
    private int maxLocals;
    private int codeLen;
    private String code;


    private LineNumberTable lineNumTable;
    private LocalVariableTable localVarTable;
    private StackMapTable stackMapTable;


    public CodeAttr(int attrNameIndex, int attrLen, int maxStack, int maxLocals, int codeLen,String code /*ByteCodeCommand[] cmds*/) {
        super(attrNameIndex, attrLen);
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
        this.codeLen = codeLen;
        this.code = code;
        //this.cmds = cmds;
    }



    public String getCode() {
        return code;
    }


    public void setLineNumberTable(LineNumberTable t) {
        this.lineNumTable = t;
    }

    public void setLocalVariableTable(LocalVariableTable t) {
        this.localVarTable = t;
    }
    private void setStackMapTable(StackMapTable t) {
        this.stackMapTable = t;

    }
    public static CodeAttr parse(ClassFile clzFile, ByteCodeIterator iter){


        return null;
    }

}
