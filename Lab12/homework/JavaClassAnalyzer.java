import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.junit.Test;

public class JavaClassAnalyzer {

    private static final String CLASS_FILE_EXTENSION = ".class";
    private static final String JAR_FILE_EXTENSION = ".jar";

    private static final Map<Class<?>, Object> MOCK_VALUES = createMockValues();

    private static Map<Class<?>, Object> createMockValues() {
        // Map to store mock values for different types
        Map<Class<?>, Object> mockValues = new HashMap<>();
        mockValues.put(int.class, 0);       // Mock value for int
        mockValues.put(Integer.class, 0);   // Mock value for Integer
        mockValues.put(String.class, "");   // Mock value for String
        // Add more mock values for other primitive types if needed
        return mockValues;
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please provide the path to the .class file or directory as an argument.");
            return;
        }

        String inputPath = args[0];
        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("Invalid file or directory path: " + inputPath);
            return;
        }

        List<Class<?>> classes = new ArrayList<>();
        processInputFile(inputFile, classes);

        // Analyze and test the classes
        for (Class<?> clazz : classes) {
            System.out.println("Class Name: " + clazz.getSimpleName());
            System.out.println("Package: " + clazz.getPackage().getName());

            // Extract and display method information
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println(method.toString());
            }

            // Invoke methods annotated with @Test
            System.out.println("\nRunning tests...");
            int testCount = 0;
            int successfulCount = 0;
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    System.out.println("\nRunning test: " + method.getName());
                    if (invokeTestMethod(clazz, method)) {
                        successfulCount++;
                    }
                    testCount++;
                }
            }
            System.out.println("\nTest Statistics:");
            System.out.println("Total Tests: " + testCount);
            System.out.println("Successful Tests: " + successfulCount);
            System.out.println("Failed Tests: " + (testCount - successfulCount));
        }
    }

    private static void processInputFile(File inputFile, List<Class<?>> classes) throws Exception {
        if (inputFile.isFile()) {
            String fileName = inputFile.getName();
            if (fileName.endsWith(CLASS_FILE_EXTENSION)) {
                // Process single .class file
                String className = fileName.replace(CLASS_FILE_EXTENSION, "");
                URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{inputFile.toURI().toURL()});
                Class<?> loadedClass = classLoader.loadClass(className);
                classes.add(loadedClass);
            } else if (fileName.endsWith(JAR_FILE_EXTENSION)) {
                // Process .jar file
                processJarFile(inputFile, classes);
            }
        } else if (inputFile.isDirectory()) {
            // Process directory recursively
            File[] files = inputFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    processInputFile(file, classes);
                }
            }
        }
    }

    private static void processJarFile(File jarFile, List<Class<?>> classes) throws Exception {
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{jarFile.toURI().toURL()});
        JarFile jar = new JarFile(jarFile);
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String entryName = entry.getName();
            if (entryName.endsWith(CLASS_FILE_EXTENSION)) {
                // Process class file in the jar
                String className = entryName.replace(CLASS_FILE_EXTENSION, "").replace("/", ".");
                Class<?> loadedClass = classLoader.loadClass(className);
                classes.add(loadedClass);
            }
        }
        jar.close();
    }

    private static boolean invokeTestMethod(Class<?> clazz, Method method) {
        try {
            if (method.getParameterCount() == 0) {
                if (method.getReturnType() == void.class) {
                    // Invoke static test method with no arguments
                    method.setAccessible(true);
                    method.invoke(null);
                    System.out.println("Test passed.");
                    return true;
                } else {
                    System.out.println("Skipping test: " + method.getName() + " (Test method must have a void return type.)");
                }
            } else {
                System.out.println("Skipping test: " + method.getName() + " (Test method must have no arguments.)");
            }
        } catch (Exception e) {
            System.out.println("Test failed. Exception: " + e.getMessage());
        }
        return false;
    }

    // Additional methods for generating mock values for primitive types and String
    private static Object generateMockValue(Class<?> type) {
        return MOCK_VALUES.get(type);
    }
}
