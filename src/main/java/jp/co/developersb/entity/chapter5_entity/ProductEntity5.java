package jp.co.developersb.entity.chapter5_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "productinfo")
public class ProductEntity5 {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer quantity;

    private String expiryDate;

    private String memo;

    protected ProductEntity5() {
    }

    public ProductEntity5(String name, String category, Integer quantity,
                          String expiryDate, String memo) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.memo = memo;
    }

    public void update(String name, String category, Integer quantity,
                       String expiryDate, String memo) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.memo = memo;
    }
}
