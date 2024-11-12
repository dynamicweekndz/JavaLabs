package name;

public class Name {
    private String surname;
    private String firstName;
    private String middleName;

    // Конструктор
    public Name(String surname, String firstName, String middleName) {
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Метод toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (surname != null) sb.append(surname).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (middleName != null) sb.append(middleName);
        return sb.toString().trim();
    }
}
