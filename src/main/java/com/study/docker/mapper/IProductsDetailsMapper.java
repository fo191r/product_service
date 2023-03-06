package com.study.docker.mapper;

import com.study.common.model.Product;
import com.study.docker.openapi.model.ProductsDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IProductsDetailsMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    ProductsDetail ToResponse(Product product);

    List<ProductsDetail> dtoToResponse(List<Product> products);

}
