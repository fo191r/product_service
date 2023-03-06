package com.study.docker.openapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contain the registered products details
 */

@Schema(name = "GetProductsResponse", description = "Contain the registered products details")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class GetProductsResponse {

  @JsonProperty("data")
  @Valid
  private List<ProductsDetail> data = new ArrayList<>();

  public GetProductsResponse data(List<ProductsDetail> data) {
    this.data = data;
    return this;
  }

  public GetProductsResponse addDataItem(ProductsDetail dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<ProductsDetail> getData() {
    return data;
  }

  public void setData(List<ProductsDetail> data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetProductsResponse getProductsResponse = (GetProductsResponse) o;
    return Objects.equals(this.data, getProductsResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetProductsResponse {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

