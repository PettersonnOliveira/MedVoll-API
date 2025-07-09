package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.CEP();
        this.cidade = dados.cidade();
        this.uf = dados.UF();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.CEP() != null) {
            this.cep = dados.CEP();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.UF() != null) {
            this.uf = dados.UF();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
    }

    // Getters and setters can be added here if needed
}
