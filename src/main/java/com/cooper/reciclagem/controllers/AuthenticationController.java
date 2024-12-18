package com.cooper.reciclagem.controllers;

import com.cooper.reciclagem.dto.AuthenticationDTO;
import com.cooper.reciclagem.dto.LoginResponseDTO;
import com.cooper.reciclagem.dto.RegisterDTO;
import com.cooper.reciclagem.infra.security.TokenService;
import com.cooper.reciclagem.models.Funcionario;
import com.cooper.reciclagem.repositories.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.funcionarioSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Funcionario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = passwordEncoder.encode(data.funcionarioSenha());

        Funcionario newFuncionario = new Funcionario(data.username(), encryptedPassword, data.tipo());

        this.repository.save(newFuncionario);
        return  ResponseEntity.ok().build();
    }
}
