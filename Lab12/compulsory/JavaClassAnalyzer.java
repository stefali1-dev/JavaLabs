package org.example;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import org.junit.Test;

public class JavaClassAnalyzer {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the path to the .class file:");

        String classFilePath = scanner.nextLine();
        File classFile = new File(classFilePath);

        if (!classFile.exists() || !classFile.isFile()) {
            System.out.println("Invalid file path: " + classFilePath);
            return;
        }

        // Get the directory containing the .class file
        String directoryPath = classFile.getParent();
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File(directoryPath).toURI().toURL()});

        // Extract package and class name from the file path
        String packageName = getPackageName(classFile);
        String className = classFile.getName().replace(".class", "");

        // Load the class dynamically
        Class<?> loadedClass = classLoader.loadClass(packageName + "." + className);

        // Display the class name and package
        System.out.println("Class Name: " + className);
        System.out.println("Package: " + packageName);

        // Extract and display method information
        Method[] methods = loadedClass.getDeclaredMethods();
        System.out.println("\nMethods:");
        for (Method method : methods) {
            System.out.println(method.toString());
        }

        // Invoke static methods annotated with @Test
        System.out.println("\nRunning tests...");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0) {
                if (method.getReturnType() == void.class) {
                    System.out.println("Running test: " + method.getName());
                    method.invoke(null);
                } else {
                    System.out.println("Skipping test: " + method.getName() + " (Test method must have a void return type.)");
                }
            }
        }
    }

    private static String getPackageName(File classFile) {
        String filePath = classFile.getAbsolutePath();
        int packageIndex = filePath.lastIndexOf(File.separator + "classes" + File.separator) + 9;
        int classIndex = filePath.lastIndexOf(File.separator);
        return filePath.substring(packageIndex, classIndex).replace(File.separator, ".");
    }
}
