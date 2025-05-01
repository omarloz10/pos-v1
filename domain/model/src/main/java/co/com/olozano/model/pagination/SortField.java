package co.com.olozano.model.pagination;

import lombok.*;

@RequiredArgsConstructor
@Data
@Setter
@Getter
@Builder(toBuilder = true)
public class SortField {
    private final String field;
    private final Direction direction;

    public enum Direction {
        ASC, DESC
    }
}
