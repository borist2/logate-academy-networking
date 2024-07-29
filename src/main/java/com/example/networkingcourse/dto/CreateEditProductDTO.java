package com.example.networkingcourse.dto;

import com.example.networkingcourse.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEditProductDTO(@NotBlank String name, @NotNull Double price)
{

    public Product toModel()
    {
        var p = new Product();
        p.setName(this.name);
        p.setPrice(this.price);

        return p;
    }
}
