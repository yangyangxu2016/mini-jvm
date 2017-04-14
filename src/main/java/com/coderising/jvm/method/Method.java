package com.coderising.jvm.method;

import com.coderising.jvm.attr.CodeAttr;
import com.coderising.jvm.clz.ClassFile;
import com.coderising.jvm.loader.ByteCodeIterator;

/**
 * 方法
 *
 * @author xyy
 * @create 2017-04-14 17:18
 **/
public class Method {


    private int accessFlag;
    private int nameIndex;
    private int descriptorIndex;

    private CodeAttr codeAtrr;
    private ClassFile classFile;

    public int getAccessFlag() {
        return accessFlag;
    }

    public Method setAccessFlag(int accessFlag) {
        this.accessFlag = accessFlag;
        return this;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public Method setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
        return this;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public Method setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
        return this;
    }

    public CodeAttr getCodeAtrr() {
        return codeAtrr;
    }

    public Method setCodeAtrr(CodeAttr codeAtrr) {
        this.codeAtrr = codeAtrr;
        return this;
    }

    public ClassFile getClassFile() {
        return classFile;
    }

    public Method setClassFile(ClassFile classFile) {
        this.classFile = classFile;
        return this;
    }


    public Method(int accessFlag, int nameIndex, int descriptorIndex, ClassFile classFile) {
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.classFile = classFile;
    }

    public static Method parse(ClassFile clzFile, ByteCodeIterator iterator){
        return null;

    }
}
