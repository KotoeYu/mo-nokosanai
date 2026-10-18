package jp.co.developersb.dto.chapter5_dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest5(
        @NotBlank(message = "名前を入力してください")
        String name,

        @NotBlank(message = "種類を入力してください")
        String category,

        @NotNull(message = "数量を入力してください")
        @Min(value = 1, message = "数量は1以上で入力してください")
        Integer quantity,

        String expiryDate,

        String memo
) {}