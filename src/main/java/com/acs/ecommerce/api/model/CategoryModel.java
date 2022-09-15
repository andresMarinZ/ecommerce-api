package com.acs.ecommerce.api.model;

import java.util.Date;

public class CategoryModel {

        public String getIdProduct;
        private Long id;
        private String name;
        private Date creationDate;

        public CategoryModel() {
        }

        public CategoryModel(Long id, String name, Date creationDate) {
            this.id = id;
            this.name = name;
            this.creationDate = creationDate;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
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
