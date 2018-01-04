package com.reflect;


import java.lang.reflect.*;
import java.util.Date;


/**
 * 反射的基本运用
 *
 * @author 14258
 */
public class TestReflect {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {


        TestReflect test = new TestReflect();

        test.testGetClassObject();
        test.isClassInstance();
        test.testCreatInstance();
        test.testGetFiled();
        test.testGetConstruct();
        test.testGetMethod();
        test.testInvokeMethod();
        test.testCreateArrayByReflect();
    }


    /**
     * 获得Class对象 -三三种方式
     */
    public void testGetClassObject() throws ClassNotFoundException {
        //   1.直接获取某一个对象的class，
        Class<?> clz1 = Date.class;

        Class<?> klass = int.class;//基本数据类型通过自己的属性
        Class<?> classInt = Integer.TYPE;//包装类可以通过Type字段

        // 2. 调用某个对象的getClass()方法,比如:
        Date date = new Date();
        Class<?> clz2 = date.getClass();
        //3. 使用Class类的forName静态方法:
        Class<?> clz3 = Class.forName("java.util.Date");//在JDBC开发中常用此方法加载数据库驱动:

        //判断通过这三种方法获取的类型是否相等
        System.out.println(clz1 == clz2);//ture
        System.out.println(clz2 == clz3);//ture
        System.out.println(clz1.equals(clz2));//ture

        //结果：
        //true
        //true
        //true
    }


    /**
     * 判断是否为某个类的实例
     */
    public void isClassInstance() {
        //一般地，我们用instanceof关键字来判断是否为某个类的实例。
        // 同时我们也可以借助反射中Class对象的isInstance()方法来判断是否为某个类的实例，它是一个Native方法：
        Class user1 = User.class;
        User user2 = new User();
        System.out.println("判断User对象user2是不是Class类型user1的实例：  " + user1.isInstance(user2));

        //    结果：
        //    判断User对象user2是不是Class类型user1的实例：  true
    }


    /**
     * 通过反射来生成对象主要有两种方式
     */
    public void testCreatInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //（1）使用Class对象的newInstance()方法来创建Class对象对应类的实例。
        Class user3 = User.class;
        user3.newInstance();

        //（2）先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建实例。这种方法可以用指定的构造器构造类的实例。
        Class user4 = User.class;
        Constructor userConstructor = user4.getConstructor(String.class, String.class);
        Object o = userConstructor.newInstance("名字", "年龄");
        System.out.println("user4的实例： " + o.toString());

