package com.micro.service.mapper;


import com.micro.domain.*;
import com.micro.service.dto.BlogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Blog} and its DTO {@link BlogDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BlogMapper extends EntityMapper<BlogDTO, Blog> {



    default Blog fromId(Long id) {
        if (id == null) {
            return null;
        }
        Blog blog = new Blog();
        blog.setId(id);
        return blog;
    }
}
