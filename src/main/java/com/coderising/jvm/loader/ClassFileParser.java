package com.coderising.jvm.loader;

import com.coderising.jvm.clz.AccessFlag;
import com.coderising.jvm.clz.ClassFile;
import com.coderising.jvm.clz.ClassIndex;
import com.coderising.jvm.constant.*;

import java.io.UnsupportedEncodingException;

public class ClassFileParser {

	//解析字节码数组
	public ClassFile parse(byte[] codes) {
		ClassFile classFile = new ClassFile();
		//自定义字节码数组迭代器
		ByteCodeIterator iterator = new ByteCodeIterator(codes);

		String magicNumber = iterator.nextU4ToHexString();
		if (!"cafebabe".equals(magicNumber)) {
			return null;
		}
		classFile.setMagic(magicNumber);
		classFile.setMinorVersion(iterator.nextU2ToInt());
		classFile.setMajorVersion(iterator.nextU2ToInt() );

		ConstantPool pool = parseConstantPool(iterator);
		classFile.setConstantPool(pool);

		AccessFlag flag = parseAccessFlag(iterator);
		classFile.setAccessFlag(flag);

		ClassIndex clzIndex = parseClassIndex(iterator);
		classFile.setClzIndex(clzIndex);

		parseInterfaces(iterator);

		return classFile;
	}
	private void parseInterfaces(ByteCodeIterator iter) {
		int interfaceCount = iter.nextU2ToInt();

		System.out.println("interfaceCount:" + interfaceCount);

		// TODO : 如果实现了interface, 这里需要解析
	}

	private AccessFlag parseAccessFlag(ByteCodeIterator iter) {
		AccessFlag flag = new AccessFlag(iter.nextU2ToInt());
		return  flag;
	}

	private ClassIndex parseClassIndex(ByteCodeIterator iter) {

		int thisClassIndex = iter.nextU2ToInt();
		int superClassIndex = iter.nextU2ToInt();

		ClassIndex classIndex = new ClassIndex();

		classIndex.setThisClassIndex(thisClassIndex);
		classIndex.setSuperClassIndex(superClassIndex);

		return classIndex;
	}

	//解析常量池
	private ConstantPool parseConstantPool(ByteCodeIterator iter) {


		int constantSize =  iter.nextU2ToInt();
		System.out.println("常量池数量:" + constantSize);
		ConstantPool constantPool = new ConstantPool();
		constantPool.addConstantInfo(new NullConstantInfo());


		for (int i = 1; i < constantSize - 1; i++) {
			int tag = iter.nextU1ToInt();
			if (tag == 7) {
				//Class Info
				int utf8Index = iter.nextU2ToInt();
				ClassInfo clzInfo = new ClassInfo(constantPool);
				clzInfo.setUtf8Index(utf8Index);
				constantPool.addConstantInfo(clzInfo);
			} else if (tag == 1) {
				//UTF-8 String
				int len = iter.nextU2ToInt();
				byte[] data = iter.getBytes(len);
				String value = null;
				try {
					value = new String(data, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				UTF8Info utf8Str = new UTF8Info(constantPool);
				utf8Str.setLength(len);
				utf8Str.setValue(value);
			}else if (tag == 8) {
				StringInfo info = new StringInfo(constantPool);
				info.setIndex(iter.nextU2ToInt());
				constantPool.addConstantInfo(info);
			} else if (tag == 9) {
				FieldRefInfo field = new FieldRefInfo(constantPool);
				field.setNameAndTypeIndex(iter.nextU2ToInt());
				constantPool.addConstantInfo(field);
			} else if (tag == 10) {
				// MethodRef
				MethodRefInfo method = new MethodRefInfo(constantPool);
				method.setClassInfoIndex(iter.nextU2ToInt());
				method.setNameAndTypeIndex(iter.nextU2ToInt());
				constantPool.addConstantInfo(method);
			} else if (tag == 12) {
				// Name and Type Info
				NameAndTypeInfo nameType = new NameAndTypeInfo(constantPool);
				nameType.setIndex1(iter.nextU2ToInt());
				nameType.setIndex2(iter.nextU2ToInt());
				constantPool.addConstantInfo(nameType);
			} else {
				throw new RuntimeException("the constant pool tag " + tag + " has not been implemented yet.");
			}
			System.out.println("Finished reading Constant pool ");

			return constantPool;

		}


























//
//		int index = 1;
//		while (iter.hasNext() && index++ < constantSize-1) {
//			constantPool.addConstantInfo(ContantIterUtil.parseType(constantPool, iter));
//		}
		return constantPool;
	}

	
}
