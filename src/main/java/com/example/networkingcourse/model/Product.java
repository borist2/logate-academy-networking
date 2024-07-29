package com.example.networkingcourse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (!(o instanceof Product product)) return false;

        return new EqualsBuilder().append(id, product.id).append(name, product.name).append(price, product.price).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(price).toHashCode();
    }
}
