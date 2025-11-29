package com.felipemovio.chat.security;

import java.util.List;

public record JWTUserData(Long userId, String email, List<String> roles ) {
}