        //结果：
        // user4的实例： User{name='名字', age='年龄', isStudent='null'}
    }


    /**
     * 获取构造器信息-二种方式
     */
    public void testGetConstruct() {

        Class user5 = User.class;
        //1.   all the public constructors of the class represented by this Class object.
        Constructor[] constructors = user5.getConstructors();
        System.out.println("本类中public构造器的个数：  " + constructors.length);
        for (Constructor constructor : constructors) {
            System.out.println("本类中public构造器:  " + constructor);
        }

        //2.   all the constructors declared by the class represented by this   Class  object. These are public, protected,
        // default  (package) access, and private constructors
        Constructor[] constructors1 = user5.getDeclaredConstructors();
        System.out.println("本类中all构造器的个数：  " + constructors1.length);

        for (Constructor constructor : constructors1) {
            System.out.println("本类中all构造器:  " + constructor);
        }

        //    结果：
        //    本类中public构造器的个数：  2
        //    本类中public构造器:  public com.reflect.User(java.lang.String,java.lang.String)
        //    本类中public构造器:  public com.reflect.User()

        //    本类中all构造器的个数：  3
        //    本类中all构造器:  private com.reflect.User(java.lang.String,java.lang.String,java.lang.String)
        //    本类中all构造器:  public com.reflect.User(java.lang.String,java.lang.String)
        //    本类中all构造器:  public com.reflect.User()
    }


    /**
     * 获取类的成员变量（字段）信息 -二种方式
     */
    public void testGetFiled() {

        //访问公有的成员变量，包括继承
        // 1.  all the accessible public fields of the class or interface represented by this  Class object.
        Class c = User.class;
        Field[] pubfields = c.getFields();
        System.out.println("公共的包括继承字段的个数： " + pubfields.length);
        for (Field f : pubfields) {
            System.out.println("公共的包括继承字段名称：  " + f);
        }
        //所有已声明的成员变量。但不能得到其父类的成员变量
        //  2. This includes public, protected, default (package) access, and private fields, but excludes inherited fields.
        Field[] prifields = c.getDeclaredFields();
        System.out.println("本类中所有不包括继承字段的个数： " + prifields.length);
        for (Field f : prifields) {
            System.out.println("本类中所有不包括继承字段名称：  " + f);
        }

        //    结果:
        //    公共的包括继承字段的个数： 2
        //    公共的包括继承字段名称：  public java.lang.String com.reflect.User.isStudent
        //    公共的包括继承字段名称：  public java.lang.String com.reflect.Person.isPerson
        //    本类中所有不包括继承字段的个数： 3
        //    本类中所有不包括继承字段名称：  private java.lang.String com.reflect.User.name
        //    本类中所有不包括继承字段名称：  private java.lang.String com.reflect.User.age
        //    本类中所有不包括继承字段名称：  public java.lang.String com.reflect.User.isStudent

    }

    /**
     * 获取方法 三种方式
     */
    public void testGetMethod() throws NoSuchMethodException {
        Class user5 = User.class;

        //    getMethods()方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
        Method[] methods = user5.getMethods();
        System.out.println("公共的包括继承方法的个数： " + methods.length);
        for (Method m : methods) {
            System.out.println("公共的包括继承方法名称：  " + m);
        }
        //    getDeclaredMethods()方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Method[] declaredMethods = user5.getDeclaredMethods();
        System.out.println("本类中所有不包括继承方法的个数： " + declaredMethods.length);
        for (Method m : declaredMethods) {
            System.out.println("本类中所有不包括继承方法名称：  " + m);
        }

        //    getMethod方法返回一个特定的方法，其中第一个参数为方法名称，后面的参数为方法的参数对应Class的对象
        Method method = user5.getMethod("getName");
        System.out.println(method);

        //结果：
        //公共的包括继承方法的个数： 21
        //公共的包括继承方法名称：  public java.lang.String com.reflect.User.toString()
        //公共的包括继承方法名称：  public java.lang.String com.reflect.User.getName()
        //公共的包括继承方法名称：  public void com.reflect.User.setName(java.lang.String)
        //公共的包括继承方法名称：  public java.lang.String com.reflect.User.getIsStudent()
        //公共的包括继承方法名称：  public java.lang.String com.reflect.User.getAge()
        //公共的包括继承方法名称：  public void com.reflect.User.setIsStudent(java.lang.String)
        //公共的包括继承方法名称：  public void com.reflect.User.setAge(java.lang.String)
        //公共的包括继承方法名称：  public java.lang.String com.reflect.Person.getpName()
        //公共的包括继承方法名称：  public void com.reflect.Person.setIsPerson(java.lang.String)
        //公共的包括继承方法名称：  public java.lang.String com.reflect.Person.getpAge()
        //公共的包括继承方法名称：  public void com.reflect.Person.setpAge(java.lang.String)
        //公共的包括继承方法名称：  public void com.reflect.Person.setpName(java.lang.String)
        //公共的包括继承方法名称：  public java.lang.String com.reflect.Person.getIsPerson()
        //公共的包括继承方法名称：  public final void java.lang.Object.wait() throws java.lang.InterruptedException
        //公共的包括继承方法名称：  public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        //公共的包括继承方法名称：  public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        //公共的包括继承方法名称：  public boolean java.lang.Object.equals(java.lang.Object)
        //公共的包括继承方法名称：  public native int java.lang.Object.hashCode()
        //公共的包括继承方法名称：  public final native java.lang.Class java.lang.Object.getClass()
        //公共的包括继承方法名称：  public final native void java.lang.Object.notify()
        //公共的包括继承方法名称：  public final native void java.lang.Object.notifyAll()
        //本类中所有不包括继承方法的个数： 7
        //本类中所有不包括继承方法名称：  public java.lang.String com.reflect.User.toString()
        //本类中所有不包括继承方法名称：  public java.lang.String com.reflect.User.getName()
        //本类中所有不包括继承方法名称：  public void com.reflect.User.setName(java.lang.String)
        //本类中所有不包括继承方法名称：  public java.lang.String com.reflect.User.getIsStudent()
        //本类中所有不包括继承方法名称：  public java.lang.String com.reflect.User.getAge()
        //本类中所有不包括继承方法名称：  public void com.reflect.User.setIsStudent(java.lang.String)
        //本类中所有不包括继承方法名称：  public void com.reflect.User.setAge(java.lang.String)
        //public java.lang.String com.reflect.User.getName()

    }


    /**
     * 调用方法  当我们从类中获取了一个方法后，我们就可以用invoke()方法来调用这个方法
     */
    public void testInvokeMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> user6 = User.class;

        Object obj = user6.newInstance();

        Method setName = user6.getMethod("setName", String.class);
        Method gerName = user6.getMethod("getName");

        System.out.println("没有调用 setName.invoke(obj, \"小红\")前:    " + gerName.invoke(obj));
        setName.invoke(obj, "小红");
        System.out.println("调用 setName.invoke(obj, \"小红\")后:    " + gerName.invoke(obj));


        //    结果：
        //    没有调用 setName.invoke(obj, "小红")前:    null
        //    调用 setName.invoke(obj, "小红")后:    小红

    }


    /**
     * 利用反射创建数组
     */
    public void testCreateArrayByReflect() throws ClassNotFoundException {
        Class<?> clz = Class.forName("java.lang.String");
        //Array类为java.lang.reflect.Array类。我们通过Array.newInstance()创建数组对象
        Object array = Array.newInstance(clz, 10);
        //  往数组里添加内容
        Array.set(array, 0, "1");
        Array.set(array, 1, "10");
        Array.set(array, 2, "100");
        Array.set(array, 3, "100");
        System.out.println(Array.get(array, 2));

        //    结果：
        //    100

    }


}
