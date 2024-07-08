package com.ecommerce.pixelthreads.persistence.dto;

import com.ecommerce.pixelthreads.persistence.model.OrderProduct;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequest {
    private List<ProductOrder> orderProducts;
}
