

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

public class ElectionProcess {
    public enum State { PROGRAMADO, EN_CURSO, CERRADO }

    private Long id;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private State state;
    private String description;
    private OffsetDateTime createdAt;

    private static final Set<State> VALID_STATES = Set.of(State.PROGRAMADO, State.EN_CURSO, State.CERRADO);

    public ElectionProcess(Long id, String type, LocalDate startDate, LocalDate endDate, State state, String description) {
        this.id = id;
        this.type = Objects.requireNonNull(type, "type is required");
        this.startDate = Objects.requireNonNull(startDate, "startDate is required");
        this.endDate = Objects.requireNonNull(endDate, "endDate is required");
        this.state = state == null ? State.PROGRAMADO : state;
        this.description = description == null ? "" : description;
        this.createdAt = OffsetDateTime.now();

        validateDates();
        validateState();
    }

    public ElectionProcess(Long id, String type, LocalDate startDate, LocalDate endDate) {
        this(id, type, startDate, endDate, State.PROGRAMADO, "");
    }

    private void validateDates() {
        LocalDate today = LocalDate.now();
        if (startDate.isBefore(today)) {
            throw new IllegalArgumentException("startDate cannot be earlier than today");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("endDate cannot be earlier than startDate");
        }
    }

    private void validateState() {
        if (!VALID_STATES.contains(this.state)) {
            throw new IllegalArgumentException("Invalid state: " + this.state);
        }
    }

    public void updateState(State newState) {
        if (newState == null || !VALID_STATES.contains(newState)) {
            throw new IllegalArgumentException("Invalid state transition");
        }
        this.state = newState;
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public State getState() { return state; }
    public String getDescription() { return description; }
    public OffsetDateTime getCreatedAt() { return createdAt; }

    public void setDescription(String description) { this.description = description == null ? "" : description; }

    @Override
    public String toString() {
        return "ElectionProcess{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", state=" + state +
                ", createdAt=" + createdAt +
                '}';
    }
}
