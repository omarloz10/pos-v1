package co.com.olozano.model.pagination;

import lombok.*;


@RequiredArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class PaginationQuery {
    private final int page;
    private final int size;
}
