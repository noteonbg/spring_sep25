package a10testing.model;



public class Patient {
    private Long id;
    private String name;
    private int age;

    public Patient(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}

