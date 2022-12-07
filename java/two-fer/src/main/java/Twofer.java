class Twofer {
    String twofer(String name) {
        final String subject = name == null || name.isBlank() ? "you" : name;
        return String.format("One for %s, one for me.", subject);
    }
}
