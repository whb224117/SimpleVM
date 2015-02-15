package com.annimon.simplevm;

import com.annimon.simplevm.lib.NativeMethod;
import java.util.HashMap;
import java.util.Map;

/**
 * Program structure
 * @author aNNiMON
 */
public class Program {
    
    private final Map<String, Method> methods;
    private final Map<String, NativeMethod> nativeMethods;
    private final ConstantPool constantPool;
    private final int numFields;

    public Program() {
        this(5, 0);
    }
    
    public Program(int constantPoolSize) {
        this(constantPoolSize, 0);
    }
    
    public Program(int constantPoolSize, int numFields) {
        this(new ConstantPool(constantPoolSize), numFields);
    }
    
    public Program(ConstantPool constantPool, int numFields) {
        this.methods = new HashMap<>();
        this.nativeMethods = new HashMap<>();
        this.constantPool = constantPool;
        this.numFields = numFields;
    }
    
    public int getNumFields() {
        return numFields;
    }
    
    public void addMethod(String name, byte[] instructions, int numLocals) {
        methods.put(name, new Method(name, instructions, numLocals));
    }
    
    public Method getMethod(String name) {
        return methods.get(name);
    }
    
    public void addNativeMethod(String name, NativeMethod method) {
        nativeMethods.put(name, method);
    }
    
    public NativeMethod getNativeMethod(String name) {
        return nativeMethods.get(name);
    }

    public Constant getConstant(int addr) {
        return constantPool.get(addr);
    }

    public void setConstant(int addr, Constant value) {
        constantPool.set(addr, value);
    }
}