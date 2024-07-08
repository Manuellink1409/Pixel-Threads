package com.ecommerce.pixelthreads.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> list;
    private int size;
    private int page;
    private int total;
    private boolean isLast;
    private boolean isFirst;

}
