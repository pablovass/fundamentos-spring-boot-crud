package com.pablovass.mapper;

import com.pablovass.domain.Category;
import com.pablovass.entity.Categoria;
import org.mapstruct.*;


@Mapper(componentModel = "spring",uses = {Categoria.class,Category.class})
public interface CategoryMapper {
    @Mappings({
         @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}