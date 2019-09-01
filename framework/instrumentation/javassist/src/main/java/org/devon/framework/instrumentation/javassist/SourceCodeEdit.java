package org.devon.framework.instrumentation.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import sun.management.MethodInfo;

/**
 * @author Devonmusa
 * @date 2019/9/1 1:33
 * @since
 */
public class SourceCodeEdit {

    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ctClass = pool.get("org.devon.framework.instrumentation.javassist.ByteCodeEdit");
            CtClass voidCtClass = pool.get("java.lang.Void");
            CtClass[]  arrayCtClass= pool.get(new String[]{"java.lang.String","java.lang.Integer"});
            CtMethod ctMethod = new CtMethod(voidCtClass,"test",arrayCtClass,ctClass);
            ctClass.addMethod(ctMethod);
            CtClass stringCtClass = pool.get("java.lang.String");
            CtField ctField = new CtField(stringCtClass, "addField", ctClass);
            ctField.setAttribute("addField","dewen".getBytes());
            ctClass.addField(ctField);
            ctClass.writeFile("framework/instrumentation/javassist/src/main/java");
            Class<?> clazz =  ctClass.toClass();
          //  ByteCodeEdit codeEdit = (ByteCodeEdit) clazz.newInstance();
           // System.out.println(codeEdit);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
