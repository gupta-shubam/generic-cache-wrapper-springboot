package com.example.shubam.inmemorycache2k.inmemorycache.utils;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TypeUtils {

    public static Type getTypeFromTypeName(String typeName) {
        try {
            return TypeToken.get(Class.forName(typeName)).getType();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class not found for type name: " + typeName, e);
        }
    }

    public static Class<?> resolveType(String typeName) {
        try {
            return Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Class not found for type name: " + typeName, e);
        }
    }
}
