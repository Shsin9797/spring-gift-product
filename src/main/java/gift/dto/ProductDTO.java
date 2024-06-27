package gift.dto;

import gift.entity.Product;

public class ProductDTO {
    private String name,url;
    private int price;

    public ProductDTO(String name, int price, String url) {
        this.name=name;
        this.price=price;
        this.url=url;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public static ProductDTO fromEntity(Product product) {
        return new ProductDTO(product.getName(), product.getPrice(), product.getUrl());
    }
}