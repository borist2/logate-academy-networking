package com.example.networkingcourse.model.projections;

import org.springframework.beans.factory.annotation.Value;

public interface UserNameEmailConcatenatedProjection
{
    @Value("#{target.name + ' ' + target.email}")
    String getNameAndEmailTogether();
}
