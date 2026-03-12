

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Department {
    private Long id;
    private String name;
    private String code;
    private final List<Municipality> municipalities = new ArrayList<>();

    public Department(Long id, String name, String code) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name is required");
        this.code = Objects.requireNonNull(code, "code is required");
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }

    public void setName(String name) { this.name = Objects.requireNonNull(name); }
    public void setCode(String code) { this.code = Objects.requireNonNull(code); }

    /**
     * Añade un municipio al departamento. Valida unicidad del código dentro del departamento.
     */
    public void addMunicipality(Municipality m) {
        Objects.requireNonNull(m, "municipality is required");
        boolean exists = municipalities.stream().anyMatch(x -> x.getCode().equals(m.getCode()));
        if (exists) {
            throw new IllegalArgumentException("Municipality code must be unique within the department");
        }
        municipalities.add(m);
    }

    public List<Municipality> listMunicipalities() {
        return Collections.unmodifiableList(municipalities);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", municipalitiesCount=" + municipalities.size() +
                '}';
    }
}
