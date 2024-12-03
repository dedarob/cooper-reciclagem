package com.cooper.reciclagem.dto;

import com.cooper.reciclagem.enums.Permissao;

public record RegisterDTO(String username, String funcionarioSenha, Permissao tipo) {
}
