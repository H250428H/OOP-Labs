import java.util.List;
import java.util.Objects;

public final class ImmutablePerson {

    private final String name;
    private final int age;
    private final List<String> languages;

    public ImmutablePerson(String name, int age, List<String> languages) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Unrealistic age: " + age);
        }
        this.name = name.trim();
        this.age = age;

        this.languages = List.copyOf(languages);
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public List<String> getLanguages() { return languages; }

    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge, languages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutablePerson other)) return false;
        return age == other.age && name.equals(other.name) && languages.equals(other.languages);
    }

    @Override
    public int hashCode() { return Objects.hash(name, age, languages); }

    @Override
    public String toString() { return name + " (" + age + ") speaks " + languages; }
}
