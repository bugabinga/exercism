public class HelloWorld {
    public static String hello(String name) {
        return "Hello, " + (name != null && !name.isEmpty()? name.trim(): "World!");
    }
}