package com.acs.ecommerce.api.model;

import java.util.Date;

public class CategoryModel {

        private Integer id;
        private String name;
        private Date creationDate;

        public CategoryModel() {
        }

        public CategoryModel(Integer id, String name, Date creationDate) {
            this.id = id;
            this.name = name;
            this.creationDate = creationDate;
        }

    public CategoryModel(Integer idCategory) {
        this.id = idCategory;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Date creationDate) {
            this.creationDate = creationDate;
        }
}
