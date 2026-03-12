

import java.util.Objects;

public class Municipality {
    private Long id;
    private String name;
    private String code;
    private Long departmentId;

    public Municipality(Long id, String name, String code, Long departmentId) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name is required");
        this.code = Objects.requireNonNull(code, "code is required");
        this.departmentId = Objects.requireNonNull(departmentId, "departmentId is required");
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public Long getDepartmentId() { return departmentId; }

    public void setName(String name) { this.name = Objects.requireNonNull(name); }
    public void setCode(String code) { this.code = Objects.requireNonNull(code); }
    public void setDepartmentId(Long departmentId) { this.departmentId = Objects.requireNonNull(departmentId); }

    @Override
    public String toString() {
        return "Municipality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
