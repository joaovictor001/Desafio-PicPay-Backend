package com.picpaybackend.picpaybackend.dtos.Trasaction;

import java.math.BigDecimal;

public record TrasactionCreateDTO(BigDecimal value,Long senderId, Long receiverId) {
}
