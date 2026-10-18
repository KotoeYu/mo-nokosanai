package jp.co.developersb.dto.chapter5_dto;

public record ProductResponse5(
        Long id,
        String name,
        String category,
        Integer quantity,
        String expiryDate,
        String memo
) {}