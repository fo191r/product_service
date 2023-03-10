/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.study.docker.openapi.api;

import com.study.docker.openapi.model.CreateProductRequest;
import com.study.docker.openapi.model.CreateProductResponse;
import com.study.docker.openapi.model.GetProductsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "products", description = "the products API")
public interface ProductsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /products : Create the product
     *
     * @param createProductRequest Information to create the product (required)
     * @return A JSON array of user names (status code 200)
     */
    @Operation(
        operationId = "createProduct",
        summary = "Create the product",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A JSON array of user names", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CreateProductResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/products",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<CreateProductResponse> _createProduct(
        @Parameter(name = "CreateProductRequest", description = "Information to create the product", required = true) @Valid @RequestBody CreateProductRequest createProductRequest
    ) {
        return createProduct(createProductRequest);
    }

    // Override this method
    default  ResponseEntity<CreateProductResponse> createProduct(CreateProductRequest createProductRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : \"data\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /products : Return the registered products
     *
     * @return A JSON array of user names (status code 200)
     */
    @Operation(
        operationId = "getProducts",
        summary = "Return the registered products",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A JSON array of user names", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductsResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products",
        produces = { "application/json" }
    )
    default ResponseEntity<GetProductsResponse> _getProducts(
        
    ) {
        return getProducts();
    }

    // Override this method
    default  ResponseEntity<GetProductsResponse> getProducts() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : [ { \"price\" : 0.8008281904610115, \"name\" : \"name\", \"id\" : \"id\" }, { \"price\" : 0.8008281904610115, \"name\" : \"name\", \"id\" : \"id\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
