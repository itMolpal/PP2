package web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;
}

