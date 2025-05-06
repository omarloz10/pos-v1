package co.com.olozano.model.pagination;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record PaginationResult<T>(List<T> data, int totalPages, long totalElements) {
}
