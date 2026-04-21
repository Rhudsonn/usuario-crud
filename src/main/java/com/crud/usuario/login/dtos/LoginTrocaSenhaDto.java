package com.crud.usuario.login.dtos;

public class LoginTrocaSenhaDto {

    private String senhaAtual;
    private String senhaNova;
    private String senhaConfirmacao;

    public LoginTrocaSenhaDto() {
    }

    public LoginTrocaSenhaDto(String senhaAtual, String senhaNova, String senhaConfirmacao) {
        this.senhaAtual = senhaAtual;
        this.senhaNova = senhaNova;
        this.senhaConfirmacao = senhaConfirmacao;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

    public String getSenhaConfirmacao() {
        return senhaConfirmacao;
    }

    public void setSenhaConfirmacao(String senhaConfirmacao) {
        this.senhaConfirmacao = senhaConfirmacao;
    }
}
