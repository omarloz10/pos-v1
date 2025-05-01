package co.com.olozano.model.pagination;

import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class PaginationResult<T> {
    private final List<T> items;
    private final int totalPages;
    private final long totalElements;
}
